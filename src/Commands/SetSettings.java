package Commands;

import View.View;
import model.Model;

public class SetSettings implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new display solution CMD.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public SetSettings(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will change the XML file with the desired properties.
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 4){
			
			m.setSettings(args);
		}
		else{
			v.PrintOut("set_settings [(String)name]\n");
		}		
	}
}
