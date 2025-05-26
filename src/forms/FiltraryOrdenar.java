package forms;

import estructuras.ListaSimple;
import estructuras.Nodo;
import estructuras.OrdenamientoBurbuja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltraryOrdenar extends JFrame{
    private JComboBox comboBox1;
    private JButton filtrarButton;
    private JButton menuPrincipalButton;
    private JTable table1;
    private JPanel pGeneral;
    private OrdenamientoBurbuja orBurbuja = new OrdenamientoBurbuja();

    FiltraryOrdenar(ListaSimple listaSimple){
        setTitle("Form Principal");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(740, 525));
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm(listaSimple).setVisible(true);
                dispose();
            }
        });
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = comboBox1.getSelectedItem().toString();
                actualizarTabla(listaSimple, ciudad);
            }
        });
    }

    public void actualizarTabla(ListaSimple listaSimple, String ciudad){
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

        for(Nodo nodo: orBurbuja.bubbleSort(listaSimple,ciudad)){
            dt.addRow(new Object[]{
                    nodo.dato.getId(),
                    nodo.dato.getNombre(),
                    nodo.dato.getHabilidadEspecial(),
                    nodo.dato.getNivelPoder(),
                    nodo.dato.getRegion()
            });
        }
        table1.setModel(dt);
    }

    public static void main(String[] args) {
        ListaSimple listaSimple = new ListaSimple();
        new FiltraryOrdenar(listaSimple).setVisible(true);
    }

}
