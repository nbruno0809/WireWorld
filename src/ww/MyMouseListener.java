package ww;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Kattintasokat figyelo listener
 *
 */
public class MyMouseListener implements MouseListener {
	/**
	 * A megfelelo Board
	 */
	private Board b;
	/**
	 * Megadja le van nyomva az eger
	 */
	private boolean pressed;
	
	/**
	 * Constructor
	 * @param b Board
	 */
	public MyMouseListener(Board b) {this.b=b;}

	/**
	 * Overridolt metodus
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * Overridolt metodus
	 * Lenyomas hatasara megvaltoztatja az eger altal mutatott cella allapotat,
	 * a lenyomott gombtol fuggoen
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		pressed=true;
		SimulationCell clicked = (SimulationCell)e.getSource();
		Cell c=b.getCellAt(clicked.x(), clicked.y());
		if(e.getButton() == MouseEvent.BUTTON1) {
			if (c.getState() == State.EMPTY)
				c.setState(State.CONNECTOR);
			else 
				c.setState(State.EMPTY);
		} else {
			if (c.getState() == State.HEAD || c.getState() == State.TAIL)
				c.setState(State.CONNECTOR);
			else 
				c.setState(State.HEAD);
		}
		clicked.setBg(b);
	}

	/**
	 *Overridolt metodus
	 *
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		pressed=false;
		
	}

	/**
	 * Overridolt metodus
	 * Az eger altal erintett mezok tartalmat valtozataja amig a gomb le van nyomva
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (pressed) {
			SimulationCell clicked = (SimulationCell)e.getSource();
			Cell c=b.getCellAt(clicked.x(), clicked.y());
			if (c.getState() == State.EMPTY) {
				c.setState(State.CONNECTOR);
				clicked.setBg(b);
			}
		}	
	}

	/**
	 *Overridolt metodus
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
