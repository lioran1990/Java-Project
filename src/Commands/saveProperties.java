package Commands;

import View.View;
import model.Model;
import presenter.Presenter;
import presenter.PropertiesHandler;

public class saveProperties implements Command{
	/** The m. */
	private Presenter p;
	
	/**
	 * Instantiates a new save maze cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public saveProperties(Presenter p) {
		this.p = p;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		try {
			PropertiesHandler.write(p.properties, ".\\xml\\properties.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
