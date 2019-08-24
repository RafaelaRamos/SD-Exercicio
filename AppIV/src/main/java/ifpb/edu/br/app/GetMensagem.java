/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.br.app;

import ifpb.edu.br.shared.Mensagem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cliente
 */
public class GetMensagem {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/sd",
                "postgres", "secret");
        return connection;
    }

    public synchronized Mensagem getMensagem() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * from mensagem ORDER BY time ASC LIMIT 1";
        Connection con = getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        Mensagem msg = new Mensagem();
        while (rs.next()) {
            msg.setTime(rs.getTimestamp("time"));
            msg.setMensagem(rs.getString("mensagem"));
        }

        return msg;
    }
}
