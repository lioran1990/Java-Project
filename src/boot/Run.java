package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import View.MyView;
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Presenter presenter = new Presenter(model, view);
		view.addObserver(presenter);
		model.addObserver(presenter); 
	}

}
