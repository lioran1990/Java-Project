package presenter;

import java.util.HashMap;

import Commands.Command;
import View.View;
import model.Model;

public class Presenter {

	private Model m;
	private View v;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	
	public Presenter(Model m, View v) {
		this.m = m;
		this.v = v;
	}
	
}
