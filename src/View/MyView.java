package View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Commands.Command;
import controller.*;


/**<h1>MyView</h1>
* The MyView class.
* This class manges the viewing requests.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class MyView extends Observable implements View, Observer{


	CLI cli;
	
	private BufferedReader reader;
	private PrintWriter writer;
	
	public MyView(BufferedReader reader ,PrintWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
	}
	
	@Override
	public void start() throws Exception {
		CLI cli = new CLI(reader, writer);
		Thread run = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					cli.start();
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
		// TODO Auto-generated method stub
		
	}

}
