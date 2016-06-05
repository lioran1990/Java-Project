package controller;

import View.View;
import model.Model;
/**<h1>Controller</h1>
 * The Controller Interface.
 * Controller is the engine behind the MVC design pattern.
 * Actually it acts as broker between View and Model.
 * Each class which implements this interface must override setView and setModel methods.
 * @author Lior Ran and Omri Haviv
 * @version 1.0
 * @since May 21,2016
 */
public interface Controller {

	public void setView(View v);
	public void setModel (Model m);
}
