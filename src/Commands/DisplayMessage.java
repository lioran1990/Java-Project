package Commands;

import View.View;
import model.Model;


/** <h1>DisplayCMD</h1>
 * The Display commands class.
 * This class implements Commands interface and override doCommand method.
 * The class display command will print the MAZE3D.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 *
 */
public class DisplayMessage implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new display command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public DisplayMessage(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 *display command shows print MAZE3d 
	 **/
	@Override
	public void doCommand(String [] args) {
		v.PrintOut(m.getPendingMessage());		
	}

}
