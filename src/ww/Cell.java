package ww;

import java.awt.Color;
import java.io.Serializable;

/**
 * Egy cellat reprezentalo osztaly
 *
 */
public class Cell implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Cella allapota
	 */
	private State state;
	
	/**
	 * Constructor
	 * @param state allapot
	 */
	public Cell(State state) {
		this.state=state;
	}
	
	/**
	 * Copy constructor
	 * @param old masolando cella
	 */
	public Cell(Cell old) {
		state=old.state;
	}
	
	/**
	 * state getter
	 * @return state
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * state setter
	 * @param s state uj erteke
	 */
	public void setState(State s) {
		state=s;
	}
	/*
	public String toString() {
		return state.toString();
	}
	*/
	/**
	 * Uj cellat hoz letre, a regi cella allpota alapja
	 * @param oldboard cellat tartalmazo Board
	 * @param x Cella x koordinataja
	 * @param y Cella y koordinataja
	 * @return uj cella
	 */
	public Cell nextStateCell(Board oldboard, int x, int y) {
		Cell newcell = new Cell(oldboard.getCellAt(x, y));
		if (newcell.state==State.HEAD) newcell.state=State.TAIL;
		else if (newcell.state==State.TAIL) newcell.state=State.CONNECTOR;
		else if (newcell.state==State.CONNECTOR) {
			if (oldboard.getNeighboursAt(x, y)==1 ||oldboard.getNeighboursAt(x, y)==2) {
				newcell.state = State.HEAD;
			}
		}
		return newcell;
	}
	
	/**
	 * Megadja milyen szinu a cella a jelenlegi allpota szerint
	 * @return megfelelo Color
	 */
	public Color color() {
		if (state == State.CONNECTOR) {return Color.YELLOW;}
		else if (state == State.HEAD) {return Color.BLUE;}
		else if (state == State.TAIL) {return Color.RED;}
		else {return Color.BLACK;}
	}


}
