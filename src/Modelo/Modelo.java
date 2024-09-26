package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {


    public static void main(String[] args) {
        System.out.println(createUser("Ivan", "patata", "ADMIN", "Ivan", "hombre", 19, "Vidreres"));
    }
    
    public static boolean createUser(String usuario, String contrasena, String rol, String nombre, String sexo, int edad, String direccion) {
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();
        
        try{
            
            Statement sentencia = conn.createStatement();
            
            sentencia.execute("INSERT INTO usuarios (usuario_usuario, usuario_contrasena, usuario_rol, usuario_nombre, usuario_sexo, usuario_edad, usuario_direcion) VALUES ('"+usuario+"', '"+contrasena+"', '"+rol+"','"+nombre+"' ,'"+sexo+"', '"+edad+"', '"+direccion+"')");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ConectionDB.closeConexio(conn);
            return false;
        }
        
        
        ConectionDB.closeConexio(conn);
        return true;
        
    }
    
}
