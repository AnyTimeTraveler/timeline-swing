package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.datasets.timeline.Event;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class MainFrame extends JFrame {
	/**
	 * Panel that displays the timeline
	 */
	private TimelinePanel timelinePanel;
	/**
	 * Scroll panel in which the timeline is shown
	 */
	private JScrollPane scrollPane; 
	/**
	 * Default color for whole frame
	 */
	private Color defaultColor;
	/**
	 * Custom orange color
	 */
	private Color orange = new Color(240, 129, 15);
	/**
	 * Panel where user works on, adds events, displays event info, uploads and
	 * exports timelines
	 */
	private JPanel workingPanel;
	/**
	 * Panel that displays the form to add a new event
	 */
	private NewEventPanel newEventPanel;
	/**
	 * Panel to import a new File
	 */
	private ImportPanel importPanel;
	/**
	 * Panel that contains the selection buttons
	 */
	private ButtonPanel buttonPanel;
	/**
	 * Label with welcome text
	 */
	private JLabel welcomeLabel;
	/**
	 * Panel that contains event details when an event is clicked
	 */
	private EventDetailsPanel eventDetailsPanel;
	/**
	 * Dimensions of the screen
	 */
	private Dimension screenDim;
	/**
	 * Dimensions of the application
	 */
	private Dimension frameDim;

	/**
	 * Initialise config settings and {@link setLayoutContent}
	 */
	public MainFrame() {
		super();
		// Title of application/frame
		this.setTitle("Timeline Jeroen Vandevenne");

		// Default background color
		this.defaultColor = Color.WHITE;

		// Set initial content
		setLayoutContent();
	}

	private void setLayoutContent() {

		// Close Application properly
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Set Screen dimension
		this.setScreenDim();

		// Set Frame dimension equal to screen dimension = fullscreen
		this.setFrameDim(this.screenDim);

		// Set Size of Frame
		this.setSize(frameDim);
		this.setPreferredSize(frameDim);

		// Center Frame on screen
		this.setLocation(screenDim.width / 2 - this.getSize().width / 2,
				screenDim.height / 2 - this.getSize().height / 2);

		// Initiate Components of the frame
		this.timelinePanel = new TimelinePanel(frameDim.width, (int) (frameDim.height * 0.57));
		this.buttonPanel = new ButtonPanel();
		this.newEventPanel = new NewEventPanel();
		this.newEventPanel.setBackground(this.orange);
		this.importPanel = new ImportPanel();
		this.newEventPanel.setBackground(this.orange);
		this.welcomeLabel = new JLabel();

		// Assign newEventPanel to workingpanel on init
		this.workingPanel = this.newEventPanel;

		// Initiate Flexible GridBagLayout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		// Add init text to welcomeLabel
		this.setWelcomeLabelText(
				"The events are sorted per year. Click on a box to see more details regarding that year.");
		GridBagConstraints welcomeLabelGbc = getWelcomeLabelGridBagConstraints();
		this.getContentPane().add(welcomeLabel, welcomeLabelGbc);

		// Set scrollable timeline panel
		this.timelinePanel.setBackground(this.defaultColor);
		this.timelinePanel.setBackground(Color.white);
		scrollPane = new JScrollPane(this.timelinePanel);
		GridBagConstraints timeLineScrollPaneGbc = this.getTimelineScrollPanelGridBagConstraints();
		this.getContentPane().add(scrollPane, timeLineScrollPaneGbc);

		// Add buttonpanel to frame
		GridBagConstraints buttonPanelGbc = this.getButtonPanelGridBagConstraints();
		this.getContentPane().add(buttonPanel, buttonPanelGbc);

		// Add workingpanel to frame
		GridBagConstraints workingPanelGbc = getWorkingPanelGridBagConstraints();
		this.getContentPane().add(workingPanel, workingPanelGbc);
	}

	/**
	 * Generates the {@link java.awt.GridBagConstraints} for the {@link workingPanel}
	 * @return {@link java.awt.GridBagConstraints} For the {@link workingPanel}
	 */
	private GridBagConstraints getWorkingPanelGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 0.19;
		gbc.weightx = 0.9;
		return gbc;
	}

	/**
	 * Generates the {@link java.awt.GridBagConstraints} for the {@link buttonPanel}
	 * @return {@link java.awt.GridBagConstraints} For the {@link buttonPanel}
	 */
	private GridBagConstraints getButtonPanelGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.19;
		gbc.weightx = 0.1;
		gbc.gridwidth = 1;
		return gbc;
	}

	/**
	 * Generates the {@link java.awt.GridBagConstraints} for the {@link scrollPane}
	 * @return {@link java.awt.GridBagConstraints} For the {@link scrollPane}
	 */
	private GridBagConstraints getTimelineScrollPanelGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		Dimension timelineDim = timelinePanel.getPreferredSize();
		gbc.weighty = (double) timelineDim.height / frameDim.height;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		return gbc;
	}

	/**
	 * Generates the {@link java.awt.GridBagConstraints} for the welcomeLabel
	 * @return {@link java.awt.GridBagConstraints} For the welcomeLabel
	 */
	private GridBagConstraints getWelcomeLabelGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		Dimension timelineDim = timelinePanel.getPreferredSize();
		gbc.weighty = 0.60 - (double) timelineDim.height / frameDim.height;
		gbc.gridwidth = 2;
		return gbc;
	}

	/**
	 * Set text on {@link welcomeLabel}
	 * @param text The text displayed on the welcomeLabel
	 */
	private void setWelcomeLabelText(String text) {
		this.welcomeLabel.setText(text);
	}

	/**
	 * Assign the current screen dimensions to {@link screenDim}
	 */
	private void setScreenDim() {
		this.screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	}

	/**
	 * Set a new dimension to the {@link frameDim}
	 * @param dim Dimension new Dimension to assign to {@link frameDim}
	 */
	private void setFrameDim(Dimension dim) {
		this.frameDim = dim;
	}

	/**
	 * Set new {@link List}&lt;{@link ui.datasets.timeline.Event}&gt;
	 * @param events {@link List}&lt;{@link ui.datasets.timeline.Event}&gt; to set
	 */
	public void setEvents(List<Event> events) {
		this.timelinePanel.setEvents(events);
	}

	/**
	 * Change the {@link workingPanel} to {@link importPanel}
	 */
	public void changeToImportPanel() {
		GridBagConstraints gbc = this.getWorkingPanelGridBagConstraints();
		// Remove current panel
		this.getContentPane().remove(this.workingPanel);
		// Assign new panel as workingPanel
		this.workingPanel = this.importPanel;
		// add new panel to frame
		this.getContentPane().add(workingPanel, gbc);
	}

	/**
	 * Change the {@link workingPanel} to {@link newEventPanel}
	 */
	public void changeToAddNewEventPanel() {
		GridBagConstraints gbc = this.getWorkingPanelGridBagConstraints();
		// Remove current panel
		this.getContentPane().remove(this.workingPanel);
		// Assign new panel as workingPanel
		this.workingPanel = this.newEventPanel;
		// add new panel to frame
		this.getContentPane().add(workingPanel, gbc);
	}

	/**
	 * Add an {@link ActionListener} to the {@link buttonPanel}
	 * @param importButtonActionListener The Action Listener for the {@link buttonPanel}
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener) {
		this.buttonPanel.addImportButtonActionListener(importButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link buttonPanel}
	 * @param addNewEventButtonActionListener The Action Listener for the {@link buttonPanel}
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener) {
		this.buttonPanel.addAddNewEventButtonActionListener(addNewEventButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link newEventPanel}
	 * @param saveNewEventActionListener The Action Listener for the {@link newEventPanel}
	 */
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener) {
		this.newEventPanel.addSaveButtonActionListener(saveNewEventActionListener);
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link newEventPanel}
	 * @param downloadTimelineActionListener The Action Listener for the {@link newEventPanel}
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener) {
		this.importPanel.addDownloadTimelineActionListener(downloadTimelineActionListener);
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link newEventPanel}
	 * @param uploadFileActionListener The Action Listener for the {@link newEventPanel}
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener) {
		this.importPanel.addUploadFileActionListener(uploadFileActionListener);
	}


	/**
	 * Get the data that the user has inputed on the {@link newEventPanel}
	 * @return {@link Map}&lt;{@link String},{@link String}&gt;
	 */
	public Map<String, String> getSaveNewEventData() {
		return this.newEventPanel.getSaveNewEventData();
	}

	/**
	 * Add an {@link MouseListener} to the {@link timelinePanel}
	 * @param timelineEventMouseListener The Mouse Listener for the {@link timelinePanel}
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener) {
		this.timelinePanel.addTimelineEventActionListener(timelineEventMouseListener);
	}

	/**
	 * Change working panel to {@link EventDetailsPanel} according to clicked coordinates
	 * @param x Clicked x value
	 * @param y Clicked y value
	 */
	public void setEventDetailsPanelByCoordinates(int x, int y) {
		List<Event> eventsInSpecificYear = this.timelinePanel.getEventYearByCoordinates(x, y);
		if (eventsInSpecificYear != null) {
			GridBagConstraints gbc = this.getWorkingPanelGridBagConstraints();
			// Remove current panel
			this.getContentPane().remove(this.workingPanel);
			// Assing new panel as workingPanel
			this.eventDetailsPanel = new EventDetailsPanel(eventsInSpecificYear);
			this.workingPanel = this.eventDetailsPanel;
			// add New panel to frame
			this.getContentPane().add(workingPanel, gbc);
		}
	}

	/**
	 * Color a rectangle according to clicked coordinated
	 */
	public void colorRectangleWithcoordinates() {
		this.timelinePanel.colorRectangleWithcoordinates();
	}
}
