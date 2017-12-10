
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
	 * The {@link View} of the app
	 */
	private View view;
	/**
	 * The {@link Service} of the app
	 */
	private Service service; 
	
	
	private Controller controller; 
	
	/**
	 * Initialises the {@link View}, {@link Service} and {@link Controller}   
	 */
	public App(){
		this.service = Service.getInstance(); 
		this.view = new View(); 
		controller = new Controller(view, service); 
	}
}
