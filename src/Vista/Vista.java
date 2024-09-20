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
        

        JPanel panel1 = new JPanel();
        JButton text1 = new JButton("Hola");
        text1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controlador.logIn("admin", "admin");
            }
        });
        panel1.add(text1);

        JPanel panel2 = new JPanel();
        JButton text2 = new JButton("Adios");
        panel2.add(text2);

        JPanel adminPage = CreateAdminPage();

        cards.add(panel1, "Panel1");
        cards.add(panel2, "Panel2");
        cards.add(adminPage, "adminPage");

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

    public static void showAdminPage() {
        cl.show(cards, "adminPage");
    }

}
