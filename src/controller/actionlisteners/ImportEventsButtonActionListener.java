package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.MainFrame;

public class ImportEventsButtonActionListener implements ActionListener {

	private MainFrame frame; 
	
	public ImportEventsButtonActionListener(MainFrame frame){
		this.frame = frame; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.changeToImportPanel();
	}

}
