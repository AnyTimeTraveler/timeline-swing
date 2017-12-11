package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class UploadTimelineActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public UploadTimelineActionListener(Controller controller){
		this.controller = controller; 
	}
	
	/**
	 * Upload the Json through the controller
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventsInJsonFormat = ""; 
		final JFileChooser fc = new JFileChooser();
		        int returnVal = fc.showOpenDialog((Component)e.getSource());
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
		                StringBuilder sb = new StringBuilder();
		                String line = br.readLine();

		                while (line != null) {
		                    sb.append(line);
		                    sb.append(System.lineSeparator());
		                    line = br.readLine();
		                }
		                eventsInJsonFormat = sb.toString();
		            } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
		         } 
		        
		        //Split file on "&" sign. This can be improved in the future by storing the full Data as JSON
		        String[] splitted = eventsInJsonFormat.split("&"); 
		        controller.addEvents(splitted[0]);           
		        controller.addActors(splitted[1]); 
		        }
	}
	
	
