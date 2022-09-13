package ww;

import java.awt.event.ActionEvent;

/**
 * Menugomb ami megallitja a szimulaciot
 *
 */
public class PauseButton extends MenuButton {
	private static final long serialVersionUID = 1L;
	
	/** 
	 * Constructor
	 * @param b Board
	 * @param t Timer
	 */
	public PauseButton(Board b, Timer t) {
		super(b,t);
		setText("Pause");
	}
	
	/**
	 *Elinditja vagy megallitja a szimulaciot
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.setPaused(!timer.isPaused());
		if (timer.isPaused()) 
			setText("Start");
		else
			setText("Pause");		
	}

}
