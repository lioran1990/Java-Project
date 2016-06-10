package Commands;

import java.io.IOException;

import View.View;
import model.Model;

public class LoadSolutions implements Command{

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
	public LoadSolutions(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 1){
			try {
				m.LoadSolutionsFromFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		else{
			v.PrintOut("load_solutions\n");
		}
	}
}
