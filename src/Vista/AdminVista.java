package Vista;

import Modelo.Astronauta;
import Modelo.Mecanico;
import Modelo.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

public class AdminVista {
    public static JScrollPane CreateAdminPage(Usuario user){
        
        BackgroundPanel panelAdmin = new BackgroundPanel("../Assets/images.png");
        panelAdmin.setLayout(null);
        
        JLabel createUser = new JLabel("CREAR USUARIO");
        createUser.setBounds(10, 10, 100, 20);
        panelAdmin.add(createUser);
        
        Color blanco = new Color(255, 255, 255);
        
        
        
        JLabel userNameLabel = new JLabel("Nombre de Usuario: ");
        userNameLabel.setForeground(blanco);
        JTextField userName = new JTextField(8);
        userNameLabel.setBounds(10, 40, 150, 20);
        userName.setBounds(160, 40, 80, 20);
        panelAdmin.add(userNameLabel);
        panelAdmin.add(userName);
        
        JLabel passwordLabel = new JLabel("Contraseña: ");
        passwordLabel.setForeground(blanco);
        JTextField password = new JTextField(8);
        passwordLabel.setBounds(10, 70, 150, 20);
        password.setBounds(160, 70, 80, 20);
        panelAdmin.add(passwordLabel);
        panelAdmin.add(password);
        
        JLabel roleLabel = new JLabel("Rol: ");
        roleLabel.setForeground(blanco);
        String[] roles = {"ADMIN", "MECA", "ASTRO"};
        JComboBox<String> role = new JComboBox<>(roles);
        roleLabel.setBounds(10, 100, 150, 20);
        role.setBounds(160, 100, 80, 20);
        panelAdmin.add(roleLabel);
        panelAdmin.add(role);
        
        JLabel nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setForeground(blanco);
        JTextField nombre = new JTextField(8);
        nombreLabel.setBounds(10, 130, 150, 20);
        nombre.setBounds(160, 130, 80, 20);
        panelAdmin.add(nombreLabel);
        panelAdmin.add(nombre);
        
        JLabel sexoLabel = new JLabel("Sexo: ");
        sexoLabel.setForeground(blanco);
        String[] sexos = {"Masculino", "Femenino"};
        JComboBox<String> sexo = new JComboBox<>(sexos);
        sexoLabel.setBounds(10, 160, 150, 20);
        sexo.setBounds(160, 160, 80, 20);
        panelAdmin.add(sexoLabel);
        panelAdmin.add(sexo);
        
        JLabel edadLabel = new JLabel("Edad: ");
        edadLabel.setForeground(blanco);
        JTextField edad = new JTextField(8);
        edadLabel.setBounds(10, 190, 150, 20);
        edad.setBounds(160, 190, 80, 20);
        panelAdmin.add(edadLabel);
        panelAdmin.add(edad);
        
        JLabel direccionLabel = new JLabel("Dirección: ");
        direccionLabel.setForeground(blanco);
        JTextField direccion = new JTextField(8);
        direccionLabel.setBounds(10, 220, 150, 20);
        direccion.setBounds(160, 220, 80, 20);
        panelAdmin.add(direccionLabel);
        panelAdmin.add(direccion);
        
        JLabel mecaLabel = new JLabel("Si es mecanico: --------- ");
        mecaLabel.setForeground(blanco);
        mecaLabel.setBounds(10, 250, 150, 20);
        panelAdmin.add(mecaLabel);
        
        JLabel astroLabel = new JLabel("Si es astronauta: --------- ");
        astroLabel.setForeground(blanco);
        astroLabel.setBounds(200, 250, 150, 20);
        panelAdmin.add(astroLabel);
        
        JLabel salarioLabel = new JLabel("Salario: ");
        salarioLabel.setForeground(blanco);
        JTextField salario = new JTextField(8);
        salarioLabel.setBounds(10, 280, 90, 20);
        salario.setBounds(110, 280, 80, 20);
        panelAdmin.add(salarioLabel);
        panelAdmin.add(salario);
        
        JLabel astroDataPrimerVueloLabel = new JLabel("Data Primer Vol: ");
        astroDataPrimerVueloLabel.setForeground(blanco);
        JTextField astroDataPrimerVuelo = new JTextField(8);
        astroDataPrimerVueloLabel.setBounds(200, 280, 90, 20);
        astroDataPrimerVuelo.setBounds(300, 280, 80, 20);
        panelAdmin.add(astroDataPrimerVueloLabel);
        panelAdmin.add(astroDataPrimerVuelo);
        
        JLabel tallerLabel = new JLabel("Taller: ");
        tallerLabel.setForeground(blanco);
        JTextField taller = new JTextField(8);
        tallerLabel.setBounds(10, 310, 90, 20);
        taller.setBounds(110, 310, 80, 20);
        panelAdmin.add(tallerLabel);
        panelAdmin.add(taller);
        
        JLabel misionesOKLabel = new JLabel("Misiones OK: ");
        misionesOKLabel.setForeground(blanco);
        JTextField misionesOK = new JTextField(8);
        misionesOKLabel.setBounds(200, 310, 90, 20);
        misionesOK.setBounds(300, 310, 80, 20);
        panelAdmin.add(misionesOKLabel);
        panelAdmin.add(misionesOK);
        
        JLabel anosExpLabel = new JLabel("Anos exp: ");
        anosExpLabel.setForeground(blanco);
        JTextField anosExp = new JTextField(8);
        anosExpLabel.setBounds(10, 340, 90, 20);
        anosExp.setBounds(110, 340, 80, 20);
        panelAdmin.add(anosExpLabel);
        panelAdmin.add(anosExp);
        
        JLabel misionesKOLabel = new JLabel("Misiones KO: ");
        misionesKOLabel.setForeground(blanco);
        JTextField misionesKO = new JTextField(8);
        misionesKOLabel.setBounds(200, 340, 90, 20);
        misionesKO.setBounds(300, 340, 80, 20);
        panelAdmin.add(misionesKOLabel);
        panelAdmin.add(misionesKO);
        
        JLabel ciudadTrabajoLabel = new JLabel("Ciudad Trabajo: ");
        ciudadTrabajoLabel.setForeground(blanco);
        JTextField ciudadTrabajo = new JTextField(8);
        ciudadTrabajoLabel.setBounds(10, 370, 90, 20);
        ciudadTrabajo.setBounds(110, 370, 80, 20);
        panelAdmin.add(ciudadTrabajoLabel);
        panelAdmin.add(ciudadTrabajo);
        
        JLabel rangoMilitarLabel = new JLabel("Rango Militar: ");
        rangoMilitarLabel.setForeground(blanco);
        JTextField rangoMilitar = new JTextField(8);
        rangoMilitarLabel.setBounds(200, 370, 90, 20);
        rangoMilitar.setBounds(300, 370, 80, 20);
        panelAdmin.add(rangoMilitarLabel);
        panelAdmin.add(rangoMilitar);
        
        JButton create = new JButton("Crear Usuario");
        create.setBounds(10, 400, 130, 20);
        panelAdmin.add(create);
        
        create.addActionListener(e -> {
            
            if(role.getSelectedItem().equals("ADMIN")) {
                String user1 = userName.getText();
                String pass = password.getText();
                String rol = (String) role.getSelectedItem();
                String nombre1 = nombre.getText();
                String sexo1 = Objects.requireNonNull(sexo.getSelectedItem()).toString();
                int edad1 = Integer.parseInt(edad.getText());
                String direccion1 = direccion.getText();
                
                Usuario usuarioAlta = new Usuario(user1, rol, nombre1, sexo1, edad1, direccion1);
                
                try {
                    Usuario.addUsuario(usuarioAlta, pass);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                
            } else if(role.getSelectedItem().equals("MECA")) {
                String user1 = userName.getText();
                String pass = password.getText();
                String rol = (String) role.getSelectedItem();
                String nombre1 = nombre.getText();
                String sexo1 = Objects.requireNonNull(sexo.getSelectedItem()).toString();
                int edad1 = Integer.parseInt(edad.getText());
                String direccion1 = direccion.getText();
                int salario1 = Integer.parseInt(salario.getText());
                int taller1 = Integer.parseInt(taller.getText());
                int anos1 = Integer.parseInt(anosExp.getText());
                String ciudadTrabajo1 = ciudadTrabajo.getText();
                
                Mecanico usuarioAlta = new Mecanico(user1, rol, nombre1, sexo1, edad1, direccion1, salario1, taller1, anos1, ciudadTrabajo1);
                
                try {
                    System.out.println(Usuario.addUsuario(usuarioAlta, pass));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else if(role.getSelectedItem().equals("Astro")) {
                String user1 = userName.getText();
                String pass = password.getText();
                String rol = (String) role.getSelectedItem();
                String nombre1 = nombre.getText();
                String sexo1 = Objects.requireNonNull(sexo.getSelectedItem()).toString();
                int edad1 = Integer.parseInt(edad.getText());
                String direccion1 = direccion.getText();
                Date fechaPrimerVuelo1 = new Date(1,1,1);
                int misionesOK1 = Integer.parseInt(misionesOK.getText());
                int misionesKO1 = Integer.parseInt(misionesKO.getText());
                String rangoMilitar1 = rangoMilitar.getText();
                
                Astronauta usuarioAlta = new Astronauta(user1, rol, nombre1, sexo1, edad1, direccion1, fechaPrimerVuelo1, misionesOK1, misionesKO1, rangoMilitar1);
                
                try {
                    Usuario.addUsuario(usuarioAlta, pass);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        
        JLabel deleteUser = new JLabel("ELIMINAR USUARIO");
        deleteUser.setBounds(10, 450, 150, 20);
        panelAdmin.add(deleteUser);
        
        JLabel userNameDeleteLabel = new JLabel("Nombre: ");
        userNameDeleteLabel.setForeground(blanco);
        JTextField userNameDelete = new JTextField(8);
        userNameDeleteLabel.setBounds(10, 480, 90, 20);
        userNameDelete.setBounds(110, 480, 80, 20);
        panelAdmin.add(userNameDeleteLabel);
        panelAdmin.add(userNameDelete);
        
        JButton delete = new JButton("Eliminar Usuario");
        delete.setBounds(10, 510, 130, 20);
        panelAdmin.add(delete);
        
        delete.addActionListener(e -> {
            String user1 = userNameDelete.getText();
            
            Usuario.deleteUsuario(user1);
        });
        
        JScrollPane scroll = new JScrollPane(panelAdmin);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        scroll.setBounds(0, 0, 400, 550);  // Definir el tamaño y posición del JScrollPane
        panelAdmin.setPreferredSize(new Dimension(400, 600));  // Ajustar el tamaño del panel interno
        
        return scroll;  // Retornar el JScrollPane en lugar de panelAdmin
    }
    
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;
        
        public BackgroundPanel(String filePath) {
            try {
                backgroundImage = new ImageIcon(getClass().getResource(filePath)).getImage();
            } catch (Exception e) {
                System.out.println("Error al cargar imagen");
            }
            setLayout(null);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
