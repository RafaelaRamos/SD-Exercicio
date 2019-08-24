/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Cliente
 */
public class PersistirMensagem {
       
    public Connection getConnection() throws SQLException, ClassNotFoundException {
         Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/sd",
                "postgres", "secret");
        return connection;
    }
 public synchronized void salvar(String mensagem) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO mensagem(time,mensagem) VALUES (CURRENT_TIMESTAMP,?)";
        Connection con = getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, mensagem);
        
        stm.executeUpdate();
        stm.close();
        con.close();
    }
  public synchronized void deletar(Timestamp time) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM mensagem WHERE time = ?";
        Connection con =getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setTimestamp(1, time);
        stm.execute();
        stm.close();
        con.close();
    }
}
