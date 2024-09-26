package Controlador;

import Vista.MecVista;
import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
    
    private static Usuario user;
    
    public static void logIn(String user, String password) {
        Usuario usuario = Usuario.getUsuario(user);
        try {
            assert usuario != null;
            System.out.println("Usuario: " + usuario);
            if (usuario.passwordCorrect(password)) {
                Controlador.user = usuario;
                System.out.println("Usuario correcto");
                switch (usuario.getRol()) {
                    case "ADMIN":
                        Vista.showAdminPage();
                        break;
                    case "MECA":
                        Vista.generatePanels(usuario);
                        break;
                    case "ASTRO":
                        Vista.showAstroPage();
                        break;
                }
        }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
