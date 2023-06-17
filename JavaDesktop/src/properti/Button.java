
package properti;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author usu
 */
public class Button extends usu.widget.ButtonGlass {

    /*
     * Serial version UID
     */
    private static final long serialVersionUID = 1L;

    public Button() {
        super();
        setFont(getFont().deriveFont(Font.BOLD));
        setForeground(Color.WHITE);
        setRoundRect(true);
    }
}
