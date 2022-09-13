package ww;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Menu gombok abstract ososztaja
 *
 */
public abstract class MenuButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * Board amihez a gomb tartozik
	 */
	protected Board board;
	/**
	 * Timer amihez a gomb tartozik
	 */
	protected Timer timer;
	
	/**
	 * Constructor
	 * @param b
	 * @param t
	 */
	public MenuButton(Board b, Timer t) {
		board=b;
		timer=t;
		addActionListener(this);
		this.setBackground(Color.WHITE);
	}
}
