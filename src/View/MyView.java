package View;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**<h1>MyView</h1>
* The MyView class.
* This class manges the viewing requests.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class MyView extends Observable implements View, Observer{


	CLI cli;
	Board b;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public MyView(BufferedReader reader ,PrintWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
		cli = new CLI(reader, writer);
		cli.addObserver(this);
		b = new Board();
	
	}
	
	@Override
	public void start() throws Exception {
		Thread run = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					//cli.start();
					b.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		run.join();		
		run.start();
	}
	
	public void PrintOut (String str){
		writer.write(str);
		writer.flush();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == cli){
			this.setChanged();
			this.notifyObservers(arg1);	
		}
	}

}
