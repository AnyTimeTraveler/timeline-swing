package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.MainFrame;

public class AddEventButtonActionListener implements ActionListener {

	private MainFrame frame; 
	
	public AddEventButtonActionListener(MainFrame frame){
		this.frame = frame; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.changeToAddNewEventPanel();
	}

}
