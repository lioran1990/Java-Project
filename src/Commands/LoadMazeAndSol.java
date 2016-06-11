package Commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import View.View;
import model.Model;

public class LoadMazeAndSol implements Command {

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new save maze cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public LoadMazeAndSol(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 3){
			m.loadFromFile(args[1], args[2]);
			try {
				m.LoadSolutionsFromFile();
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		else{
			v.PrintOut("save_maze [(String) name] [(String)fileName.maz]\n");
		}

	}

}
