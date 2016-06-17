package GUI;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import View.View;
import algorithms.mazeGenerator.Maze3d;


/**<h1>MyView</h1>
* The MyView class.
* This class manges the viewing requests.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class MyGUIView extends Observable implements View, Observer{

	GameBoard gb;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public MyGUIView(BufferedReader reader ,PrintWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
		gb= new GameBoard("my maze game" , 500, 500);
		gb.addObserver(this);
	}
	
	@Override
	public void start() throws Exception {
		gb.run();
	}
	
	public void PrintOut (String str){
		writer.write(str);
		writer.flush();
	}
	
	public void setMaze3dData (Maze3d maze){
		gb.setMaze3dData(maze);
	}
	
	public void setMaze2dData (int [][] maze2d){
		//gb.setMazedata(maze2d);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == gb){
			this.setChanged();
			this.notifyObservers(arg1);	
		}
	}

}
