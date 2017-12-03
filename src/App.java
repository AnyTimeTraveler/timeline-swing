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
		Controller controller = new Controller(repositoryType); 
	}
}
