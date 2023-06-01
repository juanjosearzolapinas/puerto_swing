package PaqB05.interfaz;

import PaqB05.Contenedor;
import PaqB05.Hub;
import PaqB05.Puerto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTextField nIdentificacionTextField;
    private JComboBox paisProcedenciaComboBox;
    private JTextField pesoTextField;
    private JRadioButton prioridadRadioButton1;
    private JRadioButton prioridadRadioButton2;
    private JRadioButton prioridadRadioButton3;
    private JCheckBox inspeccionadoCheckBox1;
    private JTextArea descContenidoTextArea1;
    private JTextField empRemitenteTextField1;
    private JTextField empReceptoraTextField1;
    private JLabel estadoJLabel;
    private JTextArea estadoTextArea;
    private JButton apilarButton1;
    private JButton desapilarButton;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField nColumnaTextField;
    private JTextField idContenedorTextField;
    private JTextField cuentaPaisTxtField;
    private JComboBox paisBusquedaComboBox;
    public JPanel miPanel;
    private JLabel erroresJField;
    private JRadioButton SeleccionarHubButton2;
    private JRadioButton SeleccionarHubButton1;
    private JRadioButton SeleccionarHubButton3;
    private JButton contadorHUB;
    private JButton EXAMENButton;
    private Puerto puerto;
    private String[] paises = {"Afganistán","Albania","Alemania","Andorra","Angola","Antigua y Barbuda", "Arabia Saudita","Argelia","Argentina","Armenia","Australia","Austria","Azerbaiyán","Bahamas","Bangladés","Barbados","Baréin","Bélgica","Belice","Benín","Bielorrusia","Birmania","Bolivia","Bosnia y Herzegovina","Botsuana","Brasil","Brunéi","Bulgaria","Burkina Faso","Burundi","Bután","Cabo Verde","Camboya","Camerún","Canadá","Catar","Chad","Chile","China","Chipre","Ciudad del Vaticano","Colombia","Comoras","Corea del Norte","Corea del Sur","Costa de Marfil","Costa Rica","Croacia","Cuba","Dinamarca","Dominica","Ecuador","Egipto","El Salvador","Emiratos Árabes Unidos","Eritrea","Eslovaquia","Eslovenia","España","Estados Unidos","Estonia","Etiopía","Filipinas","Finlandia","Fiyi","Francia","Gabón","Gambia","Georgia","Ghana","Granada","Grecia","Guatemala","Guyana","Guinea","Guinea ecuatorial","Guinea-Bisáu","Haití","Honduras","Hungría","India","Indonesia","Irak","Irán","Irlanda","Islandia","Islas Marshall","Islas Salomón","Israel","Italia","Jamaica","Japón","Jordania","Kazajistán","Kenia","Kirguistán","Kiribati","Kuwait","Laos","Lesoto","Letonia","Líbano","Liberia","Libia","Liechtenstein","Lituania","Luxemburgo","Madagascar","Malasia","Malaui","Maldivas","Malí","Malta","Marruecos","Mauricio","Mauritania","México","Micronesia","Moldavia","Mónaco","Mongolia","Montenegro","Mozambique","Namibia","Nauru","Nepal","Nicaragua","Níger","Nigeria","Noruega","Nueva Zelanda","Omán","Países Bajos","Pakistán","Palaos","Palestina","Panamá","Papúa Nueva Guinea","Paraguay","Perú","Polonia","Portugal","Reino Unido","República Centroafricana","República Checa","República de Macedonia","República del Congo","República Democrática del Congo","República Dominicana","República Sudafricana","Ruanda","Rumanía","Rusia","Samoa","San Cristóbal y Nieves","San Marino","San Vicente y las Granadinas","Santa Lucía","Santo Tomé y Príncipe","Senegal","Serbia","Seychelles","Sierra Leona","Singapur","Siria","Somalia","Sri Lanka","Suazilandia","Sudán","Sudán del Sur","Suecia","Suiza","Surinam","Tailandia","Tanzania","Tayikistán","Timor Oriental","Togo","Tonga","Trinidad y Tobago","Túnez","Turkmenistán","Turquía","Tuvalu","Ucrania","Uganda","Uruguay","Uzbekistán","Vanuatu","Venezuela","Vietnam","Yemen","Yibuti","Zambia","Zimbabue"};
    private int numHub;                         // Hub de contenedores actual
    private VentanaInfContenedor info;          // Ventana de información, para el cambio de paneles
    private VentanaPrincipal estaVentana;       // Puntero al objeto de esta propia ventana, para el cambio de paneles

    public VentanaPrincipal(Puerto puerto) {
        // Añadimos el listado de países a los Combo Box
        paisProcedenciaComboBox.setModel(new DefaultComboBoxModel(paises));
        paisBusquedaComboBox.setModel(new DefaultComboBoxModel(paises));

        // Opciones de la ventana
        setContentPane(miPanel);
        setTitle("Gestión de contenedores");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(new ImageIcon("src/PaqB05/interfaz/contenedores.png").getImage());
        pack();

        this.numHub = 1;
        this.SeleccionarHubButton1.setSelected(true);
        this.puerto = puerto;
        this.nIdentificacionTextField.setText("" + Hub.getNumContenedor());
        this.estaVentana = this;
        actualizarEstado();

        // ActionListener para apilar un contenedor con los datos indicados
        apilarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prioridad;

                if (prioridadRadioButton1.isSelected()) {
                    prioridad = 1;
                } else if (prioridadRadioButton2.isSelected()) {
                    prioridad = 2;
                } else {
                    prioridad = 3;
                }

                // Creamos el contenedor con los datos introducidos por el usuario
                Contenedor contenedor = new Contenedor(
                        Integer.parseInt(((!pesoTextField.getText().isEmpty()) ? pesoTextField.getText() : "0")),
                        (String)paisProcedenciaComboBox.getSelectedItem(),
                        inspeccionadoCheckBox1.isSelected(),
                        prioridad,
                        descContenidoTextArea1.getText(),
                        empRemitenteTextField1.getText(),
                        empReceptoraTextField1.getText()
                );

                if (puerto.insertarEnHub(contenedor, numHub)) {
                    erroresJField.setText("¡Contenedor apilado!");
                    nIdentificacionTextField.setText("" + Hub.getNumContenedor());
                    actualizarEstado();
                } else {
                    erroresJField.setText("[ERROR] No hay espacio para apilar. Selecciona otro Hub.");
                }
            }
        });

        // ActionListeners para el cambio de prioridad del contenedor
        prioridadRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadRadioButton2.setSelected(false);
                prioridadRadioButton3.setSelected(false);
            }
        });
        prioridadRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadRadioButton1.setSelected(false);
                prioridadRadioButton3.setSelected(false);
            }
        });
        prioridadRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prioridadRadioButton1.setSelected(false);
                prioridadRadioButton2.setSelected(false);
            }
        });


        contadorHUB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JOptionPane.showMessageDialog(null, "LOS CONTENEDORES QUE HAY EN ESTE HUB SON: " + (Hub.getNumContenedor()-1));


            }
        });

        // ActionListener para calcular la cantidad total de contenedores (de todo el puerto) que provienen de un determinado país
        cuantosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuentaPaisTxtField.setText("" + puerto.buscarPorPais(
                        paisBusquedaComboBox.getSelectedItem().toString())
                );
            }
        });

        // ActionListener para desapilar el primer contenedor de la columna indicada.
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nColumnaTextField.getText().isEmpty()) {
                    erroresJField.setText("[ERROR] Indica un número de columna.");
                } else {
                    if (puerto.desapilar(Integer.parseInt(nColumnaTextField.getText()), numHub)) {
                        erroresJField.setText("¡Desapilado!");
                        actualizarEstado();
                    } else {
                        erroresJField.setText("[ERROR] No se ha podido desapilar ningún contenedor.");
                    }
                }
            }
        });

        // ActionListener para mostrar los datos del Contenedor con el identificador indicado.
        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor contenedor =
                        puerto.buscarContenedor(Integer.parseInt(idContenedorTextField.getText()),
                                numHub);

                if (contenedor != null) {
                    info = new VentanaInfContenedor(estaVentana);
                    info.asignarDatos(contenedor);
                    setContentPane(info.miPanel);
                    repaint();
                } else {
                    erroresJField.setText("[ERROR] No se ha encontrado el contenedor en el hub. Prueba a " +
                            "seleccionar otro hub para buscar en él.");
                }
            }
        });

        // ActionListeners para la selección de Hub
        SeleccionarHubButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionarHubButton2.setSelected(false);
                SeleccionarHubButton3.setSelected(false);
                numHub = 1;
                actualizarEstado();
            }
        });
        SeleccionarHubButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionarHubButton1.setSelected(false);
                SeleccionarHubButton3.setSelected(false);
                numHub = 2;
                actualizarEstado();
            }
        });
        SeleccionarHubButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionarHubButton2.setSelected(false);
                SeleccionarHubButton1.setSelected(false);
                numHub = 3;
                actualizarEstado();
            }
        });


        //ACTION LISTENER PARA PODER DEVOLVER EL TOTAL DE CONTENEDORES CHECKEADOS EN ADUANAS
        EXAMENButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int contador = 0;

                if(e.getSource() == EXAMENButton){

                    if(prioridadRadioButton1.isSelected()) {

                        contador = puerto.Prioritarios2(1);

                        JOptionPane.showMessageDialog(prioridadRadioButton1, "el total de contenedores con esa prioridad es: " + contador);

                    }

                    if(prioridadRadioButton2.isSelected()) {

                        contador = puerto.Prioritarios2(2);

                        JOptionPane.showMessageDialog(prioridadRadioButton2, "el total de contenedores con esa prioridad es: " + contador);

                    }

                    if(prioridadRadioButton3.isSelected()) {

                        contador = puerto.Prioritarios2(3);

                        JOptionPane.showMessageDialog(prioridadRadioButton3, "el total de contenedores con esa prioridad es: " + contador);

                    }

                }



            }
        });

    }

    /**
     * Actualiza el estado del mapa de contenedores del Hub actual.
     */
    private void actualizarEstado() {
        estadoTextArea.setText(puerto.getHub(numHub-1).toString());
        estadoJLabel.setText("Estado (Libre u Ocupado) - Hub " + (numHub));
    }
}
