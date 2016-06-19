package Commands;

import java.io.IOException;

import View.View;
import model.Model;
/**<h1>LoadSolutions</h1>
 * The Load Solutions command class.
 * This class implements Commands interface and override doCommand method.
 * This class handling the Load Solutions mission.
 * During the loads process, the file which loaded going through decompress process.
 * This Command is used by both GUI and CLI
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 *
 */
public class LoadSolutions implements Command{

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new LoadSolution command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public LoadSolutions(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command loads the MAZE3D solutions object from local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 1){
//			m.LoadSolutionsFromFile();
			}
		else{
			v.PrintOut("load_solutions\n");
		}
	}
}
