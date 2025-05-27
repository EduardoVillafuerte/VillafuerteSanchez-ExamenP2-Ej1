package forms;

import estructuras.BusquedaLineal;
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
    private BusquedaLineal busquedaLineal;

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
        nivelCombo.setSelectedIndex(defensorEternia.getNivelPoder()-1);
        regionCombo.setSelectedItem(defensorEternia.getRegion());

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defensorEternia.setNombre(txtNombre.getText());
                defensorEternia.setHabilidadEspecial(habilidadCombo.getSelectedItem().toString());
                defensorEternia.setNivelPoder(Integer.parseInt(nivelCombo.getSelectedItem().toString()));
                defensorEternia.setRegion(regionCombo.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Se modifico con exito");
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        DefensorEternia defensorEternia = new DefensorEternia();
        new ModificarForm(defensorEternia).setVisible(true);
    }

}
