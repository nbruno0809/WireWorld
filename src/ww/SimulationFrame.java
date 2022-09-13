package ww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

/**
 * Program megjelenesenek kerete
 *
 */
public class SimulationFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Contructor ami letrehozza az ablakot a megfelelo parameterekel es menugombokkal
	 * @param b a szimulacio Boardja
	 * @param t a szimulacio Timere
	 */
	public SimulationFrame(Board b,Timer t) {
		super("Wire World");
		setSize(new Dimension(600,600));
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel menupanel = new JPanel();
		menupanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		menupanel.setBackground(Color.getHSBColor((float)0.54, 1, 1));
		menupanel.add(new SaveButton(b,t));
		menupanel.add(new PauseButton(b,t));
		menupanel.add(new ClearButton(b,t));
		//menupanel.add(new SpeedButton(b,t));
		menupanel.add(new SpeedComboBox(t));
		add(menupanel,BorderLayout.NORTH);	
	}

	
}
