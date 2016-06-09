package Commands;

import View.View;
import model.Model;

/** <h1>SolveCMD</h1>
 * The Solve Maze command class.
* This class implements Commands interface and override doCommand method.
* This class Solve MAZE3D using the Algorithms provided by User.
* The available algorithms are: BFS (Best First Search), DFS (Depth First Search), BFS (Breadth First Search).
* The Solution contains all the path from Start position to Goal position.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class SolveCMD implements Command {
	
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new solve cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public SolveCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command solving the MAZE3D.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 3){
			m.Solve(args[1] , args[2]);
		}
		else{
			v.PrintOut("Solve [(String) name] [(dfs/bfs/breadthfs) algorithm]\n");
		}

	}
}
