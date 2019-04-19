package components.elements.board;

public class Board {
	private int rows;
	private int columns;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Board size: " + rows + " x " + columns + ".";
	}
}
