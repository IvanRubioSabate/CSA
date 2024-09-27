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

        JLabel astro1rV = new JLabel("Fecha primer vuelo: ");
        JLabel astro1rVres = new JLabel(Dades.get("fechaPrimerVuelo"));
        astro1rV.setBounds(10,80,300,20);
        astro1rVres.setBounds(130,80,140,20);
        panelAstro.add(astro1rV);
        panelAstro.add(astro1rVres);

        JLabel astroMisionesOK = new JLabel("Misiones Cumplidas: ");
        JLabel astroMisionesOKRes = new JLabel(Dades.get("misionesOK"));
        astroMisionesOK.setBounds(210,80,300,20);
        astroMisionesOKRes.setBounds(340,80,140,20);
        panelAstro.add(astroMisionesOK);
        panelAstro.add(astroMisionesOKRes);

        JLabel astroMisionesKO = new JLabel("Misiones Fallidas: ");
        JLabel astroMisionesKORes = new JLabel(Dades.get("misionesKO"));
        astroMisionesKO.setBounds(10,110,300,20);
        astroMisionesKORes.setBounds(120,110,140,20);
        panelAstro.add(astroMisionesKO);
        panelAstro.add(astroMisionesKORes);

        JLabel astroRango = new JLabel("Rango Militar: ");
        JLabel astroRangoRes = new JLabel(Dades.get("rangoMilitar"));
        astroRango.setBounds(140,110,300,20);
        astroRangoRes.setBounds(230,110,140,20);
        panelAstro.add(astroRango);
        panelAstro.add(astroRangoRes);


        JLabel ubiText = new JLabel("Enviar mi ubicacion --> ");
        panelAstro.add(ubiText);
        ubiText.setBounds(50,200,200,20);
        JButton enviarUbiButton = new JButton("Enviar Ubicación");
        panelAstro.add(enviarUbiButton);
        enviarUbiButton.setBounds(180,200,200,20);


        enviarUbiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String randomLocat = Astronauta.RandomLocation();
               JLabel pintarLocat = new JLabel(randomLocat);
               panelAstro.add(pintarLocat);
               pintarLocat.setBounds(130,230,500,20);
            }
        });






        return panelAstro;
    }
}
