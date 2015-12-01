package br.ufjf.dcc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JanelaCheck extends JFrame {

    JTextField txtMensagem = new JTextField("UFJF DCC LABPROG3", 15);
    JCheckBox chkNegrito = new JCheckBox("Negrito");
    JCheckBox chkItalico = new JCheckBox("Itálico");

    public JanelaCheck() throws HeadlessException {
        super("Checks!");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(txtMensagem);
        add(chkNegrito);
        add(chkItalico);

        SelecaoTratador handler = new SelecaoTratador();
        chkNegrito.addItemListener(handler);
        chkItalico.addItemListener(handler);

    }

    private class SelecaoTratador implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (chkItalico.isSelected() && chkNegrito.isSelected()) {
                txtMensagem.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 14));
            } else if (chkItalico.isSelected()) {
                txtMensagem.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
            } else if (chkNegrito.isSelected()) {
                txtMensagem.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            } else {
                txtMensagem.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            }
        }
    }

}
