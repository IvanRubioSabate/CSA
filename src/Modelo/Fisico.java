package Modelo;

public class Fisico extends Usuario {
    private int AnosExp;
    private int Salario;
    private String Titulacion;
    private String CiudadTrabajo;
    
    public Fisico(String usuario, String rol, String nombre, String sexo, int edad, String direccion, int anosExp, int salario, String titulacion, String ciudadTrabajo) {
        super(usuario, rol, nombre, sexo, edad, direccion);
        AnosExp = anosExp;
        Salario = salario;
        Titulacion = titulacion;
        CiudadTrabajo = ciudadTrabajo;
    }
    
    
}
