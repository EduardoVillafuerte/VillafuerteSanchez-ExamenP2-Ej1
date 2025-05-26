package forms;

import estructuras.ListaSimple;
import estructuras.Recursividad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecursivoForm  extends JFrame{
    private JTextArea textArea1;
    private JButton menuPrincipalButton;
    private JPanel pGeneral;
    private Recursividad recursividad = new Recursividad();

    RecursivoForm(ListaSimple listaSimple){
        setTitle("Form Busqueda");
        setContentPane(pGeneral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(540, 325));

        textArea1.setText("");
        textArea1.append(recursividad.contar(listaSimple).toString());

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
        new RecursivoForm(listaSimple).setVisible(true);
    }
}
