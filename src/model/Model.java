package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import algorithms.mazeGenerator.Maze3d;

/**<h1>Model</h1>
 * The Model Interface.
 * Model is responsable to all of the data calculating.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public interface Model {
	public void generateMaze(String name, int flos, int rows, int cols);
	public void Solve(String string, String string2);
	public void Maze_Mem_Size(String string);
	public void Maze_File_Size(String string);
	public void Display_Sol(String string);
	public void getCrossSection(String string, int parseInt, String string2);
	public void getMaze3d(String string);	
	public String getPendingMessage ();
	public void getSettings();
	public void setSettings(String [] param);
	public void saveToFile_ser (String name, String fileName);
	public void loadFromFile_ser (String fileName);
	public void getMazeFiles ();
	public int [][] getMaze2dData ();
	public Maze3d getMaze3dData (String name);
	
	
	/*
	public void saveToFile(String string, String string2);
	public void loadFromFile(String string, String string2);
	public void SaveSolutionsToFile (String fileName) throws IOException;
	public void LoadSolutionsFromFile () throws FileNotFoundException, IOException;
	*/
	

}
