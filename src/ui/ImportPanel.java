package ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ImportPanel extends JPanel {

	/**
	 * Button to upload a timeline file in JSON format
	 */
	private JButton uploadButton; 
	/**
	 * Button to download timeline file in JSON format
	 */
	private JButton downloadButton;
	
	/**
	 * Initialise {@link uploadButton} and set config setting
	 */
	public ImportPanel(){ 
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.anchor = GridBagConstraints.NORTH;
	    gbc.weighty = 1;
		uploadButton = new JButton("Upload timeline"); 
		this.add(uploadButton, gbc);
		downloadButton = new JButton("Download timeline"); 
		this.add(downloadButton, gbc); 
	}

	/**
	 * Add an {@link ActionListener} to the {@link uploadButton}
	 * @param uploadFileActionListener The Action Listener for the {@link uploadButton}
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener){
		this.uploadButton.addActionListener(uploadFileActionListener); 
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link uploadButton}
	 * @param uploadFileActionListener The Action Listener for the {@link uploadButton}
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener){
		this.downloadButton.addActionListener(downloadTimelineActionListener); 
	}
	
}
