package View;

import org.eclipse.swt.widgets.Composite;

public class MazeBoard extends Composite {

	int [][] data;
	int N;
	
	public MazeBoard(Composite parent, int style) {
		super(parent, style);
		
	}
	
	public void setData (int [][] d){
		this.data = d; 
	}

}
