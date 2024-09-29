package Modelo;

import java.sql.*;
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

    public static boolean addUsuario(Usuario usuario, String rol, String contrasena) throws SQLException {

        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();

        Statement sentencia = conn.createStatement();
        ResultSet rs = sentencia.executeQuery("select usuario_usuario from usuarios where usuario_usuario = '" + usuario.getUsuario() + "';");

        if (rs.next()) {
            return false;
        }

        boolean userAdded = addToTableUsuarios(usuario, rol, contrasena);

        if (userAdded) {
            switch (rol) {
                case "ADMIN":
                    return true;
                case "MECA":
                    if (usuario instanceof Mecanico meca) {
                        try {
                            PreparedStatement stmt = conn.prepareStatement("INSERT INTO mecanico"+
                                    "(mecanico_id, mecanico_salario, mecanico_id_taller, mecanico_anos_exp) "+
                                    "VALUES (?,?,?,?);");

                            stmt.setString(1, usuario.getUsuario());
                            stmt.setInt(2, meca.getSalario());
                            stmt.setInt(3, meca.getIDTaller());
                            stmt.setInt(4, meca.getAnosExp());
                            stmt.executeUpdate();

                            ConectionDB.closeConexio(conn);
                            return true;
                        } catch (SQLException e) {
                            System.out.println("error " + e.getMessage());
                        }
                    }
                    break;

                case "ASTRONAUTA":
                    if (usuario instanceof Astronauta astr) {
                        try {
                            PreparedStatement stmt = conn.prepareStatement("INSERT INTO astronauta"+
                                    "(astronauta_id, astrouauta_data_1r_vuelo, astronauta_misiones_ok, astronauta_misiones_ko, astronauta_rango_militar) "+
                                    "VALUES (?,?,?,?,?);");

                            stmt.setString(1, usuario.getUsuario());
                            stmt.setDate(2, astr.getFechaPrimerVuelo());
                            stmt.setInt(3, astr.getMisionesOK());
                            stmt.setInt(4, astr.getMisionesKO());
                            stmt.setString(5, astr.getRangoMilitar());
                            stmt.executeUpdate();

                            ConectionDB.closeConexio(conn);
                            return true;
                        } catch (SQLException e) {
                            System.out.println("error " + e.getMessage());
                        }
                    }
                    break;
            }
        }

        ConectionDB.closeConexio(conn);
        return false;
    }

    private static boolean addToTableUsuarios(Usuario usuario, String rol, String contrasena) {
        ConectionDB conec = new ConectionDB();
        Connection conn = conec.getConexio();

        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios"+
                    "(usuario_usuario, usuario_contrasena, usuario_rol, usuario_nombre, usuario_sexo, usuario_edad, usuario_direccion) "+
                    "VALUES (?, ?, ?, ?, ?, ?, ?);");

            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, contrasena);
            stmt.setString(3, rol);
            stmt.setString(4, usuario.getNombre());
            stmt.setString(5, usuario.getSexo());
            stmt.setInt(6, usuario.getEdad());
            stmt.setString(7, usuario.getDireccion());
            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
        }
        ConectionDB.closeConexio(conn);
        return false;
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
