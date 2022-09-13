package ww;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

/**
 * Start menu osztaly
 *
 */
public class StartMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	/**
	 * A szimulacio Boardja
	 */
	private Board board;
	/**
	 * false amig nincsenek kivalaztva a parametrek a szimulaciohoz, true ha keszen all a szimulaciora
	 */
	boolean ready;
	/**
	 * Board magassaaga es szelessegenek kivalasztasahoz szukseges SpinnerModelek
	 */
	private SpinnerModel xmodel, ymodel;
	/**
	 * Start gomb es File-bol valo betoltes gombja
	 */
	private JButton start_button, load_button;
	
	/**
	 * Program belepesi pontja
	 * Objektumok letrehozasa
	 * @param args
	 */
	public static void main(String[] args) {
		StartMenu m = new StartMenu();
		while (!m.isReady()) {
			try {Thread.sleep(2000);}
			catch (InterruptedException e) {}
		}
		
		Board b = m.getBoard();
		SimulationTable st = new SimulationTable(b);
		b.setST(st);
		Timer t = new Timer(b);
		SimulationFrame sf = new SimulationFrame(b,t);
		sf.add(st,BorderLayout.CENTER);
		sf.setVisible(true);
		t.start();
	}
	
	/**
	 * Constructor
	 */
	public StartMenu() {
		super("Start menu");
		ready=false;
		setLayout(new BorderLayout());
		setSize(500,80);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		start_button = new JButton("Start");
		start_button.addActionListener(this);
		load_button = new JButton("Load from file");
		load_button.addActionListener(this);
		xmodel = new SpinnerNumberModel(20,1, 150, 1);     
		JSpinner xnumber = new JSpinner(xmodel);
		ymodel = new SpinnerNumberModel(20, 1, 150, 1);     
		JSpinner ynumber = new JSpinner(ymodel);
		JLabel oszlop = new JLabel("Oszlopok száma:");
		JLabel sor = new JLabel("Sorok száma:");
		JPanel panel = new JPanel();
		panel.add(oszlop);
		panel.add(xnumber);
		panel.add(sor);
		panel.add(ynumber);
		panel.add(start_button);
		panel.add(load_button);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	/**
	 * Megadja keszen all-e a program a szimulaciora
	 * @return reeady
	 */
	public boolean isReady() {return ready;}
	/**
	 * board getter
	 * @return board
	 */
	public Board getBoard() {return board;}
	
	/**
	 * Start gomb kattintasara a megadott parameterekkel elinditja a szimulaciot
	 * Load gomb hatasara betolti a kivalasztott filebol a mentett szimulaciot
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==start_button) {
			board= new Board((int)xmodel.getValue(),(int)ymodel.getValue());
		} else if (e.getSource()==load_button) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					FileInputStream fileIn = new FileInputStream(file);
					ObjectInputStream objectIn = new ObjectInputStream(fileIn);
					board  = (Board)objectIn.readObject();
					objectIn.close();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(this, "File is not valid");
					System.exit(0);
				}
			}
		}
		ready=true;
		this.dispose();
	}
}
