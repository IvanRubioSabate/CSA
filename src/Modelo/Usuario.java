package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class Usuario {
    protected String usuario;
    protected String rol;
    protected String nombre;
    protected String sexo;
    protected int edad;
    protected String direccion;
    
    
    public Usuario(String usuario, String rol, String nombre, String sexo, int edad, String direccion) {
        this.usuario = usuario;
        this.rol = rol;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = direccion;
    }
    
    public static Usuario getUsuario(String user) {
        
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();
        
        try {
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery("select * from usuarios where usuario_usuario = '" + user + "';");
            if (rs.next()) {
                return new Usuario(rs.getString("usuario_usuario"), rs.getString("usuario_rol"), rs.getString("usuario_nombre"), rs.getString("usuario_sexo"), rs.getInt("usuario_edad"), rs.getString("usuario_direcion"));
            }else{
                return null;
            }
            
        
        }catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            ConectionDB.closeConexio(conn);
            return null;
        }
    }
    
    public boolean passwordCorrect(String password){
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();
        
        try{
            Statement sentencia = conn.createStatement();
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM usuarios WHERE usuario_usuario = '"+this.usuario+"'");
            
            if (rs.next()) {
                return rs.getString("usuario_contrasena").equals(password);
            }else{
                return false;
            }
            
        }catch (SQLException e) {
            ConectionDB.closeConexio(conn);
            return false;
        }
        
        
    }
    
    public String getRol() {
        return rol;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getDireccion() {
        return direccion;
    }
}
