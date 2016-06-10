package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
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
import Commands.LoadMazeCMD;
import Commands.LoadSolutions;
import Commands.MazeSizeCMD;
import Commands.SaveMazeCMD;
import Commands.SaveSolutions;
import Commands.SolveCMD;
import View.View;
import model.Model;

public class Presenter extends Observable implements Observer{

	private Model model;
	private View view;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	private ExecutorService exs;
	
	public Presenter(Model m, View v, int threads) {
		this.model = m;
		this.view = v;
		this.setCommands();
		exs = Executors.newFixedThreadPool(threads);
	}
	
	public void setCommands (){
		ViewCmd = new HashMap<String, Command>();
		ModelCmd = new HashMap<String, Command>();
		
		ViewCmd.put("dir", new DirCMD(view));
		ViewCmd.put("display", new DisplayCMD(view,model));
		ViewCmd.put("generate_3d_maze", new Generate3DMazeCMD(view,model));
		ViewCmd.put("display_cross_section", new DisplayCrossSecCMD(view,model));
		ViewCmd.put("save_maze", new SaveMazeCMD(view,model));
		ViewCmd.put("save_solutions", new SaveSolutions(view,model));
		ViewCmd.put("load_solutions", new LoadSolutions(view,model));
		ViewCmd.put("load_maze", new LoadMazeCMD(view,model));
		ViewCmd.put("maze_size", new MazeSizeCMD(view,model));
		ViewCmd.put("file_size", new FileSizeCMD(view,model));
		ViewCmd.put("solve", new SolveCMD(view,model));
		ViewCmd.put("display_solution", new DisplaySolutionCMD(view,model));
		ViewCmd.put("exit", new ExitCMD(view));
		ViewCmd.put("?", new GetCommandsCMD(ViewCmd , view));
		
		ModelCmd.put("display_msg", new DisplayMessage(view,model));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == model){
			Command cmd = ModelCmd.get((String)arg);
			cmd.doCommand(null);
		}
		else if (o == view){
			String Cmdstr = (String)arg;
			String [] spliter = Cmdstr.split(" ");
			Command tempCmd = ViewCmd.get(spliter[0]);
			if (tempCmd == null){
				view.PrintOut("Command Not Found!");
			}
			else{
				if (spliter[0].equalsIgnoreCase("generate_3d_maze") || spliter[0].equalsIgnoreCase("solve")){
					exs.submit(new Callable<Void>() {

						@Override
						public Void call() throws Exception {
							tempCmd.doCommand(spliter);
							return null;
						}
					
					});	
				}
				else{
					tempCmd.doCommand(spliter);	
				}
			}
		}
	}
	
}
