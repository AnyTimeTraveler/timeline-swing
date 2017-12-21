package uk.ac.cardiffmet.outlook.st20131039.ui;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class View implements Observer {

	/**
	 * The main frame
	 */
	private MainFrame mainFrame;

	/**
	 * Empty constructor
	 */
	public View() {
	}

	/**
	 * Display the frame and set Maximized on screen
	 */
	public void setVisible() {
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
	}

	/**
	 * Set events to {@link mainFrame} as JSON
	 * 
	 * @param timelineJson
	 *            events in JSON format
	 */
	public void setEvents(String timelineJson) {
		this.mainFrame.setEvents(timelineJson);
	}

	/**
	 * Set actors to {@link mainFrame} as Json
	 * 
	 * @param actorsJson
	 *            actors as Json
	 */
	public void setActors(String actorsJson) {
		this.mainFrame.setActors(actorsJson);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param importButtonActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener) {
		mainFrame.addImportButtonActionListener(importButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param addNewEventButtonActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener) {
		mainFrame.addAddNewEventButtonActionListener(addNewEventButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param saveNewEventActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener) {
		this.mainFrame.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param uploadFileActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener) {
		this.mainFrame.addUploadFileActionListener(uploadFileActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param downloadTimelineActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener) {
		this.mainFrame.addDownloadTimelineActionListener(downloadTimelineActionListener);
	}

	/**
	 * Change {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#workingPanel} to
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#newEventPanel} and repaint
	 */
	/**
	 * Change {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#workingPanel} to
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#newEventPanel} and repaint
	 * @param actors JSON of actors
	 */
	public void changeToAddNewEventPanel(String actors) {
		this.mainFrame.changeToAddNewEventPanel(actors);
		this.repaint();

	}

	/**
	 * Change {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#workingPanel} to
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.MainFrame#importPanel} and repaint
	 */
	public void changeToImportPanel() {
		this.mainFrame.changeToImportPanel();
		this.repaint();
	}

	/**
	 * Repaint the whole frame
	 */
	private void repaint() {
		this.mainFrame.getContentPane().validate();
		this.mainFrame.getContentPane().repaint();
	}

	@Override
	public void update(String eventsJson, String actorsJson) {
		this.setEvents(eventsJson);
		this.setActors(actorsJson);
		this.repaint();
	}

	/**
	 * Get Save new event data that is entered on the frame
	 * 
	 * @return {@link Map}&lt;{@link String};{@link String}&gt; key is field
	 *         name and value is field content
	 */
	public Map<String, String> getSaveNewEventData() {
		return mainFrame.getSaveNewEventData();

	}

	/**
	 * Add an {@link MouseListener} to the {@link MainFrame}
	 * 
	 * @param timelineEventMouseListener
	 *            The Mouse Listener for the {@link MainFrame}
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener) {
		this.mainFrame.addTimelineEventActionListener(timelineEventMouseListener);
	}

/**
 * Set events details in one specific year
 * @param eventsOfSpecificYear the year to set the details
 * @param actorsJson actors in JSON format
 */
	public void setEventDetails(String eventsOfSpecificYear, String actorsJson) {
		this.mainFrame.setEventDetails(eventsOfSpecificYear, actorsJson);
		this.repaint();
	}

	/**
	 * Get year by coordinates on the mainFrame
	 * 
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate
	 * @return int year
	 */
	public int getEventYearByCoordinates(int x, int y) {
		return this.mainFrame.getEventYearByCoordinates(x, y);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param addActorButtonActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addAddActorButtonActionListener(ActionListener addActorButtonActionListener) {
		this.mainFrame.addAddActorButtonActionListener(addActorButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * 
	 * @param saveActorButtonActionListener
	 *            The Action Listener for the {@link mainFrame}
	 */
	public void addSaveActorButtonActionListener(ActionListener saveActorButtonActionListener) {
		this.mainFrame.addSaveActorButtonActionListener(saveActorButtonActionListener);
	}

	/**
	 * Change working panel to newActorPanel
	 * @param actors JSON of actors
	 */
	public void changeToAddNewActorPanel(String actors) {
		this.mainFrame.changeToAddNewActorPanel(actors);
		this.repaint();
	}

	/**
	 * Set initial data and initialise MainFrame
	 * 
	 * @param events
	 *            Json String of events
	 * @param actors
	 *            Json String of actors
	 */
	public void setData(String events, String actors) {
		mainFrame = new MainFrame(events, actors);
	}

	/**
	 * Initialise components on {@link MainFrame}
	 */
	public void init() {
		this.mainFrame.init();
	}

	/**
	 * Get data entered on {@link NewActorPanel}
	 * 
	 * @return String Json of new Actorsss
	 */
	public String getActorData() {
		return this.mainFrame.getNewActorData();
	}

	/**
	 * Clear all fields on New EventPanel
	 */
	public void clearNewEventFields() {
		this.mainFrame.clearNewEventFields();
	}

}
