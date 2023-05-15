package PaqB05.interfaz;

import javax.swing.*;
import PaqB05.Contenedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInfContenedor extends JFrame {
    public JPanel miPanel;
    private JTextField nIdentificacionTextField;
    private JTextField pesoTextField;
    private JTextArea descTextArea;
    private JTextField empRemitenteTextField;
    private JTextField empReceptoraTextField;
    private JTextField procedenciaTextField;
    private JRadioButton prioridad1RadioButton;
    private JRadioButton prioridad2RadioButton;
    private JRadioButton prioridad3RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JButton atrasButton;
    private VentanaPrincipal principal;         // VentanaPrincipal, para volver a ella cuando el usuario haya finalizado de consultar los datos de un contenedor

    public VentanaInfContenedor(VentanaPrincipal v) {
        setContentPane(miPanel);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        pack();
        setVisible(false);
        setIconImage(new ImageIcon("src/PaqB05/interfaz/contenedores.png").getImage());
        this.principal = v;

        // ActionListener para volver al panel principal
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.setContentPane(principal.miPanel);
                repaint();
            }
        });
    }

    /**
     * Asigna a los campos de este panel los datos que contenga el objeto Contenedor pasado como parámetro.
     * @param c Contenedor a mostrar
     */
    public void asignarDatos(Contenedor c) {
        nIdentificacionTextField.setText("" + c.getIdentificador());
        pesoTextField.setText("" + c.getPeso());
        descTextArea.setText(c.getDescripcion());
        empRemitenteTextField.setText(c.getRemitente());
        empReceptoraTextField.setText(c.getReceptor());

        if (c.getPrioridad() == 1) {
            prioridad1RadioButton.setSelected(true);
        } else if (c.getPrioridad() == 2) {
            prioridad2RadioButton.setSelected(true);
        } else {
            prioridad3RadioButton.setSelected(true);
        }

        if (c.isAduanas()) {
            inspeccionadoEnAduanasCheckBox.setSelected(true);
        }

        procedenciaTextField.setText(c.getProcedencia());
    }
}
