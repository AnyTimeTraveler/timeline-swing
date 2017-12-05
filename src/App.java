import controller.Controller;
import model.service.Service;
import ui.View;

public class App {

	public App(){
		View view = new View();
		Service service = new Service(); 
		Controller controller = new Controller(view, service); 
	}
}
