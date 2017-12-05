
package app;
import controller.Controller;
import model.service.Service;
import ui.View;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class App {

	private Controller controller; 
	
	/**
	 * Initialises the {@link View}, {@link Service} and {@link Controller}   
	 */
	public App(){
		controller = new Controller(); 
	}
}
