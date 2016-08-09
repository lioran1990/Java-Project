package Hagana;

import java.util.ArrayList;


import algorithms.mazeGenerator.Position;
import algorithms.mazeGenerator.Utils;

public class RandomCellChoose extends CellChooseABSTRCT {

	//Choosing random cell from the arraylist
	@Override
	public Position choose(ArrayList<Position> cells_list) {
		int index = Utils.rand.nextInt(cells_list.size()+1);
		Position  randomCell= cells_list.get(index);
		return randomCell;
	}

}
