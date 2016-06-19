package GUI;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.Position;

/** <h1>MazeDisplayer</h1>
 * The MazeDisplayer class.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public abstract class MazeDisplayer extends Canvas{

	Maze3d mazeData = null;
	public int charRow;
	public int charCol;
	public int charFlo;
	public Position currentPlayerPos;
	
	MazeDisplayer(Composite parent , int style) {
		super(parent,style);
		
	}
	
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract void moveFloUp();
	public abstract void moveFloDown();
	

}
