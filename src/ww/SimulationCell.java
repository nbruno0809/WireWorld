package ww;

import javax.swing.JButton;

/**
 * Egy cella megjeleneseert felelos JButton
 *
 */
public class SimulationCell extends JButton {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Koordinatak
	 */
	private int x,y;
	
	/**
	 * Constructor
	 * @param x x koordinata
	 * @param y y koordinata
	 */
	public SimulationCell(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/** Megfelelo hatterszi beallitasa
	 * @param b Gombot tartalmazo Board
	 */
	public void setBg(Board b) {
		setBackground(b.getCellAt(x, y).color());
	}
	
	/** x getter
	 * @return x
	 */
	public int x() {return x;}
	/**
	 * y getter
	 * @return y
	 */
	public int y() {return y;}
}

	