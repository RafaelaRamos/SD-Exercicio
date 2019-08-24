/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.RemoteIF;
import java.rmi.RemoteException;
import java.sql.Timestamp;

/**
 *
 * @author Cliente
 */
public class RemoteImplements implements RemoteIF {

    public RemoteImplements() {
    }

    @Override
    public String mensagem(String mensagem) throws RemoteException {
        System.out.println("A Mensagem enviada pelo AppI foi : "+mensagem);
       return null;
    }

    @Override
    public void resposta(Timestamp time) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
