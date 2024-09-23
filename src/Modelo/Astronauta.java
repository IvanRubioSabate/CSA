package Modelo;


import java.sql.Date;

public class Astronauta extends Usuario {
    
    private Date fechaPrimerVuelo;
    private int misionesOK;
    private int misionesKO;
    private String rangoMilitar;
    
    
    public Astronauta(String usuario, String rol, String nombre, String sexo, int edad, String direccion, Date fechaPrimerVuelo, int misionesOK, int misionesKO, String rangoMilitar) {
        super(usuario, rol, nombre, sexo, edad, direccion);
        this.fechaPrimerVuelo = fechaPrimerVuelo;
        this.misionesOK = misionesOK;
        this.misionesKO = misionesKO;
        this.rangoMilitar = rangoMilitar;
    }
    
    public String RandomLocation(){
        
        String letra;
        
        int n = (int) ((Math.random() * 3) + 1);
        
        letra = switch (n) {
            case 1 -> "N";
            case 2 -> "S";
            case 3 -> "E";
            case 4 -> "W";
            default -> "err";
        };
        
        return (int) (Math.random() * 999) + "º" + (int) (Math.random() * 10) + "'" + (int) (Math.random() * 10) + "''" + letra;
        
    }
}
