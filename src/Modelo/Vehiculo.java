package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public Map<String, String> getVehiculo(){
        Map<String, String> Vehiculos = new HashMap<>();
        Vehiculos.put("matricula", this.matricula);
        Vehiculos.put("model", this.model);
        Vehiculos.put("color", this.color);
        Vehiculos.put("tipo", this.tipo);
        Vehiculos.put("IDTaller", String.valueOf(this.IDTaller));

        return Vehiculos;
    }

}
