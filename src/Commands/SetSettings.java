package Commands;

import View.View;
import model.Model;
/** <h1>SetSettings</h1>
 * The SetSettings class.
 * This class implements Command interface and override doCommand method.
 * This class handle the set settings mission of program. Settings such as Creation Algorithm, Solving Algorithm and User interface (GUI or CLI).
 * This command is used by both GUI CLI!
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 */
public class SetSettings implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new SetSettings command object.
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
			v.PrintOut("set_settings [(DFS/BFS/breadthfs) 0/1/2] [(GUI/CLI) 0/1] [(Simple/Advanced) 0/1] \n");
		}		
	}
}
