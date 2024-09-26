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
        JPanel panelMecan = new JPanel();
        panelMecan.setLayout(null);

        JLabel userUser = new JLabel("Usuario: ");
        JLabel userUserRes = new JLabel("ppabloc");
        userUser.setBounds(10,20,140,20);
        userUserRes.setBounds(60,20,114,19);
        panelMecan.add(userUser);
        panelMecan.add(userUserRes);

        JLabel cargoUser = new JLabel("Cargo: ");
        JLabel cargoUserRes = new JLabel("Mecanico");
        cargoUser.setBounds(125,20,140,20);
        cargoUserRes.setBounds(165,20,140,20);
        panelMecan.add(cargoUser);
        panelMecan.add(cargoUserRes);

        JLabel nombreUser = new JLabel("Nombre usuario: ");
        JLabel nombreUserRes = new JLabel("Pablo");
        nombreUser.setBounds(230,20,120,20);
        nombreUserRes.setBounds(330,20,140,20);
        panelMecan.add(nombreUser);
        panelMecan.add(nombreUserRes);

        JLabel sexoUser = new JLabel("Sexo: ");
        JLabel sexoUserRes = new JLabel("Hombre");
        sexoUser.setBounds(10,50,140,20);
        sexoUserRes.setBounds(60,50,114,19);
        panelMecan.add(sexoUser);
        panelMecan.add(sexoUserRes);

        JLabel edadUser = new JLabel("Edad: ");
        JLabel edadUserRes = new JLabel("19");
        edadUser.setBounds(125,50,140,20);
        edadUserRes.setBounds(165,50,140,20);
        panelMecan.add(edadUser);
        panelMecan.add(edadUserRes);

        JLabel direccionUser = new JLabel("Dirección: ");
        JLabel direccionUserRes = new JLabel("Calle Manzanas, 37 ");
        direccionUser.setBounds(210,50,120,20);
        direccionUserRes.setBounds(270,50,120,20);
        panelMecan.add(direccionUser);
        panelMecan.add(direccionUserRes);

        JLabel salarioUser = new JLabel("Salario: ");
        JLabel salarioUserRes = new JLabel("2500€");
        salarioUser.setBounds(10,80,140,20);
        salarioUserRes.setBounds(60,80,114,19);
        panelMecan.add(salarioUser);
        panelMecan.add(salarioUserRes);

        JLabel idTallerUser = new JLabel("Id Taller: ");
        JLabel idTallerUserRes = new JLabel("8");
        idTallerUser.setBounds(125,80,140,20);
        idTallerUserRes.setBounds(185,80,140,20);
        panelMecan.add(idTallerUser);
        panelMecan.add(idTallerUserRes);

        JLabel anosXpUser = new JLabel("Años de experiencia: ");
        JLabel anosXpUserRes = new JLabel("2");

        panelMecan.add(anosXpUser);
        panelMecan.add(anosXpUserRes);

        JLabel ciudadTrabajoUser = new JLabel("Ciduad donde trabaja: ");
        JLabel ciudadTrabajoUserRes = new JLabel("Santa Coloma de Farners ");

        panelMecan.add(ciudadTrabajoUser);
        panelMecan.add(ciudadTrabajoUserRes);




        JTextField text = new JTextField("mec page");
        //text.setBounds(120,72,114,19);

        panelMecan.add(text);

        return panelMecan;
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
