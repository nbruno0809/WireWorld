package ww;

/**
 * Timer osztaly ami adott idokozonkent lepteti a Boardot
 *
 */
public class Timer extends Thread {
	/**
	 * Leptetendo Board
	 */
	Board board;
	/**
	 * Ennyi idot var leptetesek kozt
	 */
	int time;
	/**
	 * true ha meg van allitva,false ha nincs
	 */
	boolean paused;
	
	/**
	 * Constructor
	 * @param b Board
	 */
	public Timer(Board b) {
		board=b;
		time=700;
		paused=false;
	}
	
	 /**
	 * Szal inditasa
	 * ha nincs megallitva, time idokozonkent leptet a boardot
	 */
	public void run() {
		while (true) {
			if (!paused) {
				board.step();
			}
			try { sleep(time); }
			catch (InterruptedException e) {}
		}
	}
	 
	/** paused setter
	 * @param b beallitando ertek
	 */
	public void setPaused(boolean b) {paused=b;}
	
	/**
	 * Megmutatja meg van-e allitva a Timer
	 * @return true ha all, false, ha nem
	 */
	public boolean isPaused() {return paused;}
	
	/**time setter
	 * @param i beallitando ertek
 	 */
	public void setTime(int i) {time=i;}

}
