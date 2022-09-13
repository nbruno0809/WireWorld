package ww;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * A Board megjelenitesere szolgalo osztaly
 *
 */
public class SimulationTable extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Megjelenitendo Board
	 */
	private Board board;
	/**
	 * Cellakat megjelenito SimulationCell-ak 2D-s tombje
	 */
	private SimulationCell[][] cells;
	
	/**
	 * Constructor
	 * @param b Simulationtable-hoz tartozo Board
	 */
	public SimulationTable(Board b) {
		board=b;
		cells = new SimulationCell[board.getX()][board.getY()];
		setLayout(new GridLayout(board.getX(),board.getY()));
		MyMouseListener mml = new MyMouseListener(board);
		for (int x=0;x<board.getX();x++) {
			for (int y=0;y<board.getY();y++) {
				cells[x][y] = new SimulationCell(x,y);
				cells[x][y].setBg(board);
				cells[x][y].addMouseListener(mml);
				add(cells[x][y]);
			}
		}
	}
	
	/**
	 * Frissiti a cellak szinet
	 */
	public void refresh() {
		for (int x=0;x<cells.length;x++) {
			for (int y=0;y<cells[x].length;y++) {
				cells[x][y].setBg(board);
			}
		}
	}
	

	
}
