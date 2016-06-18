package GUI;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import presenter.Properties;

public class SolveWindow {

	private Button solveButton;
	Shell solveShell;
	Combo dropDown;
	Image image1;
	
	public SolveWindow(Shell shell,Display display ,Properties p)
	{
		solveShell = new Shell(shell,SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX );
		solveShell.setLayout(new GridLayout(2, false));
		solveShell.setSize(300,150);
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		
		solveShell.setBackgroundMode(SWT.INHERIT_FORCE);
		Device device = Display.getCurrent ();	
		image1 = new Image(device,".\\Images\\SettingsWindow.jpg");
		solveShell.setBackgroundImage(image1);
		
		
		solveShell.setText("Solve Window");
		solveShell.setLayout(new GridLayout(2, true));
		solveShell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		Label chooseLbl = new Label(solveShell, SWT.NONE);
		chooseLbl.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		chooseLbl.setText("Choose Algorithm :");
		chooseLbl.setForeground(white);
		dropDown = new Combo(solveShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.add("Depth-first search");
		dropDown.add("Best-first search");
		dropDown.add("breadth-first sarch");
		dropDown.select(p.getSolveAlgorithm());
		dropDown.setForeground(white);
			
		solveButton = new Button(solveShell, SWT.PUSH);
		solveButton.setText("Solve");
		solveButton.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 2, 2));
		
		solveShell.open();	
		solveShell.pack();
	}
	
	public void setListenerSolveBtn(SelectionListener listener) {
		solveButton.addSelectionListener(listener);
	}
}