package ww;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;

/**
 * Menugomb ami fajlba menti a szimulacio aktualis allapotat
 *
 */
public class SaveButton extends MenuButton {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param b Board
	 * @param t Timer
	 */
	public SaveButton(Board b, Timer t) {
		super(b,t);
		setText("Save");
	}

	/**
	 * Fajlba menti a Boardot
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			board.saveToFile(file);
		}
	}

}
