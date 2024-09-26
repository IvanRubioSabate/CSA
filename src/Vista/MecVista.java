package Vista;

import Modelo.Mecanico;
import Modelo.Usuario;

import javax.swing.*;
import java.util.Map;

public class MecVista {
    public static JPanel CreateMecPage(Usuario user){
        Mecanico mecanico = Mecanico.getMecanico(user);
        assert mecanico != null;
        Map<String, String> Dades = mecanico.getFitxa();
        
        JPanel panelMecan = new JPanel();
        panelMecan.setLayout(null);
        
        JLabel userUser = new JLabel("Usuario: ");
        JLabel userUserRes = new JLabel(Dades.get("usuario"));
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
        JLabel nombreUserRes = new JLabel(Dades.get("nombre"));
        nombreUser.setBounds(230,20,120,20);
        nombreUserRes.setBounds(330,20,140,20);
        panelMecan.add(nombreUser);
        panelMecan.add(nombreUserRes);
        
        JLabel sexoUser = new JLabel("Sexo: ");
        JLabel sexoUserRes = new JLabel(Dades.get("sexo"));
        sexoUser.setBounds(10,50,140,20);
        sexoUserRes.setBounds(60,50,114,19);
        panelMecan.add(sexoUser);
        panelMecan.add(sexoUserRes);
        
        JLabel edadUser = new JLabel("Edad: ");
        JLabel edadUserRes = new JLabel(Dades.get("edad"));
        edadUser.setBounds(125,50,140,20);
        edadUserRes.setBounds(165,50,140,20);
        panelMecan.add(edadUser);
        panelMecan.add(edadUserRes);
        
        JLabel direccionUser = new JLabel("Dirección: ");
        JLabel direccionUserRes = new JLabel(Dades.get("direccion"));
        direccionUser.setBounds(210,50,120,20);
        direccionUserRes.setBounds(270,50,120,20);
        panelMecan.add(direccionUser);
        panelMecan.add(direccionUserRes);
        
        JLabel salarioUser = new JLabel("Salario: ");
        JLabel salarioUserRes = new JLabel(Dades.get("salario"));
        salarioUser.setBounds(10,80,140,20);
        salarioUserRes.setBounds(60,80,114,19);
        panelMecan.add(salarioUser);
        panelMecan.add(salarioUserRes);
        
        JLabel idTallerUser = new JLabel("Id Taller: ");
        JLabel idTallerUserRes = new JLabel(Dades.get("IDTaller"));
        idTallerUser.setBounds(125,80,140,20);
        idTallerUserRes.setBounds(185,80,140,20);
        panelMecan.add(idTallerUser);
        panelMecan.add(idTallerUserRes);
        
        JLabel anosXpUser = new JLabel("Años de experiencia: ");
        JLabel anosXpUserRes = new JLabel(Dades.get("anosExp"));
        
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
}
