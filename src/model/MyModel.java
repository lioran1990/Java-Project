package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import MazeAdapters.Maze3dAdapter;
import MazeSettings.*;
import MazeSettings.ReadXmlFile;
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
					break;
				case "y":
				case "Y":
					maze2d = maze.getCrossSectionByY(index);
					break;
				case "z":
				case "Z":
					maze2d = maze.getCrossSectionByZ(index);
					break;
				default :
					message="Wrong Coordinate, only X/Y/Z accepted\n";
					break;
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
	
	public void Solve (String name , String algo){
		if (mazes.get(name) != null){
			Maze3dAdapter mazeAdapter = new Maze3dAdapter(mazes.get(name));	
				switch (algo){
				case "dfs":
				case "DFS":
					solutions.put(name, new DFS().search(mazeAdapter));
					break;
				case "bfs":
				case "BFS":
					solutions.put(name, new BestFS().search(mazeAdapter));
					break;			
				case "breadthfs":
				case "BREADTHFS":
					solutions.put(name, new BreadthFS().search(mazeAdapter));
					break;
				}
				message="Solution created!\n";
		}
		else{
			message= "Couldn't find maze!\n";
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
	
		public void getSettings()
		{
			String [] settings = new String [3];
			ReadXmlFile readxml = new ReadXmlFile();
			for (int i = 0; i < settings.length; i++) {
				settings [i]= readxml.read()[i];
				System.out.println(settings [i]);
			}
		}
		
		//This function modifying the XML file with the parameters recived from the user
		public void setSettings(String [] param)
		{
			ModifyXmlFile modifyxml= new ModifyXmlFile();
			modifyxml.ModifyXmlFile(param);
			
		}
	
	
///////////*****************************************************************************/////////////////////
	
	public void saveToFile_ser (String name, String fileName){
		ObjectOutputStream oos = null;
		if (mazes.get(name) != null){
			
			try {
				oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("./saves/"+fileName+".maz")));
				try {
					oos.writeObject(name);
					oos.writeObject(mazes.get(name));
					message = "Maze saved! \nBut no solution saved. \n";
					if (solutions.get(name) != null){
						try {
							oos.writeObject(solutions.get(name));
							message = "Maze and Solution saved!";
						} catch (IOException e) {
							message = "Couldn't save solution to file\n" + e.getMessage() + "\n";
						}	
					}
				} catch (IOException e1) {
					message = "Couldn't save maze to file\n" + e1.getMessage() + "\n";
				}
			} catch (FileNotFoundException e2) {
				message = "Couldn't create save file\n" + e2.getMessage() + "\n";
			} catch (IOException e2) {
				message = "Couldn't save to file\n" + e2.getMessage() + "\n";
			}
			
			try {
				oos.close();
			} catch (IOException e1) {
				message = "Couldn't close the file\n" + e1.getMessage() + "\n";
			}		
			setChanged();
			notifyObservers("display_msg");
		}
	}
	
	public void loadFromFile_ser (String fileName){
		ObjectInputStream ois = null;
		String tmpName = null;
		Maze3d tmpMaze3d = null;
		Solution tmpSolution = null;
		
		
		try {
			ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream("./saves/"+fileName+".maz")));
			try {
				tmpName = (String) ois.readObject();
				try {
					tmpMaze3d = (Maze3d) ois.readObject();
					mazes.put(tmpName, new Maze3d(tmpMaze3d));
					message = "Maze " + tmpName + " Loaded successfuly\n";
					try {
						tmpSolution = (Solution) ois.readObject();
						solutions.put(tmpName, new Solution(tmpSolution));
						message = "Maze and Solution " + tmpName + " Loaded successfuly\n";
					} catch (ClassNotFoundException e) {
						message = e.getMessage() + "\n";
					} catch (IOException e) {
						message = "Maze "+tmpName+" loaded \nBut Couldn't read Solution "+e.getMessage() + "\n";
					}
				} catch (ClassNotFoundException e) {
					message = e.getMessage() + "\n";
				} catch (IOException e) {
					message = "Couldn't read Maze from file " +e.getMessage() + "\n";
				}
			} catch (ClassNotFoundException e) {
				message = e.getMessage() + "\n";
			}		
		} catch (FileNotFoundException e3) {
			message = "Couldn't find file specified \n" +e3.getMessage() + "\n";
		} catch (IOException e3) {
			message = "Couldn't read from file "+e3.getMessage() + "\n";
		}	
		
		try {
			ois.close();
		} catch (IOException e) {
			message = "Couldn't close the file " + e.getMessage() + "\n";
		}
		
		setChanged();
		notifyObservers("display_msg");
	}
	
	public void getMazeFiles (){
		File folder = new File("./saves");
		File[] listOfFiles = folder.listFiles();
		StringBuilder sb = new StringBuilder();
		
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  sb.append(listOfFiles[i].getName()+"\n");
		      } 
		    }
	    message = sb.toString();
	    setChanged();
		notifyObservers("display_msg"); 
	}

	
	
/////////*****************************************************************************/////////////////////

	
	
	
	
	
	
	/*	RELEVANT FO ASSIGNMENT 3 ONLY!
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public void SaveSolutionsToFile (String fileName) throws IOException{	
		OutputStream out = new GZIPOutputStream (new FileOutputStream("./saves/"+fileName+"_sol.gzip"));
		ArrayList<State> arr;
		
		for (Entry<String, Solution> e : solutions.entrySet()){
			out.write(solutions.size());
			arr = solutions.get(e.getKey()).getStates();
			out.write(e.getKey().length());
			out.write(e.getKey().getBytes());
			out.write(arr.size() * 3);
			for (State state : arr) {
				out.write(state.getCurrentState().charAt(1));
				out.flush();
				out.write(state.getCurrentState().charAt(3));
				out.flush();
				out.write(state.getCurrentState().charAt(5));
				out.flush();
			}
			out.flush();
		}
		out.close();
		message = "solution for "+fileName+ "saved to file\n";
		setChanged();
		notifyObservers("display_msg");
	}
	
	
	public void LoadSolutionsFromFile () throws FileNotFoundException, IOException{
		InputStream in = new GZIPInputStream(new FileInputStream("Solutions.gzip"));
		int sizeOfSolutions = 0;
		byte [] b = new byte [4];
		byte [] name;
		byte [] bytestate;
		
		sizeOfSolutions = in.read();
		for (int i = 0; i < sizeOfSolutions; i++) {
			// read solution name like omri_dfs
			name = new byte [b[0]];
			in.read(name, 0, b[0]);
			String str = new String(name);
			// read the whole solution
			in.read(b,0,1);
			bytestate = new byte [b[0]];
			in.read(bytestate, 0, b[0]);
			str = new String (bytestate);
		}

		
		message = "solutions loaded \n";
		setChanged();
		notifyObservers("display_msg");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	
	public void saveToFile (String name, String fileName){
		if (mazes.get(name) != null){
			try{
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream("./saves/"+fileName+"_maze.maz"));
				try{
					out.write(mazes.get(name).toByteArray());
					this.SaveSolutionsToFile(fileName);
					out.flush();
					out.close();
					message= "Maze compressed and saved to " + fileName + "\n";
				}
				catch(IOException e){
					message= "Loading Failed : Couldn't read the file 0x01\n"+e.getMessage()+"\n";
				}
			}
			catch(FileNotFoundException e){
				message= "Loading Failed : File Not Found 0x01\n"+e.getMessage()+"\n";
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
	//////////////////////////////////////////////////////////////////////////////
	 */
	
}
