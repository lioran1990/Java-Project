package GUI;

import java.util.Observable;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class MainGameWindow extends Observable implements Runnable{

	protected Display display;
	protected Shell shell;
	Image icon;

	
	public MainGameWindow(String title , int width , int height) {
		display = new Display();
		shell = new Shell(display);	
		shell.setSize(width, height);
		shell.setText(title);
		Device device = Display.getCurrent ();	
		icon = new Image(device,".\\Images\\icon2.png");
		shell.setImage(icon);
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
