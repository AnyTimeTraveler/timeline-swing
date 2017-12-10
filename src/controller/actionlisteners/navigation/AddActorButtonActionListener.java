package controller.actionlisteners.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class AddActorButtonActionListener  implements ActionListener{

	private Controller controller; 
	
	public AddActorButtonActionListener(Controller controller){
		this.controller = controller; 
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("AddActorButtonActionListener");
		controller.changeToAddNewActorPanel();
	}

	
	
}
