package Commands;

import View.View;
import model.Model;


/** <h1>FileSizeCMD</h1>
 * The File Size command class.
 * This class implements Commands interface and override doCommand method.
 * This class show the actual file size saved on the local disk.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class FileSizeCMD implements Command {
	
	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new file size command object.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public FileSizeCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will show the current actual file size on disk.
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 2){
			m.Maze_File_Size(args[1]);
		}
		else{
			v.PrintOut("file_size [(String) filename]\n");
		}

	}

}
