package Controlador;

import Vista.Vista;

public class Controlador {


    public static void logIn(String username, String password) {
        if (username.equals("admin")) {
            Vista.showAdminPage();
        }
        if (username.equals("Marcos")) {
            Vista.showMecPage();
        }
        if (username.equals("Pedro")) {
            Vista.showAstroPage();
        }
    }
}
