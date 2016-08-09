package Hagana;

import java.util.ArrayList;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.Position;
import algorithms.mazeGenerator.Utils;

public class CellChooseABSTRCT implements CellChoose {
	Maze3d maze3d;
	ArrayList<Position> ArrayPosition;
	
	@Override
	public Position choose(ArrayList<Position> cells_list) {
		
		return null;
	}
	
	
	public Position chooseRandomPosition (){
		int row = Utils.rand.nextInt(maze3d.getRows());
		int col = Utils.rand.nextInt(maze3d.getCols());
		int flo = Utils.rand.nextInt(maze3d.getFlos());
		
		
		while (row % 2 != 0){
			row = Utils.rand.nextInt(maze3d.getRows());
		}
		
		while (col % 2 != 0){
			col = Utils.rand.nextInt(maze3d.getCols());
		}
		
		while (flo % 2 != 0){
			flo = Utils.rand.nextInt(maze3d.getFlos());
		}
		
		return new Position (flo,row,col);
	}
	
}
