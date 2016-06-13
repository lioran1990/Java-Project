package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class Board extends Composite {

	int [][] data;
	int N;
	
	public Board(Composite parent, int style) {
		super(parent,style);
		N=4;
		data = new int [N][N];
		setLayoutData(new GridLayout(N,true));
		
		Tile tiles [][] = new Tile [N][N];
		
		data[0][0] = 2048;
		data[0][1] = 150;
		data[0][2] = 150;
		data[0][3] = 150;
		data[1][0] = 2048;
		data[1][1] = 150;
		data[1][2] = 150;
		data[1][3] = 150;
		data[2][0] = 2048;
		data[2][1] = 150;
		data[2][2] = 150;
		data[2][3] = 150;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tiles [i][j] = new Tile (this,SWT.BORDER);
				tiles [i][j].setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
				tiles [i][j].setValue(data[i][j]);
			}
		}
	}

}
