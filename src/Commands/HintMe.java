package Commands;

import View.View;
import model.Model;

public class HintMe implements Command {

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
	public HintMe(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 6){
			m.HintMe(args[1],args[2],args[3],args[4],args[5]);
		}
		else{
			v.PrintOut("hint [(String) name] [Location]\n");
		}

	}

}
