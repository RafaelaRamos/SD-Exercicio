/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.shared;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
/**
 *
 * @author Cliente
 */
public interface RemoteIF extends Remote {
    
    
  String mensagem(String mensagem)throws RemoteException;
  void resposta (Timestamp time)throws RemoteException;;
}
