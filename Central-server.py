'''
Created on 2013-11-29

@author: Mian
'''
import _socket
from socket import *
import random

if __name__ == '__main__':
    ipadd = gethostbyname(gethostname())
    serverport = 8001
    buffsize = 1024
    socket = socket(AF_INET, SOCK_STREAM)
    address = (ipadd, serverport)
    print (address)
    clientport = 9000
    socket.bind(address)
    socket.listen(10)
    
    peerlist = []
    
    while True:
        connect_socket, client_add = socket.accept()
        print(client_add, ' connected' )
        while True:
            data = connect_socket.recv(buffsize)
            data = data.decode().split(' ')  
            if not data:
                break
            if data[0] == 'register':
                client_add = list(client_add) # split client_add into ipadd and port, discard the port
                dataout = register(client_add[0], data[1], peerlist) # send out "client ipadd, client peer service port, peerlist to this client
                connect_socket.send(dataout.encode())
                print(dataout)
                print('updated peer list is \n',peerlist)
                break
            elif data[0] == 'quit':
                self.quit(client_add[0], clientport, peerlist, connect_socket)
                print('updated peer list is \n',peerlist)
                break
        connect_socket.close()
    
    socket.close()
    
def quit(ip, port, peerlist, socket):
    address = (ip, port)
    peerlist.remove(address)
    socket.send(("quit successfully").encode)
    print (address, ' quit the list')
    
def register(ip, port, peerlist):
    address = (ip, port)
    if len(peerlist == 0):
        peerlist.append(address)
        return "You are the only one peer in system"
    else:
        if address not in peerlist:
            t = random.randint(0, len(peerlist)-1)
            randompickapeer = peerlist[t]
            peerlist.append(address)
            randompickapeer = str(randompickapeer[0])+' '+ str(randompickapeer[1])
            return randompickapeer
        else:
            return "duplicate register is not allowed"
        
    
                 
                
                
                
                
            
            
            
        
        
    