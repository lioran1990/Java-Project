package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import MazeAdapters.Maze3dAdapter;
import algorithms.io.MyCompressorInputStream;
import algorithms.io.MyCompressorOutputStream;
import algorithms.mazeGenerator.Directions;
import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.MyMaze3dGenerator;
import algorithms.search.BestFS;
import algorithms.search.BreadthFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import domain.State;
/**<h1>MyModel</h1>
* The MyModel class.
* MyModel is responsable to all of the data calculating such as Solving a maze, save\load etc.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class MyModel extends Observable implements Model {
	
	private HashMap<String, Maze3d> mazes = new HashMap<String,Maze3d>();
	private HashMap<String , Solution> solutions = new HashMap<String , Solution>();
	Maze3d maze;
	String message;
	
	public MyModel() {
		
	}
	
	public void generateMaze(String name , int flos, int rows , int cols){
		MyMaze3dGenerator mg = new MyMaze3dGenerator();
		maze = mazes.get(name);
		if (maze == null){
			maze = mg.generate(flos, rows, cols);		
			mazes.put(name, maze);
			setChanged();
			message = "Maze: " + name +" Generated succesfully!\n";
			notifyObservers("display_msg");
		}
		else{
			message = "This name already exists!\n";
			setChanged();
			notifyObservers("display_msg");
		}
	}
	
	public String getPendingMessage (){
		return message;
	}
	
	public void getMaze3d(String name){
		if (mazes.get(name) != null){
			message = mazes.get(name).toString() + "\nStart Position: " + mazes.get(name).getStartPosition() + "\nGoal Position: "+ mazes.get(name).getGoalPosition()+"\n";
			setChanged();
			notifyObservers("display_msg");
		}
		else{
			message = "Couldn't find maze by name!\n"; 
			setChanged();
			notifyObservers("display_msg");
		}		
	}
	
	public void getCrossSection (String axis, int index , String name){
		int [][] maze2d = null;
		StringBuilder sb = new StringBuilder();
		if (mazes.get(name) != null){
			Maze3d maze = mazes.get(name);
			
			switch (axis) {
				case "x" :
				case "X" : 	
					maze2d = maze.getCrossSectionByX(index);
				case "y":
				case "Y":
					maze2d = maze.getCrossSectionByY(index);
				case "z":
				case "Z":
					maze2d = maze.getCrossSectionByZ(index);
				default :
					message="Wrong Coordinate, only X/Y/Z accepted\n";
			}	
			
		}
		else{
			message = "Couldn't find maze by name!\n"; 
		}
		
		for (int i = 0; i < maze2d.length; i++) {
			for (int j = 0; j < maze2d[0].length; j++) {
				sb.append((((Integer)maze2d[i][j]).toString() + " "));
			}
			sb.append("\n");
		}
		message = sb.toString();
		setChanged();
		notifyObservers("display_msg");
	}
	
	
	public void saveToFile (String name, String fileName){
		if (mazes.get(name) != null){
			try{
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				try{
					out.write(mazes.get(name).toByteArray());
					out.flush();
					out.close();
					message= "Maze compressed and saved to " + fileName + "\n";
				}
				catch(IOException e){
					message= "Loading Failed : Couldn't read the file 0x01\n";
				}
			}
			catch(FileNotFoundException e){
				message= "Loading Failed : File Not Found 0x01\n";
			}
		}
		else{
			message= "Couldn't find maze by name!\n";
		}
		setChanged();
		notifyObservers("display_msg");
	}
	
	public void loadFromFile (String fileName, String name){
			byte [] b = new byte [3];
			InputStream in = null;
			Maze3d maze = null;
			
			try {
				in = new FileInputStream(fileName);
			} 
			catch (FileNotFoundException e2) {
				message= "Loading Failed : File Not Found 0x01\n";
			}
			try {
				in.read(b, 0, 3);
				int size = (b[0] * b[1] * b[2]) + 9;
				b = null;
				b = new byte [size];
				in.close();
			} 
			catch (IOException e2) {
				message=  "Loading Failed : Couldn't read the file 0x01\n";
			}
			try {
				in = new MyCompressorInputStream(new FileInputStream(fileName));
			} catch (FileNotFoundException e1) {
				message= "Loading Failed : File Not Found 0x02\n";
			}
			try {
				in.read(b);
				maze = new Maze3d(b);
				mazes.put(name, maze);
				in.close();
				message=  "Maze Loaded Succefully!\n";
			} 
			catch (IOException e) {
				message=  "Loading Failed : Couldn't read the file 0x02\n";
			}
			setChanged();
			notifyObservers("display_msg");
	}
	
	public void Maze_Mem_Size (String name){
		if (mazes.get(name) != null){
			Maze3d maze = mazes.get(name);
			int size;
			
			final int POSITION = 12;
			final int DIMENTION = 4;
			final int MAZE_SIZE = maze.getCols() * maze.getFlos() * maze.getRows();
			
			size = (8 * POSITION)  + (5 * DIMENTION) + MAZE_SIZE; 
			
			if (maze.getDirs() == null){
				message=Integer.toString(size) + " Bytes";
			}
			else{
				for (Directions d : maze.getDirs()){
					size += d.name().length();
				}
				message= Integer.toString(size) + " Bytes";
			}
		}
		else{
			message= "Couldn't find maze!\n";
		}
		setChanged();
		notifyObservers("display_msg");
	}
	
	public void Maze_File_Size (String fileName){
		java.io.File file = new java.io.File(fileName);
		if (file.length() == 0){
			message= "File Not Found!\n";
		}
		else{
			message=Long.toString(file.length()) + " Bytes";
		}
		setChanged();
		notifyObservers("display_msg");
	}
	
	public void Solve (String name , String algo){
		if (mazes.get(name) != null){
			Maze3dAdapter mazeAdapter = new Maze3dAdapter(mazes.get(name));		
			switch (algo){
				case "dfs":
				case "DFS":
					solutions.put(name, new DFS().search(mazeAdapter));
				
				case "bfs":
				case "BFS":
					solutions.put(name, new BestFS().search(mazeAdapter));
										
				case "breadthfs":
				case "BREADTHFS":
					solutions.put(name, new BreadthFS().search(mazeAdapter));
			}
			message="Solution created!\n";
		}
		else{
			message= "Couldn't find maze!\n";
		}
		setChanged();
		notifyObservers("display_msg");
	}
	
	public void Display_Sol (String name){
		if (mazes.get(name) != null){
			if (solutions.get(name) != null){
				message= solutions.get(name).getStates().toString();
			}
			else{
				message= "There is no solution yet. Please run Solve [(String) name] [(dfs/bfs/breadthfs) algorithm] command first! \n";
			}
		}
		else{
			message= "Couldn't find maze!\n";
		}
		setChanged();
		notifyObservers("display_msg");
	}
	
	public String Exit (){
		
		return null;
		
	}
	
	
	
}
