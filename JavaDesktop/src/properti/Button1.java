
package properti;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author usu
 */
public class Button1 extends usu.widget.Button {

    /*
     * Serial version UID
     */
    private static final long serialVersionUID = 1L;

    public Button1() {
        
        setFont(getFont().deriveFont(Font.BOLD));
        setForeground(Color.WHITE);
       
    }
}
