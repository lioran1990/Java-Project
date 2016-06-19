package Commands;

import View.View;
import model.Model;

/** <h1>DisplaySolutionCMD</h1>
 * The File Size command class.
 * This class implements Commands interface and override doCommand method.
 * This class show the actual file size saved on the local disk.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class DisplaySolutionCMD implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new display solution command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public DisplaySolutionCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will display the path from start to goal position created by the algorithm.
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 2){
			m.Display_Sol(args[1]);
		}
		else{
			v.PrintOut("display_solution [(String)name]\n");
		}		
	}
}
