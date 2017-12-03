import controller.Controller;
import model.service.EventService;
import ui.View;

public class App {

	public App(){
		System.out.println("App: constructor");
	}
	
	public void run(){
		System.out.println("App: run");
		String repositoryType = "memory";
		EventService eventService = new EventService(repositoryType); 
		View view = new View();
		eventService.register(view);
		Controller controller = new Controller(eventService, view); 
	}
}
