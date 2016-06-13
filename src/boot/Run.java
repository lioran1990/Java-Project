package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import GUI.GameView;
import View.MyView;
import model.MyModel;
import presenter.Presenter;

public class Run {

	public static void main(String[] args) {
		
		MyModel model = new MyModel();
		//MyView view = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		GameView gv = new GameView();	
/*
		try {
			view = new MyView(reader, writer);
			view.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	
		Presenter presenter = new Presenter(model, gv,2);
		//view.addObserver(presenter);
		model.addObserver(presenter);  	
		gv.addObserver(presenter);
		new Thread(gv).start();
		
	}

}
