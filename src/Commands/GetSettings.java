package Commands;

import View.View;
import model.Model;

public class GetSettings implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new display solution cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public GetSettings(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will display the path from start to goal position created by the algorithm.
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 1){
			m.getSettings();
		}
		else{
			v.PrintOut("show_settings [(String)name]\n");
		}		
	}
}
