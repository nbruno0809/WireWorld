package ww;

import java.awt.event.ActionEvent;

/**
 * Torlo gomb
 *
 */
public class ClearButton extends MenuButton {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param b Board
	 * @param t Timer
	 */
	public ClearButton(Board b, Timer t) {
		super(b,t);
		setText("Clear");
	}

	/**
	 * Gombnyomas hatasara meghivja a board clear metodusat vagyis
	 * az oszes cella allapota EMPTY lesz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		board.clear();
	}

}
