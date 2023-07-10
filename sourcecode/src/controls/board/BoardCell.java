package controls.board;

import java.util.*;

public class BoardCell {
	private ArrayList<Stone> stonesInCell;
	
	public BoardCell(BigGem quan) {
		stonesInCell = new ArrayList<Stone>();
		this.stonesInCell.add(quan);
	}

	public BoardCell(SmallGem dan) {
		stonesInCell = new ArrayList<Stone>();
		for(int i=0; i<5; i++) {
			this.stonesInCell.add(dan);
		}
	}

	public ArrayList<Stone> getStonesInCell() {
		return this.stonesInCell;
	}
	
	public int getNumberOfStones() {
		return this.stonesInCell.size();
	}
	
	public int getPoint() {
		int point = 0;
		for(Stone s: this.stonesInCell) {
			point += s.getValue();
		}
		return point;
	}
}