package GUI;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import MazeAdapters.Maze3dStateAdapter;
import View.View;
import algorithms.mazeGenerator.Maze3d;
import algorithms.search.Solution;
import presenter.Properties;


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
	
	public Properties getProperties (){
		return gb.getProperties();
	}
	
	public void setProperties(Properties p){
		gb.setProperties(p);
	}
	
	
	public void HintMe(Maze3dStateAdapter s){
		gb.showHint(s.getCurrPlayerPos());
	}
	
	@Override
	public void start() throws Exception {
		gb.run();
	}
	
	public void PrintOut (String str){
		gb.opendialog (str);
		writer.write(str);
		writer.flush();
	}
	
	public void setSolution(Solution sol){
		gb.setSolution(sol);
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
