package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Controlador.Controlador;

public class Vista {

    private static MyFrame frame = new MyFrame();
    private static JPanel cards;
    private static CardLayout cl;
    public static void main(String[] args) throws Exception {
        
        cl = new CardLayout();

        cards = new JPanel();
        cards.setLayout(cl);
        

        JPanel panelPrincipal = new JPanel();

        //Visual del login (first page)

        panelPrincipal.setBackground(Color.gray);
        JButton botonEntrar = new JButton("Entrar");
        botonEntrar.setBorder(BorderFactory.createLineBorder(Color.GRAY,4));
        // Algunos labels, campos y botones
        JLabel usernameLabel = new JLabel("Usuario");
        JTextField usernameInputField = new JTextField(8);
        JLabel passwordLabel = new JLabel("Contraseña");
        JPasswordField passwordInputField = new JPasswordField(8);

        panelPrincipal.add(usernameLabel);
        panelPrincipal.add(usernameInputField);
        panelPrincipal.add(passwordLabel);
        panelPrincipal.add(passwordInputField);
        panelPrincipal.add(botonEntrar);

        // Añade un ActionListener al botón de entrar
        botonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados por el usuario
                String username = usernameInputField.getText(); // Obtener el texto del campo de usuario
                String password = new String(passwordInputField.getPassword()); // Obtener la contraseña (como String)

                // Llamar al método logIn del controlador con los valores obtenidos
                Controlador.logIn(usernameInputField.getText(), password);
            }
        });


        //Creacion de paneles
        JPanel adminPage = CreateAdminPage();
        JPanel mecPage = CreateMecPage();
        JPanel astroPage = CreateAstroPage();

        cards.add(panelPrincipal, "Panel1");
        cards.add(adminPage, "adminPage");
        cards.add(mecPage, "mecPage");
        cards.add(astroPage, "astroPage");

        cl.show(cards, "panel1");

        frame.setContentPane(cards);
        frame.setVisible(true);
    }



    //Create the admin panel 
    private static JPanel CreateAdminPage() {
        JPanel panel = new JPanel();

        JTextField text = new JTextField("admin page");

        panel.add(text);

        return panel;
    }

    private static JPanel CreateMecPage() {
        JPanel panel = new JPanel();

        JTextField text = new JTextField("mec page");

        panel.add(text);

        return panel;
    }

    private static JPanel CreateAstroPage() {
        JPanel panel = new JPanel();

        JTextField text = new JTextField("Astro page");

        panel.add(text);

        return panel;
    }

    public static void showAdminPage() {
        cl.show(cards, "adminPage");
    }
    public static void showMecPage() {
        cl.show(cards, "mecPage");
    }

    public static void showAstroPage() {
        cl.show(cards, "astroPage");
    }



     public static JPanel loginP() {
         JPanel panel = new JPanel();
         panel.setBackground(Color.blue);

         // Textos
         JLabel titulo;
         JLabel interprete;
         JLabel duracion;
         JButton añadir;
         JButton cancelar;


         // Crear el botón
         JButton boton = new JButton("Cambiar Color");
         return panel;
    }

}
