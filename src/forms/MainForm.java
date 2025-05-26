package forms;

import com.sun.tools.javac.Main;
import estructuras.ListaSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private JButton agregarDefensorButton;
    private JPanel pGeneral;
    private JButton búsquedaDeDefensoresButton;
    private JButton filtradoYOrdenamientoButton;
    private JButton conteoRecursivoPorHabilidadButton;

    MainForm(ListaSimple listaSimple) {

        setTitle("Form Principal");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(540, 325));

        agregarDefensorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarForm(listaSimple).setVisible(true);
                dispose();
            }
        });
        búsquedaDeDefensoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BusquedaForm(listaSimple).setVisible(true);
                dispose();
            }
        });

        filtradoYOrdenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FiltraryOrdenar(listaSimple).setVisible(true);
                dispose();
            }
        });

        conteoRecursivoPorHabilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RecursivoForm(listaSimple).setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ListaSimple listaSimple = new ListaSimple();
        new MainForm(listaSimple).setVisible(true);
    }

}
