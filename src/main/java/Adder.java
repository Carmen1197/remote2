

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryukai
 */
public interface Adder extends Remote {
    
    public int add (int n1, int n2) throws RemoteException;
    public int res (int n1, int n2) throws RemoteException;
    public int mult (int n1, int n2) throws RemoteException;
    public int div (int n1, int n2) throws RemoteException;
}
