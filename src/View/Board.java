package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Board  {
	
	Display display;
	Shell shell;
	Button b1;
	

	public Board (){
		
	}
	
	public void start (){
		
		display = new Display();
		shell = new Shell(display);
		shell.setLayout(new GridLayout(2,false));
		shell.setSize(400, 300);
		shell.setText("My Maze Game!!!");
		b1 = new Button(shell, SWT.PUSH);
		b1.setText("цеш обек");
		b1.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		
		shell.open();
	}
}
