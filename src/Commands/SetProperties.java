package Commands;

import View.View;
import model.Model;

public class SetProperties implements Command {
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	public void setProperties(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	@Override
	public void doCommand(String[] args) {
		
		
		
		
		// TODO Auto-generated method stub

	}

}
