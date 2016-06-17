package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import GUI.MyGUIView;
import View.MyView;
import model.MyModel;
import presenter.Presenter;

public class Run {

	public static void main(String[] args) {
		
		MyModel model = new MyModel(2);
		MyView view = null;
		MyGUIView mgv = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		try {
			//view = new MyView(reader, writer);
			mgv = new MyGUIView(reader, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Presenter presenter = new Presenter(model, mgv,2);
		mgv.addObserver(presenter);
		//view.addObserver(presenter);
		model.addObserver(presenter);
		
		
		try {
		//	view.start();
			mgv.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
