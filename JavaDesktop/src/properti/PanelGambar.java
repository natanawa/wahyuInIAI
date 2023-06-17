/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package properti;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author dimmas digital
 */
public class PanelGambar extends JPanel{
private Image image;

    public PanelGambar() {
        image = new ImageIcon(getClass().getResource("/image/databack.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        gd.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        gd.dispose();
    }
}
