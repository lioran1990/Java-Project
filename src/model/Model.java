package model;
/**<h1>Model</h1>
 * The Model Interface.
 * Model is responsable to all of the data calculating.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public interface Model {
	public void generateMaze(String name, int flos, int rows, int cols);
	public String Solve(String string, String string2);
	public String saveToFile(String string, String string2);
	public String Maze_Mem_Size(String string);
	public String loadFromFile(String string, String string2);
	public String Maze_File_Size(String string);
	public String Display_Sol(String string);
	public int[][] getCrossSection(String string, int parseInt, String string2);
	public void getMaze3d(String string);
	public String getPendingMessage ();

}
