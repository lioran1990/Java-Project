package GUI;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import View.View;

public class GameView extends Observable implements View, Runnable {

	Display display;
	Shell shell;
	Button b1;
	Menu menuBar , gameMenu ,helpMenu;
	MenuItem gameMenuHeader, helpMenuHeader;
	MenuItem gameExitItem, gameSaveItem , gameLoadItem , gameNewGameItem; 
	MenuItem helpGetHelpItem , helpAboutItem;
	Label label;
	
	private void initComponents(){		
		display = new Display();
		shell = new Shell(display);	
		shell.setLayout(new GridLayout(2,false));
		shell.setSize(400, 300);
		shell.setText("My Maze Game!!!");
	
	    Board b = new Board (shell , SWT.BORDER);
		b.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true ,1,2));
	
		b1 = new Button(shell, SWT.PUSH);
		b1.setText("blabla");
		b1.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
	}
	
	@Override
	public void run() {
		initComponents();
		shell.open();
		 while(!shell.isDisposed()){
		    if(!display.readAndDispatch()){
		       display.sleep(); 
		    }
		 }
		 display.dispose();

	}

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void PrintOut(String string) {
		// TODO Auto-generated method stub

	}
	
	public void close (){
		shell.dispose();
		display.dispose();
	}

}
