
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryukai
 */
public class server extends UnicastRemoteObject implements Adder {
    public server() throws RemoteException{
        super();
    }

    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }
    
    public static void main (String args[]) throws RemoteException{
        
        try{
            
            String IPad = (InetAddress.getLoopbackAddress()).toString();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("Hi_server", new server());
            System.out.println("Server is ready now...");
            
        }catch(RemoteException e){
            
            System.out.println("");
        }
    }

    @Override
    public int res(int n1, int n2) throws RemoteException {
        return n1 - n2;
    }

    @Override
    public int mult(int n1, int n2) throws RemoteException {
        return n1 * n2;
    }

    @Override
    public int div(int n1, int n2) throws RemoteException {
        return n1 / n2;
    }
}
