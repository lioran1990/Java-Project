package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

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
import Commands.MazeSizeCMD;
import Commands.SaveMazeCMD;
import Commands.SolveCMD;
import View.CLI;
import View.View;
import model.Model;

public class Presenter extends Observable implements Observer{

	private Model model;
	private View view;
	private HashMap<String, Command> ViewCmd;
	private HashMap<String, Command> ModelCmd;
	
	public Presenter(Model m, View v) {
		this.model = m;
		this.view = v;
		this.setCommands();
	}
	
	public void setCommands (){
		ViewCmd = new HashMap<String, Command>();
		ModelCmd = new HashMap<String, Command>();
		
		ViewCmd.put("dir", new DirCMD(view));
		ViewCmd.put("display", new DisplayCMD(view,model));
		ViewCmd.put("generate_3d_maze", new Generate3DMazeCMD(view,model));
		ViewCmd.put("display_cross_section", new DisplayCrossSecCMD(view,model));
		ViewCmd.put("save_maze", new SaveMazeCMD(view,model));
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
				Thread cmd = null;
				if (spliter[0].equalsIgnoreCase("generate_3d_maze") || spliter[0].equalsIgnoreCase("solve")){
					cmd = new Thread(new Runnable() {
						public void run() {
							tempCmd.doCommand(spliter);
						}
					});
					try {
						cmd.join();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					cmd.start();	
				}
				else{
					tempCmd.doCommand(spliter);	
				}
			}
		}
	}
	
}
