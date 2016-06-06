package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import Commands.Command;

/**<h1>CLI</h1>
* The CLI class.
* This class implements View command interface
* CLI is the mechanism of the program, connects user command request and handle the viewing process.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class CLI implements View {

	private BufferedReader in;
	private PrintWriter out;

	
	public CLI(BufferedReader in,PrintWriter out) {
		this.in = in;
		this.out = out;
		
	}
	
	@Override
	public void start() throws Exception {
		Thread thread = new Thread(new Runnable() {
			String cmd = null;
			Command tempCmd = null;

			@Override
			public void run() {
				out.write("Type ? For HELP \n");
				do{
					out.write("Type a Command :\n");
					out.flush();
					try {
						cmd = in.readLine();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
					
					String [] spliter = cmd.split(" ");
					tempCmd = commands.get(spliter[0]);
					if (tempCmd == null){
						out.write("Command Not Found!");
						out.flush();
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
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							cmd.start();
							
						}
						else{
							tempCmd.doCommand(spliter);	
						}	
					}		
					out.write("\n");			
				}while (!cmd.equalsIgnoreCase("exit"));
			}

		});
	
		thread.run();
		thread.join();
		
	}

	@Override
	public void PrintOut(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
