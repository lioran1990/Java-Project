package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

public class GameBoard  extends MainGameWindow{

	Button b1;
	Menu menuBar , fileMenu ,helpMenu;
	MenuItem fileMenuHeader, helpMenuHeader;
	MenuItem fileExitItem, fileSaveItem, helpGetHelpItem , helpAboutItem;
	Label label;
	
	public GameBoard() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	protected void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
		shell.setSize(400, 300);
		shell.setText("My Maze Game!!!");
	
		label = new Label(shell, SWT.CENTER);
	    label.setBounds(shell.getClientArea());
	    menuBar = new Menu(shell, SWT.BAR);
	    fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    fileMenuHeader.setText("File");
	    fileMenu = new Menu(shell, SWT.DROP_DOWN);
	    fileMenuHeader.setMenu(fileMenu);

	    fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileSaveItem.setText("Save");

	    fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileExitItem.setText("Exit");

	    helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    helpMenuHeader.setText("Help");

	    helpMenu = new Menu(shell, SWT.DROP_DOWN);
	    helpMenuHeader.setMenu(helpMenu);
	    
	    helpAboutItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpAboutItem.setText("About");
	    
	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpGetHelpItem.setText("Help");
	    

	    fileExitItem.addSelectionListener(new fileExitItemListener());
	    fileSaveItem.addSelectionListener(new fileSaveItemListener());
	    helpGetHelpItem.addSelectionListener(new helpGetHelpItemListener());
	    helpAboutItem.addSelectionListener(new helpAboutItemListiner());
	    
	    shell.setMenuBar(menuBar);
	    
	    MazeBoard mb = new MazeBoard(shell, SWT.BORDER);
	    mb.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
		b1 = new Button(shell, SWT.PUSH);
		b1.setText("цеш обек");
		b1.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,true,1,1));	
	}


	class fileExitItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      shell.close();
	      display.dispose();
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      shell.close();
	      display.dispose();
	    }
	  }

	  class fileSaveItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      label.setText("Saved");
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      label.setText("Saved");
	    }
	  }

	  class helpGetHelpItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      label.setText("No worries!");
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      label.setText("No worries!");
	    }
	  }
	  
	  class helpAboutItemListiner implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			MessageBox dialog = 
    		new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK| SWT.CANCEL);
    		dialog.setText("About");
    		dialog.setMessage("All right reserved. Omri Haviv & Lior Ran 2016© ");
    		dialog.open();
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			MessageBox dialog = 
    		new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK| SWT.CANCEL);
    		dialog.setText("About");
    		dialog.setMessage("All right reserved. Omri Haviv & Lior Ran 2016© ");
    		dialog.open();
		}
		  
	  }
	
}
