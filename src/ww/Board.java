package ww;

import java.io.*;
import java.util.ArrayList;

/**
 * A cellak tablazatat reprezentalo osztaly
 *
 */
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * cellakat tartalmazo 2D-s ArrayList
	 */
	private ArrayList<ArrayList<Cell>> table;
	
	/**
	 * Board meretei
	 */
	private int xsize,ysize;
	/**
	 * Boardot megjelenito SimulationTable (ha nincs akkor null)
	 */
	private SimulationTable st;
	
	/**
	* Contructor
	*
	* @param  width Board szelessege (y)
	* @param  height Board magassaga (x)
	*/
	public Board(int width, int height) {
		ysize=width;
		xsize=height;
		table = new ArrayList<ArrayList<Cell>>();
		for (int x=0;x<xsize;++x) {
			table.add(new ArrayList<Cell>());
			for (int y=0;y<ysize;++y) {
				table.get(x).add(new Cell(State.EMPTY));
			}
		}
	}
	/** 
	* xsize getter
	* @return xsize
	*/
	public int getX() {return xsize;}
	/**
	 * ysize getter
	 * @return ysize
	 */
	public int getY() {return ysize;}
	/**
	 * st setter
	 * @param st Boardot megjelenito SimulationTable
	 */
	public void setST(SimulationTable st) {this.st=st;}
	/**
	 * st getter
	 * @return st
	 */
	public SimulationTable getST() {return st;}
		
	/**
	 * Visszaadja az adott koordinatan levo cellat
	 * @param x x koordinata
	 * @param y	y koordinata
	 * @return adott helyen levo Cell
	 */
	public Cell getCellAt(int x, int y) {
		return table.get(x).get(y);
	}
	
	/** 
	 * Megmondja van-e cella az adott koordinatan
	 * @param x x koordinata
	 * @param y y koordinata
	 * @return true ha van, false ha nincs
	 */
	public boolean hasCellAt(int x, int y) {
		return (x>=0 && y>=0 && x<table.size() && y<table.get(0).size());
	}
	
	/** 
	 * Megszámolja az adott koordinátán levo cellanak hany HEAD allapotu szomszedja van
	 * @param x x koordinata
	 * @param y y koordinata
	 * @return HEAD allapotu szomszedok szama
	 */
	public int getNeighboursAt(int x, int y) {
		int sum=0;
		for (int nx=x-1;nx<=x+1;nx++) {
			for (int ny=y-1;ny<=y+1;ny++) {
				if (hasCellAt(nx,ny) && !(ny==y && nx==x)) {
					if (getCellAt(nx,ny).getState().equals(State.HEAD)) {
						sum++;
					}
				}
			}
		}
		return sum;
	}

	/**
	 * Minden cella allapotát megvaltoztatja aszabalyoknak megfeleloen
	 */
	public void step() {
		ArrayList<ArrayList<Cell>> newtable = new ArrayList<ArrayList<Cell>>();
		for (int x=0; x<xsize; x++) {
			newtable.add(new ArrayList<Cell>());
			for (int y=0; y<ysize;y++) {
				newtable.get(x).add(getCellAt(x,y).nextStateCell(this,x,y));
			}
		}
		table=newtable;
		if (st!=null) st.refresh();
	}
	/*
	public void kiir() {
		for (int x=0;x<xsize;++x) {
			for (int y=0;y<ysize;y++)
				System.out.print(getCellAt(x, y)+" ");
			System.out.print('\n');
		}
		System.out.print('\n');
	}
	*/
	/**
	 * Fajlba menti a Boardot
	 * @param f a fajl amibe menteni szeretnenk
	 */
	public void saveToFile(File f) {
		try {
            FileOutputStream fileOut = new FileOutputStream(f);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	/**
	 * Osszes cella erteket EMPTY-re allitja
	 */
	public void clear() {
		for (int x=0;x<xsize;++x) {
			for (int y=0;y<ysize;y++)
				getCellAt(x, y).setState(State.EMPTY);
		}
		if (st!=null) st.refresh();
	}
}
