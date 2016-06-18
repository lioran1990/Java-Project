package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.Position;
import algorithms.search.Solution;

public class GameBoard  extends MainGameWindow{

	Button b1;
	Menu menuBar , gameMenu ,helpMenu;
	MenuItem gameMenuHeader, helpMenuHeader;
	MenuItem gameExitItem, gameSaveItem , gameLoadItem , gameNewGameItem, gameSolveItem , gameSettingsItem , gameHintItem; 
	MenuItem helpGetHelpItem , helpAboutItem;
	Label label,label2;
	MazeWindow MazeWindow;
	String mazeName;
	
	
	public GameBoard(String title , int width , int height) {
		super (title,width,height);
	}
	
	public void setMaze3dData (Maze3d maze){
		MazeWindow.setMazeData(maze);
		
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append((maze.getStartPosition()).toString());
		String strI = sb.toString();
		
		setLabelText(strI);
		MazeWindow.redraw();		
		shell.redraw();	
	}
	
	public void setSolution (Solution sol){
		MazeWindow.SolveMaze(sol);
	}
	
	public void SolveMaze(String cmd){
		setChanged();
		notifyObservers("solve " + mazeName + " " +cmd);
	}
	
	public void generateMaze (String cmd){
		setChanged();
		notifyObservers("generate_3d_maze "+cmd);
	}
	
	public void HintMe (String cmd){
		setChanged();
		notifyObservers("hintme " + mazeName + " " +cmd);
	}
	
	public void showHint (Position p){
		MazeWindow.showHint(p);
	}
	
	public void getCrosssec(){
		setChanged();
		notifyObservers("display_cross_section x 1 omri");
	}
	
	public void setLabelText (String str){
		label.setText(str);
		label.redraw();
	}
	
	public void setLabel2Text (){
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append("Flo:" + MazeWindow.charFlo + ",");
		sb.append("row:" + MazeWindow.charRow + ",");
		sb.append("col:" + MazeWindow.charCol);
		String strI = sb.toString();
		System.out.println(strI);
		label2.setText(strI);
		label2.redraw();
	}

	@Override
	protected void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
				
		MazeWindow = new MazeWindow(shell, SWT.BORDER);
		MazeWindow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		MazeWindow.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode){
				case SWT.ARROW_DOWN:
					MazeWindow.moveDown();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;
				case SWT.ARROW_UP:
					MazeWindow.moveUp();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;
				case SWT.ARROW_LEFT:
					MazeWindow.moveLeft();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;
				case SWT.ARROW_RIGHT:
					MazeWindow.moveRight();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;
				case SWT.PAGE_DOWN:
					MazeWindow.moveFloDown();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;
				case SWT.PAGE_UP:
					MazeWindow.moveFloUp();
					System.out.println(MazeWindow.charFlo + "," +MazeWindow.charRow + "," + MazeWindow.charCol);
					break;	
				}
			}
		});
		
		label = new Label(shell, SWT.CENTER);
	    label.setBounds(shell.getClientArea());
	    label.setText("Floor :");
	    
	    label2 = new Label(shell, SWT.LEFT);
	    label2.setBounds(shell.getClientArea());
	    label2.setText("Cur Pos");
	    
	    
	    menuBar = new Menu(shell, SWT.BAR);
	    gameMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    gameMenuHeader.setText("Game");
	    gameMenu = new Menu(shell, SWT.DROP_DOWN);
	    gameMenuHeader.setMenu(gameMenu);

	    gameNewGameItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameNewGameItem.setText("New Game");
	    
	    gameSolveItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameSolveItem.setText("Solve");
	    
	    gameHintItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameHintItem.setText("Hint");
	    
	    gameLoadItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameLoadItem.setText("Load");

	    gameSaveItem = new MenuItem(gameMenu, SWT.PUSH);
	    gameSaveItem.setText("Save");

	    gameSettingsItem = new MenuItem(gameMenu , SWT.PUSH);
	    gameSettingsItem.setText("Settings");
	    
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
	    
  
	    
	    gameHintItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(MazeWindow.charFlo + " ");
				sb.append(MazeWindow.charRow + " ");
				sb.append(MazeWindow.charCol + " ");
				sb.append("DFS"); //NEED TO COLLECT FROM THE SETTINGS!
				String strI = sb.toString();
				System.out.println(strI);
				
				HintMe(strI);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    gameSettingsItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SettingsWindow sw = new SettingsWindow(shell,display);
				sw.settingsShell.open();
				sw.setSaveSettingsBtnListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						MessageBox dialog = 
					    		new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					    		dialog.setText("Error");
					    		dialog.setMessage("asdasd");
					    		dialog.open();
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    gameExitItem.addSelectionListener(new gameExitItemListener());
	    //gameSaveItem.addSelectionListener();
	    gameSolveItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SolveWindow sw = new SolveWindow(shell);
				sw.setListenerSolveBtn(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						//CHOOSE SOLUTION!!!!!
						String str = sw.dropDown.getText();
						SolveMaze(str);
						sw.solveShell.dispose();
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    
	    gameLoadItem.addSelectionListener (new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    gameNewGameItem.addSelectionListener(new SelectionListener() {
			
	    	
	    	/// NEEDS TO XOMPLETE ERROR CHECK!!!!
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateWindow gw = new GenerateWindow(shell);
				gw.setTriggerOk(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						MessageBox dialog = 
			    		new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
			    		dialog.setText("Error");
			    		dialog.setMessage("One or more parameters are invalid");
						
						if (gw.nameText.getText().isEmpty()){
							dialog.open();
						}
						else{
							try{
								
								Integer.parseInt(gw.heightText.getText());
								Integer.parseInt(gw.columnText.getText());
								Integer.parseInt(gw.rowText.getText());
								mazeName = gw.nameText.getText() ;
								generateMaze(gw.nameText.getText() + " " + gw.heightText.getText() + " " + gw.rowText.getText() + " " + gw.columnText.getText());
								gw.generateshell.dispose();
							}
							catch (NumberFormatException e){
					    		dialog.open();
							}	
						}
								
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						
					}
				});
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    helpGetHelpItem.addSelectionListener(new helpGetHelpItemListener());
	    
	    helpAboutItem.addSelectionListener(new SelectionListener() {
			
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
		});
		
	    shell.setMenuBar(menuBar);
	    

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
	     // display.dispose();
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      shell.close();
	    //  display.dispose();
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
	  



	
}
