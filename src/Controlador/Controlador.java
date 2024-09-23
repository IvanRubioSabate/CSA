package Controlador;

import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
    
    public static void logIn(String user, String password) {
        Usuario usuario = Usuario.newUsuario(user);
        try {
            assert usuario != null;
            System.out.println("Usuario: " + usuario);
            if (usuario.passwordCorrect(password)) {
                System.out.println("Usuario correcto");
                switch (usuario.getRol()) {
                    case "ADMIN" -> Vista.showAdminPage();
                    case "MECA" -> Vista.showMecPage();
                    case "ASTRO" -> Vista.showAstroPage();
                }
        }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
