package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Jeroen Vandevenne
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
	 * Initialise {@link uploadButton} and {@link downloadButton} and add
	 * components
	 */
	public ImportPanel() {
		// Instantiate components
		uploadButton = new JButton("Upload timeline");
		downloadButton = new JButton("Download timeline");

		// Set layout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		// Define constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 1;
		gbc.weightx = 1;

		// Style components
		uploadButton.setPreferredSize(new Dimension(150, 50));
		uploadButton.setBackground(Color.white);
		downloadButton.setPreferredSize(new Dimension(150, 50));
		downloadButton.setBackground(Color.white);

		// Add components
		this.add(uploadButton, gbc);
		this.add(downloadButton, gbc);
	}

	/**
	 * Add an {@link ActionListener} to the {@link uploadButton}
	 * 
	 * @param uploadFileActionListener
	 *            The Action Listener for the {@link uploadButton}
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener) {
		this.uploadButton.addActionListener(uploadFileActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link downloadButton}
	 * 
	 * @param downloadTimelineActionListener
	 *            The Action Listener for the {@link downloadButton}
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener) {
		this.downloadButton.addActionListener(downloadTimelineActionListener);
	}
}
