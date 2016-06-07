package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Commands.Command;
import View.View;
import model.Model;

public class Presenter extends Observable implements Observer{

	private Model m;
	private View v;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	
	public Presenter(Model m, View v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
