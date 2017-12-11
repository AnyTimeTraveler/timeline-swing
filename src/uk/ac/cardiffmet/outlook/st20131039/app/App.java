
package uk.ac.cardiffmet.outlook.st20131039.app;
import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;
import uk.ac.cardiffmet.outlook.st20131039.model.service.Service;
import uk.ac.cardiffmet.outlook.st20131039.ui.View;
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
		this.service = Service.getInstance(); 
		this.view = new View(); 
		controller = new Controller(view, service); 
	}
}
