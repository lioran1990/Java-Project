package View;

/**<h1>View</h1>
* The View Interface.
* Each class which implements this interface must override start method.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public interface View {

	public void start()throws Exception;

	public void PrintOut(String string);
	public void setMaze2dData (int [][] maze2d);
}
