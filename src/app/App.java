
package app;
import controller.Controller;
import model.service.Service;
import ui.View;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class App {

	/**
	 * The {@link View} of the App
	 */
	private View view; 
	/**
	 * The {@link Service} of the App
	 */
	private Service service; 
	/**
	 * The {@link Controller} of the App
	 */
	private Controller controller; 
	
	/**
	 * Initialises the {@link View}, {@link Service} and {@link Controller}   
	 */
	public App(){
		view = new View();
		service = new Service(); 
		controller = new Controller(view, service); 
	}
}
