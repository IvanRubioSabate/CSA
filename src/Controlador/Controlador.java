package Controlador;

import Vista.MecVista;
import Modelo.Usuario;
import Vista.Vista;

public class Controlador {
    

    
    public static void logIn(String user, String password) {
        Usuario usuario = Usuario.getUsuario(user);
        try {
            assert usuario != null;
            System.out.println("Usuario: " + usuario);
            if (usuario.passwordCorrect(password)) {
                System.out.println("Usuario correcto");
                Vista.generatePanels(usuario);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
