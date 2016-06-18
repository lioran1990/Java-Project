package boot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import GUI.MyGUIView;
import View.MyView;
import model.MyModel;
import presenter.Presenter;
import presenter.Properties;
import presenter.PropertiesHandler;

public class Run {

	public static void main(String[] args) {
		
		MyModel model = null;
		MyView view = null;
		MyGUIView mgv = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		Properties properties = null;
		
		try {
			properties = PropertiesHandler.getInstance();
		} catch (FileNotFoundException e2) {
			System.out.println("Could not find properties file, using default set");
			properties = new Properties();
			try {
				PropertiesHandler.write(properties, ".\\xml\\properties.xml");
			} catch (Exception e) {
				System.out.println("Could not save default properties file, please check manually");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
		model = new MyModel(properties.getMaxNumOfThreads());
		
		switch (properties.getRuntimeEnv()) {
		case 0:
			try {
				mgv = new MyGUIView(reader, writer);
				Presenter presenter = new Presenter(model, mgv,2,properties);
				mgv.addObserver(presenter);
				model.addObserver(presenter);
				mgv.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 1:
			try {
				view = new MyView(reader, writer);
				Presenter presenter = new Presenter(model, view,2,properties);
				view.addObserver(presenter);
				model.addObserver(presenter);
				view.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		}
	}
}