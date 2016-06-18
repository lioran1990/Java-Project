package GUI;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SolveWindow {

	private Button solveBtn;
	Shell solveShell;
	Combo dropDown;
	
	public SolveWindow(Shell shell) {
		solveShell = new Shell(shell,SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX );
		solveShell.setLayout(new GridLayout(2, false));
		solveShell.setSize(300,150);
		
		
		Group dialogFieldsGroup = new Group(solveShell, SWT.SHADOW_ETCHED_IN);
		dialogFieldsGroup.setText("Solve Window");
		dialogFieldsGroup.setLayout(new GridLayout(2, true));
		dialogFieldsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Label chooseLbl = new Label(dialogFieldsGroup, SWT.NONE);
		chooseLbl.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		chooseLbl.setText("Choose Algorithm :");
		
		dropDown = new Combo(dialogFieldsGroup, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.add("DFS");
		dropDown.add("BFS");
		dropDown.add("breadthfs");
			
		solveBtn = new Button(dialogFieldsGroup, SWT.PUSH);
		solveBtn.setText("Solve");
		solveBtn.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1));
		
		solveShell.open();	
		solveShell.pack();
	}
	
	public void setListenerSolveBtn(SelectionListener listener) {
		solveBtn.addSelectionListener(listener);
	}
}
