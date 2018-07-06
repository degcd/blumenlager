package UI;

import java.awt.Window;
import javax.swing.JOptionPane;

public class HinweisView {

	/**
	 * Dient zur Anzeige von Erfolg bzw. Misserfolg beim Ein- oder Auslagern.
	 * Wird über den Controller angesprochen.
	 */
	
	public HinweisView(Window window, String info) {
		JOptionPane.showMessageDialog(window, info);
	}
}
