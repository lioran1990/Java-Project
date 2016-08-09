package GUI;

import java.util.Arrays;

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
/** <h1>GenerateWindow</h1>
 * The Generate Window class.
* This class display the Generate window during the GUI execution.
* The generate windows includes name field, and few dropdown lists for Column size, Row size, Floor size.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public class GenerateWindow {
	Shell settingsShell;
	Combo floDropDown, rowDropDown, colDropDown;
	Image image1;
	private Button generateButton;
	Shell generateshell;
	Text nameText,heightText,rowText,columnText;
	
	/**
	 *  @since June 19,2016
	 * @param shell shell
	 * @param display display
	 */
	public GenerateWindow(Shell shell,Display display) {
		
		/** defines the generate windows */
		generateshell = new Shell(shell, SWT.TITLE | SWT.SYSTEM_MODAL | SWT.CLOSE | SWT.MAX);
		generateshell.setLayout(new GridLayout(1, false));
		generateshell.setSize(500, 200);
		generateshell.setImage(shell.getImage());
		
		/** defines the generate background image */
		generateshell.setBackgroundMode(SWT.INHERIT_FORCE);
		Device device = Display.getCurrent ();	
		image1 = new Image(device,".\\Images\\SettingsWindow.jpg");
		generateshell.setBackgroundImage(image1);
		
		generateshell.setText("Game Settings");
		generateshell.setLayout(new GridLayout(2, false));
		Color white = display.getSystemColor(SWT.COLOR_WHITE);
		
		/** defines the maze name field */
		Label nameLabel = new Label(generateshell, SWT.BORDER_SOLID);
		nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		nameLabel.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		nameLabel.setText("Maze Name :");
		nameLabel.setForeground(white);
		nameText = new Text(generateshell,SWT.COLOR_WHITE);
		nameText.setLayoutData(new GridData(SWT.NONE, SWT.BOTTOM, false, true, 1, 1));
		nameText.setForeground(white);
		
		/** defines the floor label */
		Label floorLabel = new Label(generateshell, SWT.BORDER_SOLID);
		floorLabel.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		floorLabel.setText("Floors size:");
		floorLabel.setForeground(white);
		floDropDown = new Combo(generateshell, SWT.DROP_DOWN  | SWT.READ_ONLY);
		String[] ITEMS = {"0","1","2","3", "4", "5", "6","7", "8", "9", "10"  };
		floDropDown.setItems(ITEMS);
		floDropDown.setForeground(white);

		/** defines the row label */
		Label rowLabel = new Label(generateshell, SWT.BORDER_SOLID);
		rowLabel.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		rowLabel.setText("Rows size:");
		rowDropDown = new Combo(generateshell, SWT.DROP_DOWN | SWT.READ_ONLY);
		rowDropDown.setForeground(white);
		rowDropDown.setItems(ITEMS);
		rowLabel.setForeground(white);
		
		/** defines the column label */
		Label ColumnLabel = new Label(generateshell, SWT.BORDER_SOLID);
		ColumnLabel.setFont(new org.eclipse.swt.graphics.Font(null, "Tahoma", 10, SWT.BOLD ));
		ColumnLabel.setText("Columns size:");
		ColumnLabel.setForeground(white);
		colDropDown = new Combo(generateshell, SWT.DROP_DOWN  | SWT.READ_ONLY);
		colDropDown.setForeground(white);
		colDropDown.setItems(ITEMS);
	
		/** defines the generate botton */
		generateButton = new Button(generateshell, SWT.PUSH);
		generateButton.setText("Generate");
		generateButton.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true, 2, 1));
		
		generateshell.setSize (250, 200);
		generateshell.open ();
	}

	public void setTriggerOk(SelectionListener listener){
		generateButton.addSelectionListener(listener);
	}
	

}