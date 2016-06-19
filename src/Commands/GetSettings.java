package Commands;

import View.View;
import model.Model;

/** <h1>GetSettinghs</h1>
 * The GET settings class.
 * This class implements Command interface and override doCommand method.
 * This class lists the current program settings
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 */
public class GetSettings implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new GetSettings command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public GetSettings(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will give the program settings such as the Generating Algorithm, Solving Algorithm and current used Interface.
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
