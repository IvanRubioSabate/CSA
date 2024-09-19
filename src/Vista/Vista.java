package Vista;

import javax.swing.*;
import java.awt.*;


import Modelo.ConectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vista {

    private static MyFrame frame = new MyFrame();
    public static void main(String[] args) throws Exception {
        ConectionDB conec = new ConectionDB();
        
        Connection conn = conec.getConexio();
        
        try {
            Statement sentencia = conn.createStatement();
            
            sentencia.execute("INSERT INTO usuarios (usuario_usuario, usuario_contrasena, usuario_rol, usuario_nombre, usuario_sexo, usuario_edad, usuario_direcion) VALUES ('Guilherme', 'patata', 'ADMIN','Guilherme' ,'hombre', '19', 'Vidreres')");
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM usuarios");
            
            while (rs.next()) {
                System.out.println(rs.getString("usuario_usuario") + " " + rs.getString("usuario_rol"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
