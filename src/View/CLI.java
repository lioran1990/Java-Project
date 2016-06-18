package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;

import Commands.Command;

/**
 * <h1>CLI</h1> The CLI class. This class implements View command interface CLI
 * is the mechanism of the program, connects user command request and handle the
 * viewing process.
 * 
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public class CLI extends Observable {

	private BufferedReader in;
	private PrintWriter out;

	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	public void start() throws Exception {
		Thread thread = new Thread(new Runnable() {
			String cmd = null;
			Command tempCmd = null;

			@Override
			public void run() {
				out.write("Type ? For HELP");

				do {
					out.write("\nType a Command :\n");
					out.flush();
					try {
						cmd = in.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					setChanged();
					notifyObservers(cmd);

				} while (!(cmd.equals("exit")));

			}

		});
		thread.start();
		thread.join();
		System.out.println("BYE BYE!");
	}
}
