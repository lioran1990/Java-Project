package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GameBoard  extends MainGameWindow{

	Button b1;
	Menu menuBar , gameMenu ,helpMenu;
	MenuItem gameMenuHeader, helpMenuHeader;
	MenuItem gameExitItem, gameSaveItem , gameLoadItem , gameNewGameItem; 
	MenuItem helpGetHelpItem , helpAboutItem;
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
	    gameMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    gameMenuHeader.setText("Game");
	    gameMenu = new Menu(shell, SWT.DROP_DOWN);
	    gameMenuHeader.setMenu(gameMenu);

	    gameNewGameItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameNewGameItem.setText("New Game");
	    
	    gameLoadItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameLoadItem.setText("Load");
  
	    gameSaveItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameSaveItem.setText("Save");

	    gameExitItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameExitItem.setText("Exit");

	    helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    helpMenuHeader.setText("Help");

	    helpMenu = new Menu(shell, SWT.DROP_DOWN);
	    helpMenuHeader.setMenu(helpMenu);
	    
	    helpAboutItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpAboutItem.setText("About");
	    
	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpGetHelpItem.setText("Help");
	    

	    gameExitItem.addSelectionListener(new gameExitItemListener());
	    gameSaveItem.addSelectionListener(new gameSaveItemListener());
	    gameLoadItem.addSelectionListener (new gameLoadItemListener());
	    gameNewGameItem.addSelectionListener(new gameNewGameItemListener());
	    helpGetHelpItem.addSelectionListener(new helpGetHelpItemListener());
	    helpAboutItem.addSelectionListener(new helpAboutItemListiner());
	    
	    shell.setMenuBar(menuBar);
	    
	    MazeBoard mb = new MazeBoard(shell, SWT.BORDER);
	    mb.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		/*
		b1 = new Button(shell, SWT.PUSH);
		b1.setText("цеш обек");
		b1.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,true,1,1));
		*/	
	}


	class gameLoadItemListener implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class gameNewGameItemListener implements SelectionListener{

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			
		
		}
		
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class gameExitItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      shell.close();
	      display.dispose();
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      shell.close();
	      display.dispose();
	    }
	  }

	  class gameSaveItemListener implements SelectionListener {
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
