/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.RemoteIF;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Cliente
 */
public class AppII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        
        RemoteIF envia = new RemoteImplements();
        RemoteIF remote = (RemoteIF) UnicastRemoteObject.exportObject(envia, 0);
        Registry registry = LocateRegistry.createRegistry(4099);

        registry.rebind("mensagem", remote);
}
}