'''
Created on 2013-11-29

@author: Mian
'''
import _thread, sys, os
from socket import *
import random

class Peer:
    #peer filepath(arg1) server(arg2) 
    def __init__(self,arg):
       
        self.path = arg[1]
        self.serverip = arg[2]
        self.serverport = 8001
        self.localserport = 9000
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
                socket.close()
                
                if self.peerconnect(peerinfo):
                    print ('We have a new peer' + peerinfo)
                    return True
                else:
                    print ('connect to peer failed')
                    return False
                    
                
    def peerconnect(self, peerinfo):
        #according to returned peerinfo by server, build peer pair with neighbor
        socket = socket(AF_INET, SOCK_STREAM)
        try:
            socket.connect(peerinfo)
        except error:
            print ('connect to peer failed')
            return False
        
        dataout = 'peer'+' '+self.localserport #tell neighbor my server port
        socket.send(dataout.encode())
        print ('connecting to peer '+peerinfo)
        
        while True:
            datain = socket.recv(self.buffsize)
            if datain.decode() == "successful":
                socket.close()
                print ('connect to peer ' + peerinfo + 'successfully' )
                return True
            else:
                return False
    
    def incomimgpeer(self, data, address, socket):
        #handle peer's join request, data like 'peer'+' '+peer's localserport
        print (address[0] + 'is going to peer, its local service port is '+ data[1])
        self.mypeer.append((address[0], data[1]))
        socket.send(('successful').encode())
        print (address[0] + 'peer successfully')
    
        
    def get(self, filename):
        #get a file from peer
        dataout = 'get' + ' ' + filename + ' ' + self.localadd
        print (dataout)
        for peer in self.mypeer:
            socket = socket(AF_INET, SOCK_STREAM)
            socket.connect(peer)
            socket.send(dataout.encode())
            print ('send request to '+ peer + ' for ' + filename)
            socket.close()
        print ('Send all peers for ' + filename)
        
    def incomingget(self, data, address):
        #handle get request from peer,  data like 'get filename self.localadd'
        if data[1] in os.listdir(self.path):
            print ('has the file' + data[1])
            self.share(data[1], data[2])
        else:
            flood = self.mypeer.remove((address[0], 9000)) #remove the sender
            for peer in flood:
                socket = socket(AF_INET, SOCK_STREAM)
                socket.connect(peer)
                socket.send(data.encode())  #keep the request source ip+port unmodified
                print ("do not have the file, flood to "+ peer)
                socket.close
                
    def share(self, filename, address):
        #transfer a local file to peer with the address, like 'share filename peeraddress
        dataout = 'share' + ' ' + filename
        socket = socket(AF_INET, SOCK_STREAM)
        socket.connect(address)
        socket.send(dataout.encode())   
        print ('share request sent out')

        datain = socket.recv(self.buffsize)
        if datain.decode() == "ok":
            path = self.path + '/' + filename
            filestream = open(path, 'r')
            while True:
                datafile = filestream.read(self.buffsize)
                if not datafile:
                    break
                socket.send(datafile.encode())
            filestream.close()
            print ("file "+ filename + " is shared to "+ address)
        else:
            print ("the peer do not accept")
            
        socket.close()    
        
    def incomingshare(self, data, address, socket):
        #handle the share request from peer
        #data like 'share filename peeraddress, address is origin add
        path = self.path + '/' + data[1]
        filestream = open(path, 'w')
        
        socket.send('ok')
        while True:
            datain = socket.recv(self.buffsize)
            if not datain:
                break
            filestream.write(datain.decode())
        filestream.close()
        socket.close()
            
    def listfile(self):
        print(os.listdir(self.path))
        
    def listpeer(self):
        for peer in self.mypeer:
            print (peer + '\n')
        
    def quit(self):
        #quit the p2p network, the command is 'quit
        dataout = "quit"
        flood = self.mypeer.append((self.serverip, self.serverport))
        alllist = flood
        for peer in flood:
            socket = socket(AF_INET, SOCK_STREAM)
            socket.connect(peer)
            socket.send(dataout.encode())
            while True:
                datain = socket.recv(self.buffsize)
                if (datain.decode() == "quit successfully"):
                    alllist.remove(peer)
                    self.mypeer.remove(peer)
                    print ("disconnected from " + peer + "successfully")
                    break
                else:
                    print ("disconnected from " + peer + "failed")
                    break
            socket.close()
        if (alllist == []):
            print ("quit successfully")
        else:
            print ("quit not completely in\n" + alllist)
    
    def incomingquit(self, address, socket):    
        #handle a peer quit 
        self.mypeer.remove(address[1], 9000)
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
        socket = socket(AF_INET, SOCK_STREAM)
        socket.bind(self.localadd)
        socket.listen(10)
        
        while True:
            peer_socket, peer_add = socket.accept()
            print (peer_add + 'connected')
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
                    self.incomingquit(peer_add, peer_socket)
                    break
                else:
                    print (datain)
                    break
            peer_socket.close()
            
        socket.close()
        
        
if __name__ == '__main__':
        peer = Peer(sys.argv)
        if  peer.register() == True:
            print ('joined p2p network successfully')
            _thread.start_new_thread(peer.remoterequest, ())  #thread to handle remote request
            peer.localrequest()       
        else:
            print ("register failed")
        
        
            
        
        
        
        
                 
                
            
        
    
    