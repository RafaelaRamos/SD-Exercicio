/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.RemoteIF;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class RemoteImplements implements RemoteIF{
    private PersistirMensagem  pm = new PersistirMensagem();
    
    
    @Override
    public String mensagem(String mensagem) throws RemoteException {
        
        try {
            pm.salvar(mensagem);
        } catch (SQLException ex) {
            Logger.getLogger(RemoteImplements.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RemoteImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
    }

    @Override
    public void resposta(Timestamp time) throws RemoteException {
        
        
        try {
            pm.deletar(time);
        } catch (SQLException ex) {
            Logger.getLogger(RemoteImplements.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RemoteImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
