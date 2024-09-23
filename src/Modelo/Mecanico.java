package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

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
            
            ResultSet rs = sentencia.executeQuery("SELECT * FROM vehiuclos WHERE vehiculo_id_taller =" + this.IDTaller);
            
            while (rs.next()) {
                vehiculos.add(new Vehiculo(rs.getString("vehiculo_matricula"), rs.getString("vehiculo_model"), rs.getString("vehiculo_color"), rs.getString("vehiculo_tipo"), rs.getInt("vehiculo_id_taller")));
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
}
