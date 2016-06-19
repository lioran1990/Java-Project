package Commands;

import View.View;
import model.Model;

/** <h1>LoadMazeCMD</h1>
 * The Load Maze command class.
 * This class implements Commands interface and override doCommand method.
 * This class loads a MAZE3D from file to system memory
 * This class is used by CLI only.
 * The LOAD process passes thorough a decompressing phase before it upload to system memory.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class LoadMazeCMD implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new load maze command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public LoadMazeCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**
	 * This command loads MAZE3d from local disk
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 3){
		//	m.loadFromFile(args[1], args[2]);
		}
		else{
			v.PrintOut("Load_maze [(String)fileName] [(String) name] \n");
		}

	}

}
