package Commands;

import View.View;
import model.Model;

/** <h1>HintMe</h1>
 * The HintME class.
 * This class implements Command interface and override doCommand method.
 * This class gives the user a HINT- a clue for the next available step towards the goal position.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 */
public class HintMe implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new HineMe command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public HintMe(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command gives the user a HINT for the next .*/
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
