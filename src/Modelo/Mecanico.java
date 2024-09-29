package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Mecanico extends Usuario {
    private int salario;
    private int IDTaller;
    private int anosExp;
    private String CiudadTrabajo;
    private Boolean Fitxat;
    
    public Mecanico(String usuario, String rol, String nombre, String sexo, int edad, String direccion, int salario, int IDTaller, int anosExp, String ciudadTrabajo) {
        super(usuario, rol, nombre, sexo, edad, direccion);
        this.salario = salario;
        this.IDTaller = IDTaller;
        this.anosExp = anosExp;
        this.CiudadTrabajo = ciudadTrabajo;
        this.Fitxat = false;
    }
    
    public static Mecanico getMecanico(Usuario usuario) {
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();
        
        try {
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery("select * from mecanico where mecanico_id = '" + usuario.getNombre() + "';");
            if (rs.next()) {
                return new Mecanico (usuario.getUsuario(), usuario.getRol(), usuario.getNombre(), usuario.getSexo(), usuario.getEdad(), usuario.getDireccion(), rs.getInt("mecanico_salario"), rs.getInt("mecanico_id_taller"), rs.getInt("mecanico_anos_exp"), rs.getString("mecanico_ciduad_trabajo"));
            } else {
                return null;
            }
            
            
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            ConectionDB.closeConexio(conn);
            return null;
        }
    }
    
    public boolean Fitxar() {
       
       if(Fitxat){
           Fitxat = false;
           return false;
       }else{
           Fitxat = true;
           return true;
       }
    }
    
    public HashSet<Vehiculo> listarVehiculos(){
        
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();
        HashSet<Vehiculo> vehiculos = new HashSet<>();
        
        try{
            Statement sentencia = conn.createStatement();
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM vehiculos WHERE vehiculo_taller_id =" + this.IDTaller);
            
            while (rs.next()) {
                vehiculos.add(new Vehiculo(rs.getString("vehiculo_matricula"), rs.getString("vehiculo_model"), rs.getString("vehiculo_color"), rs.getString("vehiculo_tipo"), rs.getInt("vehiculo_taller_id")));
            }
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            ConectionDB.closeConexio(conn);
            HashSet<Vehiculo> err = new HashSet<>();
            err.add (new Vehiculo("Error", "Error", "Error", "Error", 0));
            return err;
        }
        
        return vehiculos;
    }
    
    public Map<String, String> getFitxa(){
        Map<String, String> Dades = new HashMap<>();
        Dades.put("usuario", this.usuario);
        Dades.put("rol", this.rol);
        Dades.put("nombre", this.nombre);
        Dades.put("sexo", this.sexo);
        Dades.put("edad", String.valueOf(this.edad));
        Dades.put("direccion", this.direccion);
        Dades.put("salario", String.valueOf(this.salario));
        Dades.put("IDTaller", String.valueOf(this.IDTaller));
        Dades.put("anosExp", String.valueOf(this.anosExp));
        Dades.put("CiudadTrabajo", this.CiudadTrabajo);
        
        return Dades;
    }

    public int getSalario() {
        return salario;
    }

    public int getIDTaller() {
        return IDTaller;
    }

    public int getAnosExp() {
        return anosExp;
    }

    public String getCiudadTrabajo() {
        return CiudadTrabajo;
    }
}
