package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
    
    private final String url = "jdbc:mysql://localhost:3306/csabd";
    private final String usuari = "root";
    private final String password = "patata";
    
    public ConectionDB(){
    }
    
    public java.sql.Connection getConexio(){
        try {
            return DriverManager.getConnection(url, usuari, password);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void closeConexio(java.sql.Connection conn){
        try {
            conn.close();
            System.out.println("Conexió tancada");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
