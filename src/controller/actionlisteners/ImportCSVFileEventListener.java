package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.service.EventService;
import ui.View;

public class ImportCSVFileEventListener implements ActionListener{

	private View view; 
	private EventService eventService; 
	
	public ImportCSVFileEventListener(View view, EventService eventService){
		this.view = view; 
		this.eventService = eventService; 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	/*	final JFileChooser fc = new JFileChooser();
		 int returnVal = fc.showOpenDialog(panel);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            //This is where a real application would open the file.
	            System.out.println("Opening: " + file.getName());
	        } else {
	            System.out.println("Open command cancelled by user");
	        }*/
	}
	
	
	
	
	
	
}
