package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Shell;

public class LoadMazeWindow {

	Shell loadMazeShell;
	Combo mazeList;
	public LoadMazeWindow(Shell shell ,String list) {
		loadMazeShell = new Shell (shell,SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		loadMazeShell.setLayout(new GridLayout(1, false));
		loadMazeShell.setSize(500, 200);
		loadMazeShell.setText("Load Maze");
		
		
		mazeList = new Combo(loadMazeShell, SWT.SIMPLE | SWT.BORDER);
		mazeList.setItems(list.split("\n"));
		
		loadMazeShell.open();
	}
}
