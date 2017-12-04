import controller.Controller;
import model.service.EventService;
import ui.View;

public class App {

	public App(){
	}
	
	public void run(){
		View view = new View();
		EventService eventService = new EventService(); 
		Controller controller = new Controller(view, eventService); 
	}
}
