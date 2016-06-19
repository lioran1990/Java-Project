package Commands;

import View.View;
import model.Model;


/** <h1>DisplayCrossSecCMD</h1>
 * The Display cross section command class.
 * This class implements Commands interface and override doCommand method.
 * This class sends Output Stream of  the MAZE3D by the chosen coordinate (X,Y,Z).
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class DisplayCrossSecCMD implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new display cross section command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public DisplayCrossSecCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	/**
	 * This command will print crossed 2d maze of the original 3d maze according the parametes which select by the user 
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 4){
				m.getCrossSection(args[1],Integer.parseInt(args[2]),args[3]);
		}
		else{
			v.PrintOut("Syntax should be: display_cross_section [(String) X/Y/Z] [(int) Index] [(String)name]\n");
		}		

	}

}
