package GUI;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class MainGameWindow extends Observable implements Runnable{

	protected Display display;
	protected Shell shell;
	

	
	public MainGameWindow() {
		display = new Display();
		shell = new Shell(display);		
	}
	
	protected abstract void initWidgets();
	
	
	@Override
	public void run() {
		initWidgets();
		shell.open();
		 while(!shell.isDisposed()){
		    if(!display.readAndDispatch()){
		       display.sleep(); 
		    }
		 }
		 display.dispose();
		
	}
	
}
