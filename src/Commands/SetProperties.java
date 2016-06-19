package Commands;

import View.View;
import model.Model;
import presenter.PropertiesHandler;

/**<h1>SetProperties</h1>
 * The Load Solutions command class.
 * This class implements Commands interface and override doCommand method.
 * This class handling the set maze properties mission - from an Properties object into XML file.
 * This Command is used by both GUI and CLI
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 *
 */
public class SetProperties implements Command {
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new SetProperties commands object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public SetProperties(View v) {
		this.v = v;
	}
	
	/**This command sets the maze3d properties object into XML file on the local hard drive.*/

	@Override
	public void doCommand(String[] args) {
		try {
			PropertiesHandler.write(v.getProperties(), ".\\xml\\properties.xml");
		} catch (Exception e) {
			System.out.println("Could not save default properties file, please check manually");;
		}
	}

}
