package Commands;

import View.View;
import model.Model;
import presenter.PropertiesHandler;

public class SetProperties implements Command {
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	

	public SetProperties(View v) {
		this.v = v;
	}
	@Override
	public void doCommand(String[] args) {
		try {
			PropertiesHandler.write(v.getProperties(), ".\\xml\\properties.xml");
		} catch (Exception e) {
			System.out.println("Could not save default properties file, please check manually");;
		}
	}

}
