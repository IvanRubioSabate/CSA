package Modelo;

public class Usuario {
    private String usuario;
    private String rol;
    private String nombre;
    private String sexo;
    private int edad;
    private String direccion;
    
    
    public Usuario(String usuario, String rol, String nombre, String sexo, int edad, String direccion) {
        this.usuario = usuario;
        this.rol = rol;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.direccion = direccion;
    }
}
