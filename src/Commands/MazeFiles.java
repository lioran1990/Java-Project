package Commands;

import View.View;
import model.Model;
/**<h1>MazeFiles</h1>
 * The MazeFiles command class.
 * This class implements Commands interface and override doCommand method.
 * This class handling the Load Solutions mission.
 * During the loads process, the file which loaded going through decompress process.
 * This Command is used by both GUI and CLI
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since June 19,2016
 *
 */
public class MazeFiles implements Command {
	
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new MazeFiles command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public MazeFiles(View v , Model m) {
		this.m = m;
		this.v = v;
	}
	
	/**This command saves the MAZE3D object to local hard drive.*/
	@Override
	public void doCommand(String [] args) {
		if (args.length == 1){
				m.getMazeFiles();
			}
		else{
			v.PrintOut("show_files\n");
		}
	}

}
