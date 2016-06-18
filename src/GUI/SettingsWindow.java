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
import org.eclipse.swt.widgets.Text;

public class SettingsWindow {

	private Button saveSettingsBtn;
	private Button [] runtimeRadios;
	private Button runtimeRadioGUI,runtimeRadioCLI;
	Shell settingsShell;
	Text runtimeTxt;
	Combo dropDown;
	
	public SettingsWindow(Shell shell) {
		settingsShell = shell;
		
		settingsShell = new Shell(shell, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		settingsShell.setLayout(new GridLayout(3, false));
		settingsShell.setSize(500, 300);
		/*
		Group dialogFieldsGroup = new Group(settingsShell, SWT.SHADOW_ETCHED_IN);
		dialogFieldsGroup.setText("Settings");
		dialogFieldsGroup.setLayout(new GridLayout(2, true));
		dialogFieldsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		*/
		
		Label runtimeLbl = new Label(settingsShell, SWT.BOLD);
		runtimeLbl.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1));
		runtimeLbl.setText("Runtime Environment :");
		
		runtimeRadioGUI = new Button(settingsShell, SWT.RADIO);
		runtimeRadioCLI = new Button(settingsShell, SWT.RADIO);
		runtimeRadioGUI.setText("GUI");
		runtimeRadioCLI.setText("CLI");
		
		
		Label solutionLbl = new Label(settingsShell, SWT.NONE);
		solutionLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		solutionLbl.setText("Default solution algorithm :");
		
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.add("DFS");
		dropDown.add("BFS");
		dropDown.add("breadthfs");
		
		saveSettingsBtn = new Button(settingsShell, SWT.PUSH);
		saveSettingsBtn.setText("save settings");
		saveSettingsBtn.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 4, 4));
		saveSettingsBtn.setBounds(10, 5, 75, 30);
		settingsShell.pack();
	}
	
	public void setSaveSettingsBtnListener (SelectionListener listener){
		saveSettingsBtn.addSelectionListener(listener);	
	}
	
	
	//CLI OR GUI SETTING
	public void setRuntimeEnv (){
		
	}
	
	//SOLUTION SET
	public void setSolutionDefault (){
		
	}
	
	
	public void setMazeGenerator (){
		
	}
	
}
