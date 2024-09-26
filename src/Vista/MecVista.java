package Vista;

import Controlador.Controlador;
import Modelo.Mecanico;
import Modelo.Usuario;
import Modelo.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
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
        anosXpUser.setBounds(210,80,150,20);
        anosXpUserRes.setBounds(330,80,120,20);
        panelMecan.add(anosXpUser);
        panelMecan.add(anosXpUserRes);
        
        JLabel ciudadTrabajoUser = new JLabel("Ciudad donde trabaja: ");
        JLabel ciudadTrabajoUserRes = new JLabel(Dades.get("CiudadTrabajo"));
        ciudadTrabajoUser.setBounds(10,110,140,20);
        ciudadTrabajoUserRes.setBounds(140,110,154,19);
        panelMecan.add(ciudadTrabajoUser);
        panelMecan.add(ciudadTrabajoUserRes);
        
        
        
        
        JLabel text = new JLabel("-------------------------------------------------------------------------------------------------");
        text.setBounds(0,130,2000,19);
        panelMecan.add(text);

        JLabel txtLlistar = new JLabel("Vehiculos del taller");
        panelMecan.add(txtLlistar);
        txtLlistar.setBounds(10,150,140,20);
        int y = 180;

        HashSet vehiculos = mecanico.listarVehiculos();

        for (Object temp: vehiculos){
            Vehiculo vehiculo = (Vehiculo) temp;

            Map <String, String> datos = vehiculo.getVehiculo();

            JLabel matrVehiculo = new JLabel("Matricula: ");
            JLabel matrVehiculoRes = new JLabel(datos.get("matricula"));
            matrVehiculo.setBounds(10, y,140,20);
            matrVehiculoRes.setBounds(90,y,140,20);
            panelMecan.add(matrVehiculo);
            panelMecan.add(matrVehiculoRes);

            y += 20;
            JLabel modeloVehiculo = new JLabel("Modelo: ");
            JLabel modeloVehiculoRes = new JLabel(datos.get("model"));
            modeloVehiculo.setBounds(10, y,140,20);
            modeloVehiculoRes.setBounds(90,y,140,20);
            panelMecan.add(modeloVehiculo);
            panelMecan.add(modeloVehiculoRes);

            y += 20;
            JLabel colorVehiculo = new JLabel("Color: ");
            JLabel colorVehiculoRes = new JLabel(datos.get("color"));
            colorVehiculo.setBounds(10, y,140,20);
            colorVehiculoRes.setBounds(90,y,140,20);
            panelMecan.add(colorVehiculo);
            panelMecan.add(colorVehiculoRes);

            y += 20;
            JLabel tipoVehiculo = new JLabel("Tipo: ");
            JLabel tipoVehiculoRes = new JLabel(datos.get("color"));
            tipoVehiculo.setBounds(10, y,140,20);
            tipoVehiculoRes.setBounds(90,y,140,20);
            panelMecan.add(tipoVehiculo);
            panelMecan.add(tipoVehiculoRes);

            y += 20;
            JLabel idTallerVehiculo = new JLabel("Id Taller: ");
            JLabel idTallerVehiculoRes = new JLabel(datos.get("IDTaller"));
            idTallerVehiculo.setBounds(10, y,140,20);
            idTallerVehiculoRes.setBounds(90,y,140,20);
            panelMecan.add(idTallerVehiculo);
            panelMecan.add(idTallerVehiculoRes);

            y += 33;

        }


        JButton botonFitxar = new JButton("Fitxar");
        panelMecan.add(botonFitxar);
        botonFitxar.setBounds(220,230,140,20);

        JLabel checkIn = new JLabel();
        panelMecan.add(checkIn);
        checkIn.setBounds(225, 260, 180, 20);
        botonFitxar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el resultado de la función Fitxar()
                boolean validacion = mecanico.Fitxar();  // Usamos una variable local aquí

                // Actualizar el texto del JLabel en función del resultado de validacion
                if (validacion) {
                    checkIn.setText("Has fitxat l'entrada");
                } else {
                    checkIn.setText("Has fitxat la sortida");
                }

                // Volver a repintar el panel para asegurarse de que el cambio se vea
                panelMecan.revalidate();
                panelMecan.repaint();
            }
        });




        return panelMecan;
    }
}
