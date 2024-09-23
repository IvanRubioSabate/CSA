package Modelo;

public class Vehiculo {
    private String matricula;
    private String model;
    private String color;
    private String tipo;
    private int IDTaller;
    
    public Vehiculo(String matricula, String model, String color, String tipo, int IDTaller) {
        this.matricula = matricula;
        this.model = model;
        this.color = color;
        this.tipo = tipo;
        this.IDTaller = IDTaller;
    }
}
