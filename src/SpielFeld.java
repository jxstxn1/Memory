import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpielFeld extends JFrame {

    private int spiefelgroesse = 6;
    public Knopf knoepfe[][] = new Knopf[spiefelgroesse][spiefelgroesse];
    GridLayout gitterLayout = new GridLayout(0, spiefelgroesse);
    JPanel panel = new JPanel();
    //JTextField anzeige = new JTextField();
    //JButton neustart = new JButton("Neustart");

    SpielSteuerung dieSpielSteuerung;

    public void fuegeAllesZurOberflaecheHinzu(final Container pane) {
        panel.setLayout(gitterLayout);

        for (int cy = 0; cy < spiefelgroesse; cy++) {
            for (int cx = 0; cx < spiefelgroesse; cx++) {

                //erzeuge Button
                knoepfe[cx][cy] = new Knopf(cx, cy);

                //fuege Button dem Layout hinzu
                panel.add(knoepfe[cx][cy]);

                //füge dem Knopf eine Funktion hinzu, wenn er gedrückt wird
                knoepfe[cx][cy].addActionListener((ActionEvent e) -> {
                    int px = ((Knopf) e.getSource()).gibX();
                    int py = ((Knopf) e.getSource()).gibY();
                    System.out.println(px+"/"+py + " wurde gedrueckt");
                    dieSpielSteuerung.linksKlick(px, py);
                });
            }
        }

        //fuege die Textanzeige hinzu
        //panel.add(neustart);
        //neustart.addActionListener((ActionEvent e) -> {
        //was passiert, wenn neustart gedrueckt wird
        //});
        //panel.add(anzeige);
        pane.add(panel);
        dieSpielSteuerung = new SpielSteuerung(this);
    }



    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SpielFeld gitter = new SpielFeld();
                gitter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gitter.fuegeAllesZurOberflaecheHinzu(gitter.getContentPane());
                gitter.pack();
                gitter.setVisible(true);

            }
        });
    }
}
