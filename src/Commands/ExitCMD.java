package Commands;

import View.View;

/** <h1>ExitCMD</h1>
 * The Exit command class.
 * This class implements Commands interface and override doCommand method.
 * This class send EXIT command of to the Command Line Interface.
 * Exit command will provide a safe exit from Open Threads and files.
 * No Brutal shutdown, the Thread which interacts with the user inform user with current state.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class ExitCMD implements Command {

	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new exit command object.
	 *
	 * @param v the v
	 */
	public ExitCMD(View v) {
		this.v = v;
	}
	
	/**
	 * This command will initiate safe EXIT from the program.
	 */
	@Override
	public void doCommand(String [] args) {
		v.PrintOut("Shutdown in progress...\nPlease wait... \n");
	}

}
