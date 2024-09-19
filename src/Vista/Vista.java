package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                cl.show(cards, "Panel2");
            }
        });
        panel1.add(text1);

        JPanel panel2 = new JPanel();
        JButton text2 = new JButton("Adios");
        panel2.add(text2);

        cards.add(panel1, "Panel1");
        cards.add(panel2, "Panel2");

        cl.show(cards, "Panel1");

        frame.setContentPane(cards);
        frame.setVisible(true);
    }
}
