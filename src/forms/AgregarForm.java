package forms;

import estructuras.DefensorEternia;
import estructuras.ListaSimple;
import estructuras.Nodo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarForm extends JFrame {

    private JPanel pGeneral;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox habilidadCombo;
    private JComboBox nivelCombo;
    private JComboBox regionCombo;
    private JButton agregarButton;
    private JButton menuPrincipalButton;
    private JTable table1;

    AgregarForm(ListaSimple listaSimple){
        setTitle("Form Agregar");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(540, 325));

        actualizarTabla(listaSimple);

        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm(listaSimple).setVisible(true);
                dispose();
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = -1;
                try{
                    id = Integer.parseInt(txtId.getText());
                    String nombre = txtNombre.getText();
                    String habilidadEspecial = habilidadCombo.getSelectedItem().toString();
                    int nivel = Integer.parseInt(nivelCombo.getSelectedItem().toString());
                    String region = regionCombo.getSelectedItem().toString();
                    listaSimple.agregarNodo(new DefensorEternia(id,nombre,habilidadEspecial,nivel,region));
                    actualizarTabla(listaSimple);
                }catch(Exception ex){JOptionPane.showMessageDialog(null,"Ingrese unicamente numeros en Id");}
            }
        });

    }


    public void actualizarTabla(ListaSimple listaSimple){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Id");
        dt.addColumn("Nombre");
        dt.addColumn("Habilidad Especial");
        dt.addColumn("Nivel de poder");
        dt.addColumn("Region");

        dt.addRow(new Object[]{
                "Id",
                "Nombre",
                "Habilidad Especial",
                "Nivel de poder",
                "Region"
        });

        Nodo actual = listaSimple.getCabeza();

        while(actual != null){
            DefensorEternia def = actual.dato;
            dt.addRow(new Object[]{
                    def.getId(),
                    def.getNombre(),
                    def.getHabilidadEspecial(),
                    def.getNivelPoder(),
                    def.getRegion()
            });
            actual = actual.siguiente;
        }
        table1.setModel(dt);
    }


    public static void main(String[] args) {
        ListaSimple listaSimple = new ListaSimple();
        new AgregarForm(listaSimple).setVisible(true);
    }

}
