/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDesktop;

import Form.Splash;
import javax.swing.SwingUtilities;

/**
 *
 * @author Natanawa Creative Design
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Splash kasir = new Splash();
                kasir.setVisible(true);
            }
        });
    }
}
