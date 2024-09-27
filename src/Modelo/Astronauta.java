package Modelo;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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

    public static Astronauta getAstronauta(Usuario usuario) {
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();

        try {
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery("select * from astronauta where astronauta_id = '" + usuario.getNombre() + "';");
            if (rs.next()) {
                return new Astronauta (usuario.getUsuario(), usuario.getRol(), usuario.getNombre(), usuario.getSexo(), usuario.getEdad(), usuario.getDireccion(), rs.getDate("astronauta_data_1r_vuelo"), rs.getInt("astronauta_misiones_ok"), rs.getInt("astronauta_misiones_ko"), rs.getString("astronauta_rango_militar"));
            } else {
                return null;
            }


        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            ConectionDB.closeConexio(conn);
            return null;
        }
    }
    
    public static String RandomLocation() {
        
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
    
    public Map<String, String> getFitxa() {
        Map<String, String> Dades = new HashMap<>();
        Dades.put("usuario", this.usuario);
        Dades.put("rol", this.rol);
        Dades.put("nombre", this.nombre);
        Dades.put("sexo", this.sexo);
        Dades.put("edad", String.valueOf(this.edad));
        Dades.put("direccion", this.direccion);
        Dades.put("fechaPrimerVuelo", this.fechaPrimerVuelo.toString());
        Dades.put("misionesOK", String.valueOf(this.misionesOK));
        Dades.put("misionesKO", String.valueOf(this.misionesKO));
        Dades.put("rangoMilitar", this.rangoMilitar);
        return Dades;
    }
    
    public static String encriptarMisatge(String misatge) {
        StringBuilder encriptado = new StringBuilder();
        for (int i = 0; i < misatge.length(); i++) {
            if (misatge.charAt(i) != 'a' && misatge.charAt(i) != 'e' && misatge.charAt(i) != 'i' && misatge.charAt(i) != 'o' && misatge.charAt(i) != 'u') {
                encriptado.append(misatge.charAt(i));
            }
        }
        return encriptado.toString();
    }
}
