package View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import Commands.Command;
import controller.*;


/**<h1>MyView</h1>
* The MyView class.
* This class manges the viewing requests.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class MyView implements View {

	Controller c;
	CLI cli;
	
	private BufferedReader reader;
	private PrintWriter writer;
	private HashMap<String, Command> commands;
	
	public MyView(Controller c) throws Exception {
		this.c = c;
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		commands = new HashMap<String,Command>();
		commands = ((MyController)c).getCommands();
	}
	
	@Override
	public void start() throws Exception {
		CLI cli = new CLI(reader, writer, commands);
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

}
