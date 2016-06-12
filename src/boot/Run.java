package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import View.MyView;
import XML.xmlbuilder;
import model.MyModel;
import presenter.Presenter;

public class Run {

	public static void main(String[] args) {
		
		MyModel model = new MyModel();
		MyView view = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		try {
			view = new MyView(reader, writer);
			view.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Presenter presenter = new Presenter(model, view,2);
		view.addObserver(presenter);
		model.addObserver(presenter);  
		
		xmlbuilder xml = new xmlbuilder();
	}

}
