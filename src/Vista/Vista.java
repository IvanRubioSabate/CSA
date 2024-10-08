package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Controlador.Controlador;
import Modelo.Usuario;

public class Vista {

    private static MyFrame frame = new MyFrame();
    private static JPanel cards;
    private static CardLayout cl;
    public static void main(String[] args) throws Exception {
        
        cl = new CardLayout();
        cards = new JPanel();
        cards.setLayout(cl);
        

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        

        //Visual del login (first page)

        panelPrincipal.setBackground(Color.gray);
        JButton botonEntrar = new JButton("Entrar");
        botonEntrar.setBorder(BorderFactory.createLineBorder(Color.GRAY,4));
        // Algunos labels, campos y botones
        JLabel usernameLabel = new JLabel("Usuario");
        JTextField usernameInputField = new JTextField(8);
        JLabel passwordLabel = new JLabel("Contraseña");
        JPasswordField passwordInputField = new JPasswordField(8);


        usernameLabel.setBounds(120,72,114,19);
        usernameInputField.setBounds(200,72,114,19);
        panelPrincipal.add(usernameLabel);
        panelPrincipal.add(usernameInputField);
        passwordLabel.setBounds(120,114,114,19);
        passwordInputField.setBounds(200,114,114,19);
        panelPrincipal.add(passwordLabel);
        panelPrincipal.add(passwordInputField);
        botonEntrar.setBounds(180,164,80,30);
        botonEntrar.setBackground(new Color(20, 216, 216, 207));
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setFocusPainted(false);
        botonEntrar.setBorderPainted(false);
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

        cards.add(panelPrincipal, "Panel1");
        cl.show(cards, "panel1");
        frame.setContentPane(cards);
        frame.setVisible(true);
    }

    //Creacion de paneles
    public static void generatePanels(Usuario user) {
        switch (user.getRol()) {
            case "ADMIN":
                JScrollPane adminPage = AdminVista.CreateAdminPage(user);
                cards.add(adminPage, "adminPage");
                cl.show(cards, "adminPage");
                break;
            case "MECA":
                JPanel mecPage = MecVista.CreateMecPage(user);
                cards.add(mecPage, "mecPage");
                cl.show(cards, "mecPage");
                break;
            case "ASTRO":
                JPanel astroPage = AstroVista.CreateAstroPage(user);
                cards.add(astroPage, "astroPage");
                cl.show(cards, "astroPage");
                break;
        }

        frame.setContentPane(cards);
        frame.setVisible(true);
    }

}
