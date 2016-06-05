package controller;

import java.util.HashMap;

import Commands.*;
import View.View;
import model.Model;

public class MyController implements Controller {
	/**<h1>MyController</h1>
	 * The MyController class.
	 * MyController is the engine behind the MVC design pattern.
	 * Actually it acts as broker between View and Model.
	 * The Constructor HashMap of all of the commands
	 * @author Lior Ran and Omri Haviv
	 * @version 1.0
	 * @since May 21,2016
	 */
	View v;
	Model m;
	HashMap<String, Command> commands;
	
	public MyController() {
		commands = new HashMap<String,Command>();
	}
	/**
	 * setCommands methos puts all the available commands into local HashMap <String, Commands>
	 */
	public void setCommands (){
		commands.put("dir", new DirCMD(v));
		commands.put("display", new DisplayCMD(v,m));
		commands.put("generate_3d_maze", new Generate3DMazeCMD(v,m));
		commands.put("display_cross_section", new DisplayCrossSecCMD(v,m));
		commands.put("save_maze", new SaveMazeCMD(v,m));
		commands.put("load_maze", new LoadMazeCMD(v,m));
		commands.put("maze_size", new MazeSizeCMD(v,m));
		commands.put("file_size", new FileSizeCMD(v,m));
		commands.put("solve", new SolveCMD(v,m));
		commands.put("display_solution", new DisplaySolutionCMD(v,m));
		commands.put("exit", new ExitCMD(v));
		commands.put("?", new GetCommandsCMD(commands , v));
	}
	
	public HashMap<String,Command> getCommands (){
		return commands;
	}

	@Override
	public void setView(View v) {
		this.v = v;		
	}

	@Override
	public void setModel(Model m) {
		this.m = m;
	}
		
	
}
