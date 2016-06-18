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
import org.eclipse.swt.widgets.Text;

public class SettingsWindow {

	Display display;
	private Button saveSettingsBtn;
	private Button [] runtimeRadios;
	private Button runtimeRadioGUI,runtimeRadioCLI;
	Shell settingsShell;
	Text runtimeTxt;
	Combo dropDown;
	Image image1;
	
	public SettingsWindow(Shell shell,Display display) {
		this.display= display;
		settingsShell = shell;
		//Font font= new Font(SWT.WHITE);
		
		
		settingsShell = new Shell(shell, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		settingsShell.setLayout(new GridLayout(1, false));
		settingsShell.setSize(240,300);
		//settingsShell.setFont(display.getSystemColor(SWT.COLOR_WHITE));
		settingsShell.setText("Runtime Environment :");
		
		runtimeRadioGUI = new Button(settingsShell, SWT.RADIO);
		runtimeRadioCLI = new Button(settingsShell, SWT.RADIO);
		runtimeRadioGUI.setText("GUI");
		runtimeRadioCLI.setText("CLI");
		
		
		Label generateLb = new Label(settingsShell, SWT.NONE);
		generateLb.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		Label lblSample1 = new Label(settingsShell, SWT.BORDER_SOLID);
		lblSample1.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		lblSample1.setText("Maze Generate algorithm :");
		//lblSample1.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
		
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.add("Simeple Algorithm");
		dropDown.add("Advanced Algorithm");
		
		Label solutionLb = new Label(settingsShell, SWT.NONE);
		solutionLb.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		Label lblSample2 = new Label(settingsShell, SWT.BORDER_SOLID);
		lblSample2.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		lblSample2.setText("Maze Solution algorithm :");
		
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.add("Depth-first search");
		dropDown.add("Best-first Search");
		dropDown.add("Breadth-first Search");
		
		saveSettingsBtn = new Button(settingsShell, SWT.PUSH);
		saveSettingsBtn.setText("save settings");
		saveSettingsBtn.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 4, 4));
		saveSettingsBtn.setBounds(10, 5, 75, 30);
		//settingsShell.pack();
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