/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.Mensagem;
import ifpb.edu.br.shared.RemoteIF;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

/**
 *
 * @author Cliente
 */
public class AppIV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, SQLException, ClassNotFoundException, NotBoundException {
        
        GetMensagem mensagem = new GetMensagem();
        Mensagem md = mensagem.getMensagem();

        Registry registry = LocateRegistry.getRegistry(4099);
        Registry registryII = LocateRegistry.getRegistry(1099);
        RemoteIF msg = (RemoteIF) registry.lookup("mensagem");
        msg.mensagem(md.getMensagem());
        msg = (RemoteIF) registryII.lookup("mensagem");
        msg.resposta(md.getTime());
    }

}
