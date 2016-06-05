package Commands;

import View.View;
import model.Model;

/** <h1>SaveMazeCMD</h1>
 * The Save Maze command class.
* This class implements Commands interface and override doCommand method.
* This class save the MAZE3D object to the local hard drive. File extension: <.maze>.
* The MAZE3D passes thorough a compersation phase to save space on disk.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class SaveMazeCMD implements Command {

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
	public SaveMazeCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 3){
			v.PrintOut(m.saveToFile(args[1], args[2]));
		}
		else{
			v.PrintOut("save_maze [(String) name] [(String)fileName.maz]");
		}

	}

}
