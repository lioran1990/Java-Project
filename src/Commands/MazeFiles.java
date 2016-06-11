package Commands;

import View.View;
import model.Model;

public class MazeFiles implements Command {
	
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
	public MazeFiles(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 1){
				m.getMazeFiles();
			}
		else{
			v.PrintOut("show_files\n");
		}
	}

}
