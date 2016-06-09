package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
			message = "Maze: " + name +" Generated succesfully!";
			notifyObservers("display_msg");
		}
		else{
			message = "This name already exists";
			setChanged();
			notifyObservers("display_msg");
		}
	}
	
	public String getPendingMessage (){
		return message;
	}
	
	public void getMaze3d(String name){
		if (mazes.get(name) != null){
			message = mazes.get(name).toString() + "\nStart Position: " + mazes.get(name).getStartPosition() + "\nGoal Position: "+ mazes.get(name).getGoalPosition();
			setChanged();
			notifyObservers("display_msg");
		}
		else{
			message = "Couldn't find maze by name!"; 
			setChanged();
			notifyObservers("display_msg");
		}		
	}
	
	public int [][] getCrossSection (String axis, int index , String name){
		if (mazes.get(name) != null){
			Maze3d maze = mazes.get(name);
			switch (axis) {
				case "x" :
				case "X" : 	
					return maze.getCrossSectionByX(index);
				case "y":
				case "Y":
					return maze.getCrossSectionByY(index);
				case "z":
				case "Z":
					return maze.getCrossSectionByZ(index);
				default :
					return null;
			}	
		}
		else{
			return null;
		}		
	}
	
	public String saveToFile (String name, String fileName){
		if (mazes.get(name) != null){
			try{
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				try{
					out.write(mazes.get(name).toByteArray());
					out.flush();
					out.close();
					return "Maze compressed and saved to " + fileName;
				}
				catch(IOException e){
					return "Loading Failed : Couldn't read the file 0x01";
				}
			}
			catch(FileNotFoundException e){
				return "Loading Failed : File Not Found 0x01";
			}
		}
		else{
			return "Couldn't find maze by name!";
		}
	}
	
	public String loadFromFile (String fileName, String name){
			byte [] b = new byte [3];
			InputStream in = null;
			Maze3d maze = null;
			
			try {
				in = new FileInputStream(fileName);
			} 
			catch (FileNotFoundException e2) {
				return "Loading Failed : File Not Found 0x01";
			}
			try {
				in.read(b, 0, 3);
				int size = (b[0] * b[1] * b[2]) + 9;
				b = null;
				b = new byte [size];
				in.close();
			} 
			catch (IOException e2) {
				return "Loading Failed : Couldn't read the file 0x01";
			}
			try {
				in = new MyCompressorInputStream(new FileInputStream(fileName));
			} catch (FileNotFoundException e1) {
				return "Loading Failed : File Not Found 0x02";
			}
			try {
				in.read(b);
				maze = new Maze3d(b);
				mazes.put(name, maze);
				in.close();
				return "Maze Loaded Succefully!";
			} 
			catch (IOException e) {
				return "Loading Failed : Couldn't read the file 0x02";
			}
	}
	
	public String Maze_Mem_Size (String name){
		if (mazes.get(name) != null){
			Maze3d maze = mazes.get(name);
			int size;
			
			final int POSITION = 12;
			final int DIMENTION = 4;
			final int MAZE_SIZE = maze.getCols() * maze.getFlos() * maze.getRows();
			
			size = (8 * POSITION)  + (5 * DIMENTION) + MAZE_SIZE; 
			
			if (maze.getDirs() == null){
				return Integer.toString(size) + " Bytes";
			}
			else{
				for (Directions d : maze.getDirs()){
					size += d.name().length();
				}
			}
			return Integer.toString(size) + "Bytes";
		}
		else{
			return "Couldn't find maze!";
		}
		
	}
	
	public String Maze_File_Size (String fileName){
		java.io.File file = new java.io.File(fileName);
		if (file.length() == 0){
			return "File Not Found!";
		}
		return Long.toString(file.length()) + " Bytes";
		
	}
	
	public String Solve (String name , String algo){
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
			return "Solution created!";
		}
		else{
			return "Couldn't find maze!";
		}

	}
	
	public String Display_Sol (String name){
		if (mazes.get(name) != null){
			return solutions.get(name).getStates().toString();
		}
		else{
			return "Couldn't find maze!";
		}
	}
	
	public String Exit (){
		
		return null;
		
	}
	
	
	
}
