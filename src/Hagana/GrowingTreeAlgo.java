package Hagana;

import java.util.ArrayList;

import algorithms.mazeGenerator.Directions;
import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.Maze3dGeneratorBase;
import algorithms.mazeGenerator.Position;
import algorithms.mazeGenerator.Utils;

//NOTE:The program does not running from some reason, i don't have the time for debugging.
// I've tried to implement the algo (Growing tree) as much as i could
// I've change the MyModel to initialize only new object of GrowingTree(new LastCellChoose) andGrowingTree(new RandomCellChoose) 
// The GUI does not running.
// Ive tried to do some code reuse - instead of copy whole method and classes around the project
// Only the necessary methods has been copied from myAlgorithm jar
// Ive tried to implements Strategy Pattern,with the Interface CellChoose
// the hierarchy of the the CellChoose classes let the user choose the implementation of the ALGORITHM in runtime! by Injunction of an object and not a INT
// Lior Ran, 28.7.16
public class GrowingTreeAlgo extends Maze3dGeneratorBase {
	//Data Member
	CellChoose cellChoose;
	
	//Constructor
	public GrowingTreeAlgo(CellChoose cell) {
		this.cellChoose= cell;
	}
	@Override
	public Maze3d generate(int flo, int row, int col) {
		maze3d= new Maze3d (flo,row,col);
		maze3d.setWallsOnAll();
		maze3d.setStartPos(this.chooseRandomPosition());
		maze3d.setFree(maze3d.getStartPosition());
		
		//Running the algorithm
		GTA (maze3d.getStartPosition());
		
		return maze3d;
	}
	
	
	private void GTA (Position pos)
	{
		//1. Let C be a list of cells, initially empty
		ArrayList<Position> cells_list = new ArrayList<Position>();
		
		cells_list.add(pos);
		//2. Add one cell to C, at random; +set START position, and make it FREE
		Position startPos= chooseRandomPosition();
		cells_list.add(startPos);
		maze3d.setFree(startPos);
		maze3d.setStartPos(startPos);
		
		//3. Choose a cell c from C
		Position currPos = null;
		while (!(cells_list.isEmpty()))
			
			currPos= cellChoose.choose(cells_list);
				ArrayList<Directions> dirs = getPossibleDirections(currPos);
				
				//check if c has unvisited neighbors (by pseudo code)
				if (dirs.size() <= 0)
				{
					cells_list.remove(currPos);
					
					//defining the removed cell as the goal position
					if (cells_list.isEmpty())
					{
						maze3d.setGoalPos(currPos);
					}
						
				}
				else
				{
					//Step 4 in the pseudo code
					for (int i = 0; i < dirs.size(); i++) {
						// Choose random Directions
						int idx = Utils.rand.nextInt(dirs.size());
						Directions dir = dirs.get(idx);
						dirs.remove(dir);
						int[][][] m = maze3d.getMaze3d();
						switch (dir) {
						case LEFT :
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()-1][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()-2][pos.getCol()]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo(), pos.getRow()-2,pos.getCol()));
							break;
						case RIGHT:
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()+1][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()+2][pos.getCol()]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo(), pos.getRow()+2,pos.getCol()));
							break;
						case BACKWARD:
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()][pos.getCol()-1]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()][pos.getCol()-2]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo(), pos.getRow(),pos.getCol()-2));
							break;
						case FORWARD:
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()][pos.getCol()+1]=Maze3d.FREE;
							m[pos.getFlo()][pos.getRow()][pos.getCol()+2]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo(), pos.getRow(),pos.getCol()+2));
							break;
						case DOWN:
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()-1][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()-2][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo()-2, pos.getRow(),pos.getCol()-2));
							break;
						case UP:
							m[pos.getFlo()][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()+1][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							m[pos.getFlo()+2][pos.getRow()][pos.getCol()]=Maze3d.FREE;
							maxGoal(pos);
							cells_list.add(new Position(pos.getFlo()+2, pos.getRow(),pos.getCol()));
							break;
						}
					}
					
					
				}
	
		
	}
	
	
	public ArrayList<Directions> getPossibleDirections (Position p){
		//ROWS - +2 Forward  -2 BackWard
		//COLS - +2 Right    -2 Left
		//FLOS - +2 Up       -2 Down
		
		ArrayList<Directions> dirs = new ArrayList<Directions>();
		
		if ((p.getRow() + 2 < maze3d.getRows()) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.RIGHT), Position.RIGHT)) == Maze3d.WALL))
			dirs.add(Directions.RIGHT);
		if ((p.getRow() - 2 >= 0) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.LEFT), Position.LEFT)) == Maze3d.WALL))
			dirs.add(Directions.LEFT);
		
		if ((p.getCol() + 2 < maze3d.getCols()) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.FORWARD), Position.FORWARD)) == Maze3d.WALL))
			dirs.add(Directions.FORWARD);
		if ((p.getCol() - 2 >= 0) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.BACKWARD), Position.BACKWARD)) == Maze3d.WALL))
			dirs.add(Directions.BACKWARD);
		
		if ((p.getFlo() + 2 < maze3d.getFlos()) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.UP), Position.UP)) == Maze3d.WALL))
			dirs.add(Directions.UP);
		if ((p.getFlo() - 2 >= 0) && (maze3d.getValue(Position.mergePos(Position.mergePos(p, Position.DOWN), Position.DOWN)) == Maze3d.WALL))
			dirs.add(Directions.DOWN);
		
		return dirs;
		
	}
	
	//set the goal position to be random and far from the start
		private void maxGoal(Position pos){
			if((pos.getFlo()>maze3d.getStartPosition().getFlo()+1) || (pos.getFlo()<maze3d.getStartPosition().getFlo()-1)){
				if((pos.getRow()>(maze3d.getStartPosition().getRow())+1) || (pos.getRow()<(maze3d.getStartPosition().getRow())-1)){
					if((pos.getCol()>(maze3d.getStartPosition().getCol())+1) || (pos.getCol()<(maze3d.getStartPosition().getCol())-1)){
						maze3d.setGoalPos(pos);
					}
				}
			}
}
}
