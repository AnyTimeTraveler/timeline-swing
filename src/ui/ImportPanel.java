package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ImportPanel extends JPanel {

	private JButton uploadButton; 
	
	public ImportPanel(){ 
		this.setBackground(Color.BLACK);
		uploadButton = new JButton("upload file"); 
		//button.addActionListener(new ImportCSVFileEventListener(this));
		this.add(uploadButton);
		
		
	}
	
	public void addUploadFileButtonActionListener(ActionListener uploadFileButtonActionListener){
		this.uploadButton.addActionListener(uploadFileButtonActionListener);
	}
	
	
}
