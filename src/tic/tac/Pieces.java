package tic.tac;

public class Pieces extends Player{
	
	private int row;
	private int col;
	
	public Pieces(String name, int row, int col) {
		
		super(name);
		this.row=row;
		this.col=col;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "Pieces [row=" + row + ", col=" + col + ", name=" + name + ", getRow()=" + getRow() + ", getCol()="
				+ getCol() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	 
}
