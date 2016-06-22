package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseWheelListener;
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
import presenter.Properties;

/** <h1>GameBoard</h1>
 * The GameBoard class.
* This class extends MainGameWindow class.
* This class display the main game windows during the GUI execution.
* 
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public class GameBoard extends MainGameWindow {

	Button b1;
	Menu menuBar, gameMenu, helpMenu;
	MenuItem gameMenuHeader, helpMenuHeader;
	MenuItem gameExitItem, gameSaveItem, gameLoadItem, gameNewGameItem, gameSolveItem, gameSettingsItem, gameHintItem;
	MenuItem helpAboutItem;
	Label label, label2;
	MazeWindow MazeWindow;
	String mazeName , dialogStr;
	Properties p;
	MouseWheelListener mouseZoomlListener;
	
	/** GameBoard Constructor*/
	public GameBoard(String title, int width, int height) {
		super(title, width, height);
	}
	
	/** Properties setter**/
	public void setProperties(Properties p) {
		this.p = p;
	}
	
	/** Maze3dData setter**/
	public void setMaze3dData(Maze3d maze) {
		MazeWindow.setMazeData(maze);

		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append((maze.getStartPosition()).toString());
		String strI = sb.toString();

		MazeWindow.redraw();
		MazeWindow.winner = false;
		shell.redraw();
	}
	
	/** Solution setter**/
	public void setSolution(Solution sol) {
		MazeWindow.SolveMaze(sol);
	}

	/** SolveMaze command**/
	public void SolveMaze(String cmd) {
		setChanged();
		notifyObservers("solve " + mazeName + " " + cmd);
	}
	
	/** generateMaze command**/
	public void generateMaze(String cmd) {
		setChanged();
		notifyObservers("generate_3d_maze " + cmd);
	}
	
	/** HintMe command**/
	public void HintMe(String cmd) {
		setChanged();
		notifyObservers("hintme " + mazeName + " " + cmd);
	}
	
	/** showHint command**/
	public void showHint(Position p) {
		MazeWindow.showHint(p);
	}
	
	/** getCrosssec command**/
	public void getCrosssec() {

		setChanged();
		notifyObservers("display_cross_section x 1 omri");
	}
	
	/** saveMaze command**/
	public void saveMaze(){
		setChanged();
		notifyObservers("save " + mazeName);
	}

	/** loadMaze command**/
	public void loadMaze(String file){
		setChanged();
		notifyObservers("load " + file);
	}
	
	/** saveSettings command**/
	public void saveSetting() {
		setChanged();
		notifyObservers("setproperties");
	}
	
	/** gerProperties command**/
	public Properties getProperties() {
		return p;
	}
	
	/** LoadSettings command**/
	public void LoadSetting(String cmd) {
		setChanged();
		notifyObservers("loadsettings");
	}
	
	/** getMazeFilesList command**/
	public void getMazeFilesList(){
		setChanged();
		notifyObservers("show_files");
	}
	
	/** setLabel2Text command**/
	public void setLabel2Text() {
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
	
	/** opendialog command**/
	public void opendialog(String str) {
		this.dialogStr = str;		
	}
	
	/** initWidgets commands**/
	@Override
	protected void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

		MazeWindow = new MazeWindow(shell, SWT.BORDER);
		MazeWindow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));


		shell.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseScrolled(MouseEvent e) {
				if ((e.stateMask & SWT.CTRL) != 0)
					MazeWindow.setSize(MazeWindow.getSize().x + e.count,
							MazeWindow.getSize().y + e.count);
				
			}
		});
		MazeWindow.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (MazeWindow.winner == true){
					gameSolveItem.setEnabled(false);
					gameHintItem.setEnabled(false);
				}


			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (MazeWindow.winner == false){
					
					switch (e.keyCode) {
					case SWT.ARROW_DOWN:
						MazeWindow.moveDown();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					case SWT.ARROW_UP:
						MazeWindow.moveUp();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					case SWT.ARROW_LEFT:
						MazeWindow.moveLeft();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					case SWT.ARROW_RIGHT:
						MazeWindow.moveRight();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					case SWT.PAGE_DOWN:
						MazeWindow.moveFloDown();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					case SWT.PAGE_UP:
						MazeWindow.moveFloUp();
						System.out.println(MazeWindow.charFlo + "," + MazeWindow.charRow + "," + MazeWindow.charCol);
						break;
					}
				}
							
			}
		});
				
		
		/** Game Menu**/
		menuBar = new Menu(shell, SWT.BAR);
		gameMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		gameMenuHeader.setText("Game");
		gameMenu = new Menu(shell, SWT.DROP_DOWN);
		gameMenuHeader.setMenu(gameMenu);
		
		/** newGame Menu**/
		gameNewGameItem = new MenuItem(gameMenu, SWT.PUSH);
		gameNewGameItem.setText("New Game");
		
		/** Solve Menu**/
		gameSolveItem = new MenuItem(gameMenu, SWT.PUSH);
		gameSolveItem.setText("Solve");
		gameSolveItem.setEnabled(false);
		
		/** gameHint Menu**/
		gameHintItem = new MenuItem(gameMenu, SWT.PUSH);
		gameHintItem.setText("Hint");
		gameHintItem.setEnabled(false);
		
		/** Load Menu**/
		gameLoadItem = new MenuItem(gameMenu, SWT.PUSH);
		gameLoadItem.setText("Load");
		
		/** Save Menu**/
		gameSaveItem = new MenuItem(gameMenu, SWT.PUSH);
		gameSaveItem.setText("Save");
		gameSaveItem.setEnabled(false);
		
		/** gameSetting Menu**/
		gameSettingsItem = new MenuItem(gameMenu, SWT.PUSH);
		gameSettingsItem.setText("Settings");
		
		/** ExitItem Menu**/
		gameExitItem = new MenuItem(gameMenu, SWT.PUSH);
		gameExitItem.setText("Exit");
		
		/** Help Menu**/
		helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		helpMenuHeader.setText("Help");
		
		/** Help Menu**/
		helpMenu = new Menu(shell, SWT.DROP_DOWN);
		helpMenuHeader.setMenu(helpMenu);
		
		/** About Menu**/
		helpAboutItem = new MenuItem(helpMenu, SWT.PUSH);
		helpAboutItem.setText("About");
		
		/** gameSave Listener**/
		gameSaveItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				saveMaze();
				MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				dialog.setText("Saved");
				dialog.setMessage(dialogStr);
				dialog.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		/** gameHint Listener**/
		gameHintItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append(MazeWindow.charFlo + " ");
				sb.append(MazeWindow.charRow + " ");
				sb.append(MazeWindow.charCol + " ");
				sb.append("DFS"); // NEED TO COLLECT FROM THE SETTINGS!
				String strI = sb.toString();
				System.out.println(strI);

				HintMe(strI);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		/** gameSettings Listener**/
		gameSettingsItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				SettingsWindow sw = new SettingsWindow(shell, display, p);
				sw.settingsShell.open();
				sw.setSaveSettingsBtnListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						Properties p = new Properties(sw.genDropDown.getSelectionIndex(),
								sw.algoDropDown.getSelectionIndex(), sw.runtimeDropDown.getSelectionIndex(), 2);
						setProperties(p);
						saveSetting();
						sw.settingsShell.dispose();
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
		
		/** gameExit Listener**/
		gameExitItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		/** gameSolve Listener**/
		gameSolveItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SolveWindow sw = new SolveWindow(shell, display, p);
				sw.setListenerSolveBtn(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						// CHOOSE SOLUTION!!!!!
						String str = "dfs";
						switch (sw.dropDown.getSelectionIndex()) {
						case 0:
							str = "dfs";
							break;
						case 1:
							str = "bfs";
							break;
						case 2:
							str = "breadthfs";
							break;
						}
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
		
		/** gameLoad Listener**/
		gameLoadItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				getMazeFilesList();
				LoadMazeWindow lmw = new LoadMazeWindow(shell, display,dialogStr);
				gameSolveItem.setEnabled(true);
				gameSaveItem.setEnabled(true);
				gameHintItem.setEnabled(true);
				lmw.setloadMazeBtnListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						loadMaze(lmw.mazeList.getText());
						lmw.loadMazeShell.dispose();
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				lmw.setMazeListListener(new MouseListener() {
					
					@Override
					public void mouseUp(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseDown(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseDoubleClick(MouseEvent arg0) {
						loadMaze(lmw.mazeList.getText());
						lmw.loadMazeShell.dispose();
					}
				});
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		/** NewGame Listener**/
		gameNewGameItem.addSelectionListener(new SelectionListener() {

			/// NEEDS TO XOMPLETE ERROR CHECK!!!!
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateWindow gw = new GenerateWindow(shell, display);
				gw.setTriggerOk(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
						dialog.setText("Error");
						dialog.setMessage("One or more parameters are invalid");

						if (gw.nameText.getText().isEmpty()) {
							dialog.open();
						} else {
							try {
								StringBuilder sb = new StringBuilder();
								sb.append(gw.floDropDown.getText()+ " ");
								sb.append(gw.rowDropDown.getText()+ " ");
								sb.append(gw.colDropDown.getText()+ " ");
								mazeName = gw.nameText.getText();
								generateMaze(gw.nameText.getText() + " " + sb);
								gw.generateshell.dispose();
								gameSolveItem.setEnabled(true);
								gameSaveItem.setEnabled(true);
								gameHintItem.setEnabled(true);
							} catch (NumberFormatException e) {
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
		
		/** gameExit Listener**/
		helpAboutItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				dialog.setText("About");
				dialog.setMessage("All right reserved. Omri Haviv & Lior Ran 2016© ");
				dialog.open();
			}
		});
		
		shell.setMenuBar(menuBar);

	}


}
