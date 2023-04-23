package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JTextField husyField;
    private JTextField kraliciField;
    private JButton vypocitatButton;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();

    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));


        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setEnabled(true);
        husyLabel.setLabelFor(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setDisplayedMnemonic('H');
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setEnabled(true);
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(),"span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavField.setEditable(false);
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavLabel.setDisplayedMnemonic(0);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouField.setEditable(false);
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetNohouLabel);
        add(pocetNohouField);



        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handlevypocitat);
    }
    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');


        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));

        buttonBar.add(vypocitatButton);
        return buttonBar;

}

    private void handlevypocitat(ActionEvent actionEvent) {



        int husy = Integer.parseInt(husyField.getText());
        int kralici= Integer.parseInt(kraliciField.getText());

        int pocetHlav = husy+kralici;
        int pocetNohou = husy*2 + kralici*4;

        System.out.printf("Husy: %s", husyField.getText()).println();
        System.out.printf("Králíci: %s", kraliciField.getText()).println();

        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNohou));
        System.out.printf("Počet hlav: %s", pocetHlav);
        System.out.printf("počet nohou: %s",pocetNohou);












    }
}
