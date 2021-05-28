
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryukai
 */
public class client {
    
    public static void main(String args[]) throws RemoteException{
        
        client c = new client();
        c.connectRemote();
    }

    private void connectRemote() throws RemoteException {
        
        Scanner reader = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int op = 0;
        int res=0;
        
        try{
           
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        Adder ad = (Adder) reg.lookup("Hi_server");
        do{
            
        System.out.println("Ingrese las dos cantidades a procesar");
        num1 = reader.nextInt();
        num2 = reader.nextInt();
        do{
            
        System.out.println("Escoja la actividad a realizar\n 1.Suma\n 2.Resta\n 3.Multiplicacion\n 4.Division");
        op = reader.nextInt();
        
        if(op>4){
            System.out.println("Opción Invalida");
        }
        
        }while(op>4);
        
        if(op==4 && num1==0 || num2==0){
            System.out.println("No se puede dividir numeros entre 0");
        }
        
        }while(op==4 && num1==0 || num2==0);
        
        switch(op){
            
            case 1:
                res = ad.add(num1,num2);
                break;
                
            case 2:
                 res = ad.res(num1,num2);
                break;
                
            case 3:
                 res = ad.mult(num1,num2);
                break;
                
            case 4:
                 res = ad.div(num1,num2);
                break;          
        
        }
        
        System.out.println("El resultado es " + res);
        
        }catch(NotBoundException | RemoteException e){
            System.out.println("Exception " + e);
        }
    }
    
}
