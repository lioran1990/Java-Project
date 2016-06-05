package Commands;

import java.util.HashMap;
import java.util.Map.Entry;

import View.View;

/** <h1>GetCommandsCMD</h1>
 * The GET command class.
 * This class implements Commands interface and override doCommand method.
 * This class lists the available program commands
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class GetCommandsCMD implements Command {

	/** The commands. */
	private HashMap<String, Command> commands;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new gets the commands cmd.
	 *
	 * @param commands the commands
	 * @param v the v
	 */
	public GetCommandsCMD(HashMap<String, Command> commands , View v) {
		this.commands = commands;
		this.v = v;
	}
	/**
	 * This command will show the user the available commands
	 */
	@Override
	public void doCommand(String[] args) {

		for (Entry<String, Command> e : commands.entrySet()){
			v.PrintOut(e.getKey());
			v.PrintOut("\n");
		}

	}

}
