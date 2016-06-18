package View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import MazeAdapters.Maze3dStateAdapter;
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
public class MyView extends Observable implements View, Observer{


	CLI cli;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public MyView(BufferedReader reader ,PrintWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
		cli = new CLI(reader, writer);
		cli.addObserver(this);
	}
	
	@Override
	public void start() throws Exception {
		
		Thread cliThread = new Thread (new Runnable() {		
			@Override
			public void run() {
				try {
					cli.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		
		cliThread.join();		
		cliThread.start();
	}
	
	public void PrintOut (String str){
		writer.write(str);
		writer.flush();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == cli){
			this.setChanged();
			this.notifyObservers(arg1);	
		}
		
	}

	@Override
	public void setMaze2dData(int[][] maze2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaze3dData(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSolution(Solution arg) {
		// TODO Auto-generated method stub
		
	}


	public void HintMe(Maze3dStateAdapter s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProperties(Properties p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Properties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}
