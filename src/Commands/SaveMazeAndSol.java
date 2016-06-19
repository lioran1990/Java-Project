package Commands;

import View.View;
import model.Model;
/** <h1>SaveMazeAndSol</h1>
 * The SaveMazeAndSol class.
 * This class implements Command interface and override doCommand method.
 * This class handle the saving mission of the generated maze and solution.
 * This command is used by GUI only!
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 */
public class SaveMazeAndSol implements Command{
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new save SaveMazeAndSol command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public SaveMazeAndSol(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the Maze object with his appropriate solutions.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 2){
			m.saveToFile_ser(args[1]);
		}
		else{
			v.PrintOut("save [(String) name] \n");
		}

	}
}
