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
import Commands.SetSettings;
import Commands.SolveCMD;
import Commands.getMaze2dData;
import MazeAdapters.Maze3dStateAdapter;
import View.View;
import algorithms.mazeGenerator.Maze3d;
import algorithms.search.Solution;
import model.Model;

public class Presenter extends Observable implements Observer{

	private Model model;
	private View view;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	private ExecutorService exs;
	public Properties properties;
	
	public Presenter(Model m, View v, int threads) {
		this.model = m;
		this.view = v;
		this.setCommands();
		exs = Executors.newFixedThreadPool(threads);
		
		
		try {
			properties = PropertiesHandler.getInstance();
		} catch (FileNotFoundException e2) {
			System.out.println("Could not find properties file, using default set");
			properties = new Properties();
			try {
				PropertiesHandler.write(properties, ".\\xml\\properties.xml");
			} catch (Exception e) {
				System.out.println("Could not save default properties file, please check manually");;
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		
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
		
		
		/*
		ViewCmd.put("save_maze", new SaveMazeCMD(view,model));
		ViewCmd.put("save_solutions", new SaveSolutions(view,model));
		ViewCmd.put("load_solutions", new LoadSolutions(view,model));
		ViewCmd.put("load_maze", new LoadMazeCMD(view,model));
		*/
		ViewCmd.put("save", new SaveMazeAndSol(view,model));
		ViewCmd.put("load", new LoadMazeAndSol(view,model));
		
		ModelCmd.put("display_msg", new DisplayMessage(view,model));
		ModelCmd.put("sendMaze", new getMaze2dData(view,model));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == model){
			if (arg.getClass().getName()== "algorithms.mazeGenerator.Maze3d"){
				view.PrintOut(((Maze3d)arg).toString());
				view.setMaze3dData((Maze3d)arg);
				
			}
			else if (arg.getClass().getName()== "algorithms.search.Solution"){
				view.setSolution((Solution)arg);
			}
			else if ( arg.getClass().getName()== "MazeAdapters.Maze3dStateAdapter"){
				view.HintMe((Maze3dStateAdapter)arg);
			}
			else{
				Command cmd = ModelCmd.get((String)arg);			
				cmd.doCommand(null);
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
