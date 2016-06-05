package Commands;

import View.View;
import model.Model;
/** <h1>MazeSizeCMD</h1>
 * The Maze Size command class.
 * This class implements Commands interface and override doCommand method.
 * This class shows the MAZE3d object memory size on machine memory (RAM).
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class MazeSizeCMD implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new maze size cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public MazeSizeCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command show the MAZE3D object memory size on machine memory.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 2){
			v.PrintOut(m.Maze_Mem_Size(args[1]));
		}
		else{
			v.PrintOut("maze_size [(String) name]");
		}

	}

}
