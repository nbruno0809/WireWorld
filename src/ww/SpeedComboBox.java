package ww;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;


/**
 * Szimulacio sebesseget lehet kivalasztani ezzel a JComboBoc-bol szarmazo osztallyal
 *
 */
public class SpeedComboBox extends JComboBox<Speed> implements ActionListener{
	private static final long serialVersionUID = 1L;
	/**
	 * A szimlacio Timer-e
	 */
	private Timer timer;
	
	/**
	 * Constructor
	 * @param t Timer
	 */
	public SpeedComboBox(Timer t) {
		super(new Speed[] {Speed.Slow,Speed.Normal,Speed.Fast,Speed.SuperFast});
		setBackground(Color.WHITE);
		setSelectedIndex(1);
		addActionListener(this);
		timer=t;
	}
	
	/**
	 * A kivalasztott sebessegre allitja szimulaciot
	 */
	public void actionPerformed(ActionEvent e) {
		SpeedComboBox scb = (SpeedComboBox)e.getSource();
		switch((Speed)scb.getSelectedItem()) {
		case Slow:
			timer.setTime(1500);
			break;
		case Normal:
			timer.setTime(700);
			break;
		case Fast:
			timer.setTime(100);
			break;
		case SuperFast:
			timer.setTime(40);
			break;
		default:
			break;
			
		}
	}
}
