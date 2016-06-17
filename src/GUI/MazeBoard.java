package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerator.Maze3d;

public class MazeBoard extends Canvas {

	Maze3d mazeData = null;
	public int charRow=0;
	public int charCol=2;
	public int charFlo=0;
	public int exitX=0;
	public int exitY=2;
	public int exitZ=0;
	
	public void setMazeData (Maze3d maze){
		mazeData = maze;
		setCharacterPosition(mazeData.getStartPosition().getRow(), mazeData.getStartPosition().getCol());
		charFlo = mazeData.getStartPosition().getFlo();
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				   e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));

				   int width=getSize().x;
				   int height=getSize().y;
				   
				   int mx=width/2;

				   double w=(double)width/mazeData.getMaze3d()[0][0].length;
				   double h=(double)height/mazeData.getMaze3d()[0].length;

				   for(int i=0;i<mazeData.getMaze3d()[0].length;i++){
					   double w0=0.7*w +0.3*w*i/mazeData.getMaze3d()[0].length;
					   double w1=0.7*w +0.3*w*(i+1)/mazeData.getMaze3d()[0].length;
					   double start=mx-w0*mazeData.getMaze3d()[0][i].length/2;
					   double start1=mx-w1*mazeData.getMaze3d()[0][i].length/2;
				      for(int j=0;j<mazeData.getMaze3d()[0][i].length;j++){
				          double []dpoints={start+j*w0,i*h,start+j*w0+w0,i*h,start1+j*w1+w1,i*h+h,start1+j*w1,i*h+h};
				          double cheight=h/2;
				          if(mazeData.getMaze3d()[charRow][i][j]!=0)
				        	  paintCube(dpoints, cheight,e);
				          
				          if(i==charCol && j==charRow){
							   e.gc.setBackground(new Color(null,200,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
							   e.gc.setBackground(new Color(null,255,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]+2), (int)Math.round(dpoints[1]-cheight/2+2), (int)Math.round((w0+w1)/2/1.5), (int)Math.round(h/1.5));
							   e.gc.setBackground(new Color(null,0,0,0));				        	  
				          }
				      }
				   }
				   
				   /*
				   double w=(double)width/mazeData[0].length;
				   double h=(double)height/mazeData.length;

				   for(int i=0;i<mazeData.length;i++){
					   double w0=0.7*w +0.3*w*i/mazeData.length;
					   double w1=0.7*w +0.3*w*(i+1)/mazeData.length;
					   double start=mx-w0*mazeData[i].length/2;
					   double start1=mx-w1*mazeData[i].length/2;
				      for(int j=0;j<mazeData[i].length;j++){
				          double []dpoints={start+j*w0,i*h,start+j*w0+w0,i*h,start1+j*w1+w1,i*h+h,start1+j*w1,i*h+h};
				          double cheight=h/2;
				          if(mazeData[i][j]!=0)
				        	  paintCube(dpoints, cheight,e);
				          
				          if(i==characterY && j==characterX){
							   e.gc.setBackground(new Color(null,200,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]), (int)Math.round(dpoints[1]-cheight/2), (int)Math.round((w0+w1)/2), (int)Math.round(h));
							   e.gc.setBackground(new Color(null,255,0,0));
							   e.gc.fillOval((int)Math.round(dpoints[0]+2), (int)Math.round(dpoints[1]-cheight/2+2), (int)Math.round((w0+w1)/2/1.5), (int)Math.round(h/1.5));
							   e.gc.setBackground(new Color(null,0,0,0));				        	  
				          }
				      }
				   }
				   */
				
			}
		});	
		
		   KeyListener kl = new KeyListener() {
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					switch (e.keyCode){
						case SWT.ARROW_DOWN:
							break;
						case SWT.ARROW_UP:
							break;
						case SWT.ARROW_LEFT:
							break;
						case SWT.ARROW_RIGHT:
							break;
						case SWT.PAGE_DOWN:
							break;
						case SWT.PAGE_UP:
							break;
					}
					
				}
			};
		
	}
	
	public MazeBoard(Composite parent, int style ) {
		super(parent, style);	
		final Color white=new Color(null, 255, 255, 255);
		final Color black=new Color(null, 150,150,150);
		setBackground(white);
		this.redraw();
		
	
		/*
		 
	 	addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				   e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));

				   int width=getSize().x;
				   int height=getSize().y;

				   int w=width/mazeData[0].length;
				   int h=height/mazeData.length;

				   for(int i=0;i<mazeData.length;i++)
				      for(int j=0;j<mazeData[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeData[i][j]!=0)
				              e.gc.fillRectangle(x,y,w,h);
				      }
				}
		});
	 
	 
	 */
		
	}
	
	
	private void paintCube(double[] p,double h,PaintEvent e){
        int[] f=new int[p.length];
        for(int k=0;k<f.length;f[k]=(int)Math.round(p[k]),k++);
        
        e.gc.drawPolygon(f);
        
        int[] r=f.clone();
        for(int k=1;k<r.length;r[k]=f[k]-(int)(h),k+=2);
        

        int[] b={r[0],r[1],r[2],r[3],f[2],f[3],f[0],f[1]};
        e.gc.drawPolygon(b);
        int[] fr={r[6],r[7],r[4],r[5],f[4],f[5],f[6],f[7]};
        e.gc.drawPolygon(fr);
        
        e.gc.fillPolygon(r);
		
	}

	

	
	
	private void moveCharacter(int x,int y , int z){
		if(x>=0 && x<mazeData.getMaze3d().length && y>=0 && y<mazeData.getMaze3d()[0].length && mazeData.getMaze3d()[x][y][z]==Maze3d.FREE && z<mazeData.getMaze3d()[0][0].length){
			charRow=x;
			charCol=y;
			charFlo=z;
			getDisplay().syncExec(new Runnable() {
				
				@Override
				public void run() {
					redraw();
				}
			});
		}
	}
	
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveUp()
	 */
	public void moveUp() {
		int x=charRow;
		int y=charCol;
		y=y-1;
	//	moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveDown()
	 */
	public void moveDown() {
		int x=charRow;
		int y=charCol;
		y=y+1;
	//	moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveLeft()
	 */
	public void moveLeft() {
		int x=charRow;
		int y=charCol;
		x=x-1;
	//	moveCharacter(x, y);
	}
	/* (non-Javadoc)
	 * @see view.MazeDisplayer#moveRight()
	 */
	public void moveRight() {
		int x=charRow;
		int y=charCol;
		x=x+1;
	//	moveCharacter(x, y);
	}
	
	public void setCharacterPosition(int row, int col) {
		charCol=col;
		charRow=row;
	//	moveCharacter(col,row);
	}

	

}
