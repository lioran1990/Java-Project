package Commands;

import View.View;
import model.Model;

public class LoadMazeAndSol implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new save maze cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public LoadMazeAndSol(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 3){
			m.HintMe(args[1]);
		}
		else{
			v.PrintOut("hint [(String) name] [Location]\n");
		}

	}

}
