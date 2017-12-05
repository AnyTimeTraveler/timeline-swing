package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ImportPanel extends JPanel {

	/**
	 * Button to upload a file
	 */
	private JButton uploadButton; 
	
	/**
	 * Initialise {@link uploadButton} and set config setting
	 */
	public ImportPanel(){ 
		this.setBackground(Color.BLACK);
		uploadButton = new JButton("upload file"); 
		//button.addActionListener(new ImportCSVFileEventListener(this));
		this.add(uploadButton);
		
		
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link uploadButton}
	 * @param uploadFileButtonActionListener The Action Listener for the {@link uploadButton}
	 */
	public void addUploadFileButtonActionListener(ActionListener uploadFileButtonActionListener){
		this.uploadButton.addActionListener(uploadFileButtonActionListener);
	}
	
	
}
