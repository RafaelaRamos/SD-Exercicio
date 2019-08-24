/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.RemoteIF;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 *
 * @author Cliente
 */
public class AppIII {

  public static void main(String[] args) throws RemoteException, NotBoundException, SQLException, ClassNotFoundException {
       
        RemoteIF envia = new RemoteImplements();
        RemoteIF remote = (RemoteIF) UnicastRemoteObject.exportObject(envia, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("mensagem", remote);
        
    }
    
}
