package presenter;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Commands.Command;
import Commands.DirCMD;
import Commands.DisplayCMD;
import Commands.DisplayCrossSecCMD;
import Commands.DisplayMessage;
import Commands.DisplaySolutionCMD;
import Commands.ExitCMD;
import Commands.FileSizeCMD;
import Commands.Generate3DMazeCMD;
import Commands.GetCommandsCMD;
import Commands.GetSettings;
import Commands.HintMe;
import Commands.LoadMazeAndSol;
import Commands.MazeFiles;
import Commands.MazeSizeCMD;
import Commands.SaveMazeAndSol;
import Commands.SetProperties;
import Commands.SetSettings;
import Commands.SolveCMD;
import MazeAdapters.Maze3dStateAdapter;
import View.View;
import algorithms.mazeGenerator.Maze3d;
import algorithms.search.Solution;
import model.Model;

/**<h1>Presenter</h1>
* The Presenter class.
* Presenter class extends Observable class and implements Observer interface
* This class actually acts as a broker between the View and the Model classes.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public class Presenter extends Observable implements Observer{

	private Model model;
	private View view;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	private ExecutorService exs;
	public Properties properties;
	
	public Presenter(Model m, View v, int threads , Properties p) {
		this.model = m;
		this.view = v;
		this.properties = p;
		this.setCommands();
		exs = Executors.newFixedThreadPool(threads);
	
		model.setProperties(properties);
		view.setProperties(properties);
	}
	
	public void ResetProperties (){
		try {
			properties = PropertiesHandler.read(".\\xml\\properties.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setProperties(properties);
		view.setProperties(properties);
	}
	
	public HashMap<String, Command> getCommands (){
		return ViewCmd;
	}
	
	public void setCommands (){
		ViewCmd = new HashMap<String, Command>();
		ModelCmd = new HashMap<String, Command>();
		
		ViewCmd.put("dir", new DirCMD(view));
		ViewCmd.put("display", new DisplayCMD(view,model));
		ViewCmd.put("generate_3d_maze", new Generate3DMazeCMD(view,model));
		ViewCmd.put("display_cross_section", new DisplayCrossSecCMD(view,model));
		ViewCmd.put("maze_size", new MazeSizeCMD(view,model));
		ViewCmd.put("file_size", new FileSizeCMD(view,model));
		ViewCmd.put("solve", new SolveCMD(view,model));
		ViewCmd.put("display_solution", new DisplaySolutionCMD(view,model));
		ViewCmd.put("exit", new ExitCMD(view));
		ViewCmd.put("?", new GetCommandsCMD(ViewCmd , this,view));
		ViewCmd.put("show_files", new MazeFiles(view , model));
		ViewCmd.put("show_settings", new GetSettings(view , model));
		ViewCmd.put("set_settings", new SetSettings(view , model));
		ViewCmd.put("hintme", new HintMe(view , model));
		ViewCmd.put("setproperties", new SetProperties(view , this));	
		ViewCmd.put("save", new SaveMazeAndSol(view,model));
		ViewCmd.put("load", new LoadMazeAndSol(view,model));
		
		ModelCmd.put("display_msg", new DisplayMessage(view,model));
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == model){
			switch (arg.getClass().getName()) {
			case "algorithms.mazeGenerator.Maze3d":
				view.PrintOut(((Maze3d)arg).toString());
				view.setMaze3dData((Maze3d)arg);
				break;
			case "algorithms.search.Solution":
				view.setSolution((Solution)arg);
				break;
				
			case "MazeAdapters.Maze3dStateAdapter":
				view.HintMe((Maze3dStateAdapter)arg);
				break;
				
		//	case "java.lang.String":
			//	break;
			
			default:
				Command cmd = ModelCmd.get((String)arg);			
				cmd.doCommand(null);
				break;
			}	
		}
		else if (o == view){
			String Cmdstr = (String)arg;
			String [] spliter = Cmdstr.split(" ");
			Command tempCmd = ViewCmd.get(spliter[0]);
			if (tempCmd == null){
				view.PrintOut("Command Not Found!");
			}
			else{
				tempCmd.doCommand(spliter);
			}
		}
	}
	
}
