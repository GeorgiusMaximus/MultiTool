package Features;

import javax.swing.*;

public class CircleCalculator {

    public CircleCalculator(){
        var eingabe = JOptionPane.showInputDialog("Type in the radius of the wanted circle: ");
        var radius = Double.parseDouble(eingabe);
        eingabe = JOptionPane.showInputDialog("Type in the unit of measurement: ");
        var einheit = eingabe;
        var umfang = 2.0 * 3.11415926535 * radius;
        var flaeche = 3.1415926535 * radius * radius;
        /*
        System.out.print("Scope: ");
        System.out.print(umfang);
        System.out.println(" " + einheit);
        System.out.print("Surface Area: ");
        System.out.print(flaeche);
        System.out.println(" " + einheit + '\u00b2');
         */
        JOptionPane.showMessageDialog(
                null, "Scope: " + umfang + " "
                        + einheit + "\nSurface Area: " + flaeche + " " + einheit + '\u00b2'
        );
    }

}
