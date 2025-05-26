package forms;

import com.sun.tools.javac.Main;
import estructuras.BusquedaLineal;
import estructuras.DefensorEternia;
import estructuras.ListaSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaForm extends JFrame{

    private JButton buscarButton;
    private JButton menuPrincipalButton;
    private JPanel pGeneral;
    private JTextField textField1;
    private BusquedaLineal busquedaLineal = new BusquedaLineal();

    BusquedaForm(ListaSimple listaSimple){
        setTitle("Form Busqueda");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(540, 325));

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DefensorEternia defensorEternia = busquedaLineal.buscarLineal(listaSimple, Integer.parseInt(textField1.getText()));
                    if( defensorEternia != null)
                        new ModificarForm(defensorEternia).setVisible(true);
                    else
                        JOptionPane.showMessageDialog(null, "No se encontro esta ID","Warning",JOptionPane.WARNING_MESSAGE);

                }catch(Exception ex){JOptionPane.showMessageDialog(null,"Ingrese solo numeros");}
            }
        });
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm(listaSimple).setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ListaSimple listaSimple = new ListaSimple();
        new BusquedaForm(listaSimple).setVisible(true);
    }

}
