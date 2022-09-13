package ww;

import java.awt.event.ActionEvent;

/**
 * Nem hasznalt osztaly!! Helyette SpeedComboBox
 *
 */
public class SpeedButton extends MenuButton {
	private static final long serialVersionUID = 1L;
	Speed speed;
	private enum Speed {
		Slow,
		Normal,
		Fast,
		SuperFast;
	}
	
	/**
	 * Constructor
	 * @param b Board
	 * @param t Timer
	 */
	public SpeedButton(Board b, Timer t) {
		super(b,t);
		speed=Speed.Normal;
		timer.setTime(700);
		setText("Speed: "+speed);
	}

	/**
	 * Sebbeseget valtoztatja
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(speed) {
		case Slow:
			timer.setTime(700);
			speed=Speed.Normal;
			break;
		case Normal:
			timer.setTime(100);
			speed=Speed.Fast;
			break;
		case Fast:
			timer.setTime(40);
			speed=Speed.SuperFast;
			break;
		case SuperFast:
			timer.setTime(1500);
			speed=Speed.Slow;
			break;
		default:
			break;
			
		}
		setText("Speed: "+speed);
	}

}
