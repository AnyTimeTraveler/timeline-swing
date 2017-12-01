import controller.Controller;
import ui.View;

public class App {

	public App(){
		System.out.println("App: constructor");
	}
	
	public void run(){
		System.out.println("App: run");
		Controller controller = new Controller(); 
	}
}
