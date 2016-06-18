package GUI;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import presenter.Properties;

public class SettingsWindow {

	Display display;
	private Button saveSettingsBtn;
	private Button [] runtimeRadios;
	private Button runtimeRadioGUI,runtimeRadioCLI;
	Shell settingsShell;
	Text runtimeTxt;
	Combo dropDown;
	Image image1;
	Properties properties;
	
	public SettingsWindow(Shell shell,Display display) {
		this.display= display;
		settingsShell = shell;
		//this.properties= properties;
		Device device = Display.getCurrent ();		
		Font font1 = new Font(display, "Tahoma", 12, SWT.BOLD);
		
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		

		settingsShell = new Shell(shell, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX );
		settingsShell.setLayout(new GridLayout(1, false));
		settingsShell.setSize(240, 300);
		settingsShell.setText("Settings");
		
		settingsShell.setBackgroundMode(SWT.INHERIT_FORCE);
		image1 = new Image(device,".\\Images\\SettingsWindow.jpg");
		settingsShell.setBackgroundImage(image1);

		Label runtimeLbl = new Label(settingsShell, SWT.BORDER_SOLID);
	
		runtimeLbl.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		runtimeLbl.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		runtimeLbl.setText("Runtime Environment :");
		runtimeLbl.setForeground(white);
		
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.setForeground(white);
		dropDown.add("GUI");
		dropDown.add("CLI");
		dropDown.select(1);
		
		Label generatLb = new Label(settingsShell, SWT.BORDER_SOLID);
		generatLb.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		generatLb.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		generatLb.setText("Maze Generate algorithm :");
		generatLb.setForeground(white);
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.setForeground(white);
		dropDown.add("Simeple Algorithm");
		dropDown.add("Advanced Algorithm");
		dropDown.select(1);
		
		Label solutionLb = new Label(settingsShell, SWT.NONE);
		solutionLb.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		Label lblSample2 = new Label(settingsShell, SWT.BORDER_SOLID);
		lblSample2.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		lblSample2.setText("Maze Solution algorithm :");
		lblSample2.setForeground(white);
		
		dropDown = new Combo(settingsShell, SWT.DROP_DOWN | SWT.BORDER);
		dropDown.setForeground(white);
		dropDown.add("Depth-first search");
		dropDown.add("Best-first Search");
		dropDown.add("Breadth-first Search");
		dropDown.select(1);
		
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