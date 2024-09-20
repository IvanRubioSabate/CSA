package Controlador;

import Modelo.User;
import Vista.Vista;

public class Controlador {
    public static User user;


    public static void logIn(String username, String password) {
        if (username.equals("admin")) {
            Vista.showAdminPage();
        }
    }
}
