package Commands;


/**
 * <h1>Command</h1>
 * The Interface command.
 * Each class which implements this interface must override doCommand method.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 * 
 * 
 */
public interface Command {

	/**
	 * Do command.
	 *
	 * @param args the args
	 */
	public void doCommand(String [] args);

}
