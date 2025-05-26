package forms;

import estructuras.DefensorEternia;
import estructuras.ListaSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarForm extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox habilidadCombo;
    private JComboBox nivelCombo;
    private JComboBox regionCombo;
    private JButton modificarButton;
    private JButton volverButton;
    private JPanel pGeneral;

    ModificarForm(DefensorEternia defensorEternia){

        setTitle("Form Busqueda");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(740, 525));

        txtId.setText(""+ defensorEternia.getId());
        txtNombre.setText(defensorEternia.getNombre());
        habilidadCombo.setSelectedItem(defensorEternia.getHabilidadEspecial());
        nivelCombo.setSelectedItem(defensorEternia.getNivelPoder());
        regionCombo.setSelectedItem(defensorEternia.getRegion());

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        DefensorEternia defensorEternia = new DefensorEternia();
        new ModificarForm(defensorEternia).setVisible(true);
    }

}
