'''
Created on 2013-11-29

@author: Mian
'''
import _thread, sys, os, time
from socket import *
import random

class Peer:
    #peer filepath(arg1) server(arg2) 
    def __init__(self,arg):
       
        self.path = arg[1]
        self.serverip = arg[2]
        self.serverport = 8001
        self.localserport = 9000
        self.localip = gethostbyname(gethostname())
        self.localadd = (gethostbyname(gethostname()), self.localserport)
        self.mypeer = []
        self.myfile = []
        self.buffsize = 1024
        
    def register(self):
        # register self in server to join p2p
        socket1 = socket(AF_INET, SOCK_STREAM)
        try:
            socket1.connect((self.serverip, self.serverport))
        except error:
            print ('connect to server failed')
            return False
        dataout = 'register'+' '+ str(self.localserport)
        print (dataout) #tell server my server port
        socket1.send(dataout.encode())
        print ('connecting to server')
        
        while True:
            datain = (socket1.recv(self.buffsize)).decode()
            if datain == "You are the only one peer in system":
                print (datain)
                socket1.close()
                return True
            elif datain == "duplicate register is not allowed":
                print (datain)
                socket1.close()
                return False
            else:
                peerinfo = datain.split(' ')
                socket1.close()
                
                if self.peerconnect((peerinfo[0], int(peerinfo[1]))):
                    print ('We have a new peer:')
                    print (peerinfo)
                    return True
                else:
                    print ('connect to peer failed')
                    return False
                    
                
    def peerconnect(self, peerinfo):
        #according to returned peerinfo by server, build peer pair with neighbor
        socket2 = socket(AF_INET, SOCK_STREAM)
        try:
            socket2.connect(peerinfo)
        except error:
            print ('connect to peer failed')
            return False
        
        dataout = 'peer'+' '+str(self.localserport) #tell neighbor my server port
        socket2.send(dataout.encode())
        print ('connecting to peer: ')
        print (peerinfo)
        
        while True:
            datain = socket2.recv(self.buffsize)
            if datain.decode() == "successful":
                socket2.close()
                print ('connect to peer successfully:' )
                self.mypeer.append(peerinfo)
                print (peerinfo)
                return True
            else:
                socket2.close()
                return False
    
    def incomimgpeer(self, data, address, socket):
        #handle peer's join request, data like 'peer'+' '+peer's localserport
        print (address[0] + ' is going to peer, its local service port is '+ data[1])
        self.mypeer.append((address[0], int(data[1])))
        socket.send(('successful').encode())
        print (address[0] + ' peer successfully')
    
        
    def get(self, filename):
        #get a file from peer
        dataout = 'get' + ' ' + filename + ' ' + str(self.localserport)
        print (dataout)
        for peer in self.mypeer:
            socket3 = socket(AF_INET, SOCK_STREAM)
            socket3.connect(peer)
            socket3.send(dataout.encode())
            print ('send request for ' + filename)
            print (peer)
            socket3.close()
        print ('Send all peers for ' + filename)
        time.sleep(5)
        if filename not in os.listdir(self.path):
            print ("Sorry, get file time out")
        
    def incomingget(self, data, address):
        #handle get request from peer,  data like 'get filename self.localadd'
        #When length=3, this is the peer of origin, add two arguments if has not the file and flood
        print ("The length of argument is " + str(len(data)))
        if len(data) == 3:
            if data[1] in os.listdir(self.path):
                print ('has the file ' + data[1])
                self.share(data[1], (address[0], int(data[2])))
            else:
                flood = self.mypeer[:]
                flood.remove((address[0], int(data[2])))  #remove the sender
                newdata = data[0] + ' ' + data[1] + ' ' +  address[0] + ' ' + data[2] +' ' + str(self.localserport) #reconstruct the command: get filename origin_ip origin_port lasthop_port
                print (newdata)
                print ("I am the second peer but I have no file, transfer to other peers")
                for peer in flood:
                    socket4 = socket(AF_INET, SOCK_STREAM)
                    socket4.connect(peer)
                    socket4.send(newdata.encode())  #keep the request source ip+port unmodified
                    print ('do not have the file, flood to: ')
                    print (peer)
                    socket4.close()
        #When length=5, this is the third or more far to origin, direct transfer file to origin if has file
        elif len(data) == 5:
            print ("I am the third or further peer, now I will check file")
            if data[1] in os.listdir(self.path):
                print ('has the file ' + data[1])
                self.share(data[1], (data[2], int(data[3])))
            else:
                flood = self.mypeer[:]
                flood.remove((address[0], int(data[4]) )) #remove the sender
                for peer in flood:
                    socket4 = socket(AF_INET, SOCK_STREAM)
                    socket4.connect(peer)
                    socket4.send(data.encode())  #keep the request source ip+port unmodified
                    print ('do not have the file, flood to: ')
                    print (peer)
                    socket4.close()
        
        
    def share(self, filename, address):
        #transfer a local file to peer with the address, like 'share filename peeraddress peerport
        dataout = 'share' + ' ' + filename
        socket5 = socket(AF_INET, SOCK_STREAM)
        socket5.connect(address)
        socket5.send(dataout.encode())   
        print ('share request sent out')

        datain = socket5.recv(self.buffsize)
        if datain.decode() == "ok":
            path = self.path + '/' + filename
            filestream = open(path, 'rb')
            while True:
                datafile = filestream.read(self.buffsize)
                if not datafile:
                    break
                socket5.send(datafile)
            filestream.close()
            print ("file "+ filename + " is shared to: ")
            print (address)
        else:
            print ("the peer do not accept")
            
        socket5.close()    
        
    def incomingshare(self, data, address, socket):
        #handle the share request from peer
        #data like 'share filename peeraddress, address is origin add
        path = self.path + '/' + data[1]
        filestream = open(path, 'wb')
        
        socket.send('ok'.encode())
        while True:
            datain = socket.recv(self.buffsize)
            if not datain:
                break
            filestream.write(datain)
        filestream.close()
        socket.close()
        print ("get a new file "+ data[1] +" from:")
        print (address)
            
    def listfile(self):
        print(os.listdir(self.path))
        
    def listpeer(self):
        for peer in self.mypeer:
            print (peer)
        
    def quit(self):
        #quit the p2p network, the command is 'quit
        dataout = "quit" + " " + str(self.localserport)
        flood = self.mypeer[:]
        flood.append((self.serverip, self.serverport))
        alllist = flood[:]
        for peer in flood:
            socket6 = socket(AF_INET, SOCK_STREAM)
            socket6.connect(peer)
            socket6.send(dataout.encode())
            while True:
                datain = socket6.recv(self.buffsize)
                if (datain.decode() == "quit successfully"):
                    alllist.remove(peer)
                    if peer != (self.serverip, self.serverport):
                        self.mypeer.remove(peer)
                    print ("disconnected successfully from")
                    print (peer)
                    break
                else:
                    print ("disconnected failed from")
                    print (peer)
                    break
            socket6.close()
        if (alllist == []):
            print ("quit successfully")
        else:
            print ("quit not completely in: ")
            print (alllist)
    
    def incomingquit(self, address, socket, data):    
        #handle a peer quit 
        self.mypeer.remove((address[0], int(data[1])))
        socket.send(("quit successfully").encode())
        
    def localrequest(self):
        '''
        handle command in local console like: 
        get filename
        share filename peerhost peerport
        listfile           #list the shared files in local
        listpeer           #list all peers' info           
        quit  
        '''
        while True:
            prompt = "Please input command, like \"get filename\", \"share filename peerhost<ip> peerport<port>\", \"listfile\", \"listpeer\" \n"
            command = input(prompt)
            command = command.split(' ')
            if command[0] == 'get':
                self.get(command[1])
            elif command[0] == 'share':
                address = (command[2], int(command[3]))
                self.share(command[1], address)
            elif command[0] == 'listfile':
                self.listfile()
            elif command[0] == 'listpeer':
                self.listpeer()
            elif command[0] == 'quit':
                self.quit()
        
    def remoterequest(self):
        #handle peer's request like: get, share, quit, peer
        socket1 = socket(AF_INET, SOCK_STREAM)
        socket1.bind(('', self.localserport))
        socket1.listen(10)
        
        while True:
            peer_socket, peer_add = socket1.accept()
            print (list(peer_add)[0]+' '+str(list(peer_add)[1])+' is connected')
            while True:
                datain = peer_socket.recv(self.buffsize)
                datain = datain.decode().split(' ')
                if not datain:
                    break
                if datain[0] == 'peer':
                    self.incomimgpeer(datain, peer_add, peer_socket)
                    break
                elif datain[0] == 'get':
                    self.incomingget(datain, peer_add)
                    break
                elif datain[0] == 'share':
                    self.incomingshare(datain, peer_add, peer_socket)
                    break
                elif datain[0] == 'quit':
                    self.incomingquit(peer_add, peer_socket, datain)
                    break
                else:
                    print (datain)
                    break
            peer_socket.close()
            
        socket1.close()
        
        
if __name__ == '__main__':
        peer = Peer(sys.argv)
        if  peer.register() == True:
            print ('joined p2p network successfully')
            _thread.start_new_thread(peer.remoterequest, ())  #thread to handle remote request
            peer.localrequest()       
        else:
            print ("register failed")
        
        
            
        
        
        
        
                 
                
            
        
    
    