package Commands;

import java.util.HashMap;
import java.util.Map.Entry;

import View.View;
import model.Model;

public class getMaze2dData implements Command {

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
	public getMaze2dData(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {	
		//	v.setMaze2dData(m.getMaze2dData());

	}
}


