package Vista;

import Modelo.Astronauta;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Map;

public class AstroVista {
    public static JPanel CreateAstroPage(Usuario user){
        Astronauta astronauta = Astronauta.getAstronauta(user);
        assert astronauta != null;
        Map<String, String> Dades = astronauta.getFitxa();

        JPanel panelAstro = new JPanel();
        panelAstro.setLayout(null);

        JLabel userUser = new JLabel("Usuario: ");
        JLabel userUserRes = new JLabel(Dades.get("usuario"));
        userUser.setBounds(10,20,140,20);
        userUserRes.setBounds(60,20,114,19);
        panelAstro.add(userUser);
        panelAstro.add(userUserRes);

        JLabel cargoUser = new JLabel("Cargo: ");
        JLabel cargoUserRes = new JLabel("Astronauta");
        cargoUser.setBounds(125,20,140,20);
        cargoUserRes.setBounds(165,20,140,20);
        panelAstro.add(cargoUser);
        panelAstro.add(cargoUserRes);

        JLabel nombreUser = new JLabel("Nombre usuario: ");
        JLabel nombreUserRes = new JLabel(Dades.get("nombre"));
        nombreUser.setBounds(230,20,120,20);
        nombreUserRes.setBounds(330,20,140,20);
        panelAstro.add(nombreUser);
        panelAstro.add(nombreUserRes);

        JLabel sexoUser = new JLabel("Sexo: ");
        JLabel sexoUserRes = new JLabel(Dades.get("sexo"));
        sexoUser.setBounds(10,50,140,20);
        sexoUserRes.setBounds(60,50,114,19);
        panelAstro.add(sexoUser);
        panelAstro.add(sexoUserRes);

        JLabel edadUser = new JLabel("Edad: ");
        JLabel edadUserRes = new JLabel(Dades.get("edad"));
        edadUser.setBounds(125,50,140,20);
        edadUserRes.setBounds(165,50,140,20);
        panelAstro.add(edadUser);
        panelAstro.add(edadUserRes);

        JLabel direccionUser = new JLabel("Dirección: ");
        JLabel direccionUserRes = new JLabel(Dades.get("direccion"));
        direccionUser.setBounds(210,50,120,20);
        direccionUserRes.setBounds(270,50,120,20);
        panelAstro.add(direccionUser);
        panelAstro.add(direccionUserRes);




        return panelAstro;
    }
}
