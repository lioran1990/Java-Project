package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/** <h1>LoadMazeWidnow</h1>
 * The LoadMAzeWindow class.
* This class display the Load window during the GUI execution.
* The Load window contain a combo drop-down list which lists all the available Maze files on the local hard drive at current time.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public class LoadMazeWindow {

	Shell loadMazeShell;
	Display loadMazeDisplay;
	Combo mazeList;
	Button loadMazeBtn;
	Image image1;
	
	public LoadMazeWindow(Shell shell , Display display,String list) {
		loadMazeShell = new Shell (shell,SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		loadMazeDisplay = display;
		loadMazeShell.setLayout(new GridLayout(2, false));
		loadMazeShell.setSize(230, 192);
		loadMazeShell.setText("Load Maze");
		loadMazeShell.setBackgroundMode(SWT.INHERIT_FORCE);
		loadMazeShell.setImage(shell.getImage());
		Device device = Display.getCurrent ();	
		image1 = new Image(device,".\\Images\\SettingsWindow.jpg");
		loadMazeShell.setBackgroundImage(image1);
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		loadMazeShell.setForeground(white);
		
		mazeList = new Combo(loadMazeShell, SWT.SIMPLE | SWT.BORDER);
		mazeList.setItems(list.split("\n"));
		mazeList.setForeground(white);
		
		loadMazeBtn = new Button(loadMazeShell, SWT.PUSH);
		loadMazeBtn.setText("Commit  Load");
		loadMazeBtn.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 2, 2));
		loadMazeBtn.setBounds(10, 5, 75, 30);
		loadMazeShell.open();
	}
	/** Set Maze list listener*/
	public void setMazeListListener (MouseListener listener){
		mazeList.addMouseListener(listener);
	}
	/** Set load maze listener*/
	public void setloadMazeBtnListener (SelectionListener listener){
		loadMazeBtn.addSelectionListener(listener);
	}
}