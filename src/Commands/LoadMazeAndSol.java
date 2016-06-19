package Commands;

import View.View;
import model.Model;
/** <h1>LoadMazeAndSol</h1>
 * The LoadMazeAndSol class.
 * This class implements Command interface and override doCommand method.
 * This class handle the loading mission of the generated maze and solution.
 * This class is used by GUI only!
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 */
public class LoadMazeAndSol implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new LoadMazeAndSol command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public LoadMazeAndSol(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command loads the maze object with his appropriate solution.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 2){
			m.loadFromFile_ser(args[1]);
		}
		else{
			v.PrintOut("load [(String) name] [(String)fileName]\n");
		}

	}

}
