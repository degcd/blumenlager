package UI;

import java.awt.Window;
import javax.swing.JOptionPane;

public class HinweisView {

	public HinweisView(Window window, String info) {
		JOptionPane.showMessageDialog(window, info);
	}
}
