package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class MainGameWindow {

	protected Display display;
	protected Shell shell;
	

	
	public MainGameWindow() {
		display = new Display();
		shell = new Shell(display);		
	}
	
	public void runme() {
		initWidgets();
		shell.open();
		 while(!shell.isDisposed()){
		    if(!display.readAndDispatch()){
		       display.sleep(); 
		    }
		 }
		 display.dispose();
	}	
	
	protected abstract void initWidgets();
	
	
}
