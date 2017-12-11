package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;

public class DownloadTimelineActionListener implements ActionListener {


	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public DownloadTimelineActionListener(Controller controller){
		this.controller = controller; 
	}

	/**
	 * Download the Json through the controller
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 JFileChooser fileChooser = new JFileChooser();
		    int returnVal = fileChooser.showSaveDialog((Component) arg0.getSource());
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		      this.controller.saveTimeline(fileChooser.getSelectedFile().getAbsolutePath());
		    }
	}
}
