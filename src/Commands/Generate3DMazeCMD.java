package Commands;

import java.util.concurrent.Callable;

import View.View;
import model.Model;

/** <h1>Generate3DMazeCMD</h1>
 * The Generate 3D MAZE command class.
 * This class implements Commands interface and override doCommand method.
 * This class generates a 3DMAZE object
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class Generate3DMazeCMD implements Command{

	/** The m. */
	private Model m;
	
	/** The v. */
	private View v;
	
	/**
	 * Instantiates a new generate3 d maze cmd.
	 *
	 * @param v the v
	 * @param m the m
	 */
	public Generate3DMazeCMD(View v , Model m) {
		this.m = m;
		this.v = v;
	}

	/**
	 * This command will generate 3DMAZE object
	 */
	@Override
	public void doCommand(String [] args) {
		if (args.length == 5){
			String name = args[1];
			if(isInteger(args[2])){
				int flos = Integer.parseInt(args[2]);
				if(isInteger((args[3]))) {
					int rows = Integer.parseInt(args[3]);
					if(isInteger(args[4])) {
						int cols = Integer.parseInt(args[4]);
						m.generateMaze(name, flos, rows, cols);					
					}
				}	
			}	
		}
		else{
			v.PrintOut("Syntax should be: generate_3d_maze [(String)name] [(int)flors] [(int)rows] [(int)colums]\n");
		}
	}
	

	/**
	 * Checks if is integer.
	 *
	 * @param s the s
	 * @return true, if is integer
	 */
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}


}
