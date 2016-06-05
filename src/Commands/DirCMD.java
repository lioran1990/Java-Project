package Commands;

import View.View;


/**<h1>DirCMD</h1>
 * The Directory command class.
 * This class implements Commands interface and override doCommand method.
 * The class support directory path of saved files.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 *
 */
public class DirCMD implements Command {

	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new dir cmd.
	 *
	 * @param v the v
	 */
	public DirCMD(View v) {
		this.v = v;
	}
	
	
	/**
	 *the dir command shows file path on disk
	 **/
	@Override
	public void doCommand(String [] args) {
		ClassLoader loader = DirCMD.class.getClassLoader();
		v.PrintOut(loader.getResource("").toString());

	}

}
