package GUI;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Tile extends Canvas {

	private int value;
	
	public Tile(Composite parent, int style) {
		super(parent, style);
		
		value = 0;
		
		Font f = getFont();
		Font nf = new Font(getDisplay(), f.getFontData()[0].getName() , 16 ,SWT.BOLD);
		setFont(nf);
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				FontMetrics fm = e.gc.getFontMetrics();
				int width = fm.getAverageCharWidth();
				int mx = getSize().x/2 - (""+value).length() * width/2;
				int my = getSize().y/2 - fm.getHeight()/2 * fm.getDescent();
				if (value >0){
					e.gc.drawString(""+value, mx, my);
				}
				
			}
		});
	}

	public void setValue (int value){
		this.value = value;
		changeBackGroundColor();
		this.redraw();
		redraw();
	}
	
	private void changeBackGroundColor (){
		if (value == 0){
			setBackground(getDisplay().getSystemColor(SWT.COLOR_BLUE));
		}
		else{
			setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		}
		
			
	}
	
}
