package Hagana;

import java.util.ArrayList;


import algorithms.mazeGenerator.Position;

public class LastCellChoose extends CellChooseABSTRCT {
	
	
	//Choosing last cell from the arraylist
	public Position choose(ArrayList<Position> cells_list) {
		Position lastCell= cells_list.get(0);
		return lastCell;
	}

}
