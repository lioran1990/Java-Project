package GUI;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.Position;
import algorithms.search.Solution;

/** <h1>MazeWindow</h1>
 * The MazeDisplayer class.
 * This class extends MazeDisplayer class
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since June 19,2016
*/
public class MazeWindow extends MazeDisplayer {

	Timer timer;
	TimerTask task;
	boolean timerActive;
	Image image, win, arrow , exit;
	boolean winner = false;

	public void setMazeData(Maze3d maze) {
		mazeData = maze;
		setCharacterPosition(mazeData.getStartPosition().getRow(), mazeData.getStartPosition().getCol());
		currentPlayerPos = new Position(mazeData.getStartPosition());
		charFlo = mazeData.getStartPosition().getFlo();

		Device device = Display.getCurrent();
		win = new Image(device, ".\\Images\\winner.jpg");
		arrow = new Image(device, ".\\Images\\arrow.jpg");
		exit = new Image(device, ".\\Images\\exit.jpg");
		
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {

				e.gc.setForeground(new Color(null, 0, 0, 0));
				e.gc.setBackground(new Color(null, 0, 0, 0));

				int width = getSize().x;
				int height = getSize().y;

				if (mazeData != null && currentPlayerPos != null && mazeData.getStartPosition() != null
						&& mazeData.getGoalPosition() != null) {
					if (currentPlayerPos.equals(mazeData.getGoalPosition())) {
						e.gc.drawImage(win, 0, 0, win.getBounds().width, win.getBounds().height, 0, 0, width, height);
						winner = true;
						return;
					} else {
						int mx = width / 2;

						double w = (double) width / mazeData.getMaze3d()[0][0].length;
						double h = (double) height / mazeData.getMaze3d()[0].length;

						for (int i = 0; i < mazeData.getMaze3d()[0].length; i++) {
							double w0 = 0.7 * w + 0.3 * w * i / mazeData.getMaze3d()[0].length;
							double w1 = 0.7 * w + 0.3 * w * (i + 1) / mazeData.getMaze3d()[0].length;
							double start = mx - w0 * mazeData.getMaze3d()[0][i].length / 2;
							double start1 = mx - w1 * mazeData.getMaze3d()[0][i].length / 2;
							for (int j = 0; j < mazeData.getMaze3d()[0][i].length; j++) {

								int x = (int) (j * w);
								int y = (int) (i * h);
								double[] dpoints = { start + j * w0, i * h, start + j * w0 + w0, i * h,
										start1 + j * w1 + w1, i * h + h, start1 + j * w1, i * h + h };
								double cheight = h / 2;
								if (mazeData.getMaze3d()[charFlo][i][j] != 0){
									paintCube(dpoints, cheight, e);	
								}
								if ((charFlo == mazeData.getGoalPosition().getFlo())){
									if (i == mazeData.getGoalPosition().getRow()){
										if(j == mazeData.getGoalPosition().getCol()){
											e.gc.drawImage(exit, 0, 0, exit.getBounds().width,
													exit.getBounds().height, (int) (x + (2 * (w / 2))), y,
													(int) (w ), (int) (h));
										}
									}
									
								}
									

								if (currentPlayerPos.equals(mazeData.getGoalPosition())) {
									return;
								}
								if (i == charRow && j == charCol) {
									e.gc.setBackground(new Color(null, 200, 0, 0));
									e.gc.fillOval((int) Math.round(dpoints[0]),
											(int) Math.round(dpoints[1] - cheight / 2), (int) Math.round((w0 + w1) / 2),
											(int) Math.round(h));
									e.gc.setBackground(new Color(null, 255, 0, 0));
									e.gc.fillOval((int) Math.round(dpoints[0] + 2),
											(int) Math.round(dpoints[1] - cheight / 2 + 2),
											(int) Math.round((w0 + w1) / 2 / 1.5), (int) Math.round(h / 1.5));
									e.gc.setBackground(new Color(null, 0, 0, 0));
								}

								if (charFlo < mazeData.getFlos()-1) {
									if ((mazeData.getValue((Position.mergePos(currentPlayerPos, Position.UP))) == 0)) {
										if (mazeData.getValue(new Position(charFlo, i, j)) == 0) {
											if ((i == currentPlayerPos.getRow())) {
												if ((j == currentPlayerPos.getCol())) {
													e.gc.drawImage(arrow, 0, 0, arrow.getBounds().width,
															arrow.getBounds().height, (int) (x + (2 * (w / 3))), y,
															(int) (w / 3), (int) (h / 3));
												}
											}

										}
									}
								}
								if (charFlo > 0) {
									if ((mazeData.getValue((Position.mergePos(currentPlayerPos, Position.DOWN))) == 0)){
										if (mazeData.getValue(new Position(charFlo, i, j)) == 0){
											if ((i == currentPlayerPos.getRow())){
												if ((j == currentPlayerPos.getCol())){
													e.gc.drawImage(arrow, 0, 0, arrow.getBounds().width, arrow.getBounds().height,
															(int) (x + (2 * (w / 3))), y, (int) (w / 3), (int) (h / 3));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});

	}

	public MazeWindow(Composite parent, int style) {
		super(parent, style);
		final Color white = new Color(null, 255, 255, 255);
		final Color black = new Color(null, 150, 150, 150);
		Device device = Display.getCurrent();
		image = new Image(device, ".\\Images\\SettingsWindow.jpg");
		setBackgroundImage(image);
		// setBackground(white);
		this.redraw();

	}

	private void paintCube(double[] p, double h, PaintEvent e) {
		int[] f = new int[p.length];
		for (int k = 0; k < f.length; f[k] = (int) Math.round(p[k]), k++)
			;

		e.gc.drawPolygon(f);

		int[] r = f.clone();
		for (int k = 1; k < r.length; r[k] = f[k] - (int) (h), k += 2)
			;

		int[] b = { r[0], r[1], r[2], r[3], f[2], f[3], f[0], f[1] };
		e.gc.drawPolygon(b);
		int[] fr = { r[6], r[7], r[4], r[5], f[4], f[5], f[6], f[7] };
		e.gc.drawPolygon(fr);

		e.gc.fillPolygon(r);

	}

	public void showHint(Position p) {
		moveCharacter(p.getFlo(), p.getRow(), p.getCol());
	}

	public void SolveMaze(Solution sol) {
		timerActive = true;
		timer = new Timer();
		task = new TimerTask() {
			int flo, row, col;
			int i = 0;

			@Override
			public void run() {
				if (i <= sol.getStates().size() - 1) {
					String str = sol.getStates().get(i).getCurrentState();
					flo = Integer.parseInt(Character.toString(str.charAt(1)));
					row = Integer.parseInt(Character.toString(str.charAt(3)));
					col = Integer.parseInt(Character.toString(str.charAt(5)));
					moveCharacter(flo, row, col);
					i++;
				} else {
					timerActive = false;
					task.cancel();
					timer.cancel();
				}
			}
		};
		if (timerActive) {
			timer.scheduleAtFixedRate(task, 0, (long) ((0.3) * 1000));
			timer.purge();
		}

	}

	private void moveCharacter(int flo, int row, int col) {
		if (flo >= 0 && flo < mazeData.getMaze3d().length && row >= 0 && row < mazeData.getMaze3d()[0].length
				&& col >= 0 && col < mazeData.getMaze3d()[0][0].length
				&& mazeData.getMaze3d()[flo][row][col] == Maze3d.FREE) {

			charRow = row;
			charCol = col;
			charFlo = flo;
			currentPlayerPos.setCol(col);
			currentPlayerPos.setRow(row);
			currentPlayerPos.setFlo(flo);
			getDisplay().syncExec(new Runnable() {

				@Override
				public void run() {
					redraw();
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.MazeDisplayer#moveUp()
	 */
	public void moveUp() {
		int row = charRow;
		int col = charCol;
		row = row - 1;
		moveCharacter(charFlo, row, col);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.MazeDisplayer#moveDown()
	 */
	public void moveDown() {
		int row = charRow;
		int col = charCol;
		row = row + 1;
		moveCharacter(charFlo, row, col);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.MazeDisplayer#moveLeft()
	 */
	public void moveLeft() {
		int row = charRow;
		int col = charCol;
		col = col - 1;
		moveCharacter(charFlo, row, col);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.MazeDisplayer#moveRight()
	 */
	public void moveRight() {
		int row = charRow;
		int col = charCol;
		col = col + 1;
		moveCharacter(charFlo, row, col);
	}

	public void setCharacterPosition(int row, int col) {
		charCol = col;
		charRow = row;
	}

	@Override
	public void moveFloUp() {
		moveCharacter(charFlo + 1, charRow, charCol);

	}

	@Override
	public void moveFloDown() {
		moveCharacter(charFlo - 1, charRow, charCol);

	}

}
