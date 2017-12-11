
package uk.ac.cardiffmet.outlook.st20131039.controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;

import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.navigation.AddActorButtonActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.navigation.AddEventButtonActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.navigation.ImportEventsButtonActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel.DownloadTimelineActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel.SaveNewActorActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel.SaveNewEventActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel.UploadTimelineActionListener;
import uk.ac.cardiffmet.outlook.st20131039.controller.mouselisteners.TimelineEventMouseListener;
import uk.ac.cardiffmet.outlook.st20131039.model.service.Service;
import uk.ac.cardiffmet.outlook.st20131039.ui.View;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class Controller {

	/**
	 * The {@link View} of the App
	 */
	private View view;
	/**
	 * The {@link Service} of the App
	 */
	private Service service;

	/**
	 * Assigns the {@link View} and {@link Service} parameters to the variables
	 * 
	 * @param view
	 *            The view of the App
	 * @param service
	 *            The Service of the App
	 */
	public Controller(View view, Service service) {
		this.service = service;

		// Set sample data in service
		this.addActors(
				"[{\"name\":\"Jane\",\"id\":\"1\"},{\"name\":\"Dave\",\"id\":\"2\"},{\"name\":\"Bob\",\"id\":\"3\"}]");
		this.addEvents(
				"{\"1941\":[{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Graduated\",\"description\":\"This the description about graduation\",\"id\":\"08cb049f-1482-467d-8651-d097f54d56a8\",\"startDate\":\"Feb 25, 1941 1:05:42 AM\",\"EndDate\":\"Nov 26, 1947 8:01:54 AM\",\"actorsInvolvementDescription\":\"Student\"}],\"1973\":[{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Profit doubles\",\"description\":\"This description about profit\",\"id\":\"7b3cf744-ca48-490f-896f-de028414cd1d\",\"startDate\":\"Sep 24, 1973 8:33:47 AM\",\"EndDate\":\"Dec 19, 1968 11:00:45 AM\",\"actorsInvolvementDescription\":\"Leader\"}],\"1998\":[{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Crowned Kind\",\"description\":\"This is the description about the crowning of the King\",\"id\":\"26e88843-a444-489b-a0b2-f212454c1738\",\"startDate\":\"Mar 3, 1998 4:53:00 PM\",\"EndDate\":\"Sep 16, 1951 8:18:05 PM\",\"actorsInvolvementDescription\":\"King\"}],\"2004\":[{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Fired Employee\",\"description\":\"The description about the fired employee\",\"id\":\"6f69d57a-5a66-4fe4-a726-f2d8e6ef3786\",\"startDate\":\"Jun 20, 2004 3:56:09 PM\",\"EndDate\":\"Dec 9, 1966 12:06:22 AM\",\"actorsInvolvementDescription\":\"Boss\"}],\"2006\":[{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Famous war\",\"description\":\"This the description about the war\",\"id\":\"66d3f712-8912-4654-9422-1e6f5b70d0d8\",\"startDate\":\"Dec 15, 2006 7:52:00 PM\",\"EndDate\":\"Feb 10, 1996 10:58:45 AM\",\"actorsInvolvementDescription\":\"Soldier\"},{\"actorsIds\":[\"1\",\"2\",\"3\"],\"title\":\"Release computer\",\"description\":\"This is the description about the release\",\"id\":\"21d74cc2-7d8d-4186-8df1-05d62f6f7a36\",\"startDate\":\"Dec 15, 2006 7:52:00 PM\",\"EndDate\":\"Apr 17, 1949 7:23:29 AM\",\"actorsInvolvementDescription\":\"First company to release\"}]}");

		this.view = view;
		service.register(view);

		// Send initial data from model into view
		this.view.setData(this.service.getAllEvents(), this.service.getAllActors());
		this.init();

		// Initialize actionlisteners on view
		this.addImportButtonActionListener(new ImportEventsButtonActionListener(this));
		this.addAddNewEventButtonActionListener(new AddEventButtonActionListener(this));
		this.addTimelineEventActionListener(new TimelineEventMouseListener(this));
		this.addUploadFileActionListener(new UploadTimelineActionListener(this));
		this.addDownloadTimelineActionListener(new DownloadTimelineActionListener(this));
		this.addAddActorButtonActionListener(new AddActorButtonActionListener(this));
		this.addSaveActorButtonActionListener(new SaveNewActorActionListener(this));
		this.addSaveNewEventButtonActionListener(new SaveNewEventActionListener(this));

		// Display UI
		this.view.setVisible();
	}

	/**
	 * Sends inital data to {@link View}
	 */
	public void init() {
		this.view.init();
	}

	/**
	 * Transform data from object to JSON
	 * 
	 * @param toJson
	 *            Object to be transformed
	 * @return String JSON format
	 */
	private String toJson(Object toJson) {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(toJson);
		return jsonInString;
	}

	/**
	 * Add a new Event
	 * 
	 * @param title
	 *            The title of the event
	 * @param description
	 *            The description of the event
	 * @param startDate
	 *            The start date of the event
	 * @param endDate
	 *            The end date of the event
	 * @param actors
	 *            The actors associated with the event
	 * @param actorsDescription
	 *            The description about the actors associated with the event
	 */
	public void addEvent(String title, String description, Date startDate, Date endDate, String[] actors,
			String actorsDescription) {
		this.service.addEvent(title, description, startDate, endDate, actors, actorsDescription);
	}

	/**
	 * Add new events
	 * 
	 * @param eventsInJsonFormat
	 *            Json format all events to add
	 */
	public void addEvents(String eventsInJsonFormat) {
		this.service.addEvents(eventsInJsonFormat);
	}

	/**
	 * Add new actors
	 * 
	 * @param actors
	 *            Json format all the actors to add
	 */
	public void addActors(String actors) {
		this.service.addActors(actors);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param importButtonActionListener
	 *            The ActionListener for the import button
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener) {
		view.addImportButtonActionListener(importButtonActionListener);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param addNewButtonActionListener
	 *            The ActionListener for the add new event button
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewButtonActionListener) {
		view.addAddNewEventButtonActionListener(addNewButtonActionListener);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param saveNewEventActionListener
	 *            The ActionListener for the save new event button
	 */
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener) {
		this.view.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}

	/**
	 * Add {@link MouseListener} to the {@link View}
	 * 
	 * @param timelineEventMouseListener
	 *            The MouseListener for the import button
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener) {
		this.view.addTimelineEventActionListener(timelineEventMouseListener);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param uploadFileActionListener
	 *            The {@link ActionListener} for the upload button
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener) {
		this.view.addUploadFileActionListener(uploadFileActionListener);
	}

	/**
	 * Change the working panel in the {@link View} to the
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.NewEventPanel}
	 */
	public void changeToAddNewEventPanel() {
		String actorsJson = this.service.getAllActors();
		this.view.changeToAddNewEventPanel(actorsJson);
		this.addSaveNewEventButtonActionListener(new SaveNewEventActionListener(this));
	}

	/**
	 * Change the working panel in the {@link View} to the
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.ImportPanel}
	 */
	public void changeToImportPanel() {
		this.view.changeToImportPanel();
	}

	/**
	 * Save a new event. Gets displayed data in View and stores it in the model
	 */
	public void saveNewEvent() {
		Map<String, String> newEvent = this.view.getSaveNewEventData();
		try {
			Date startDate = new SimpleDateFormat("dd-MM-yyyy").parse(newEvent.get("startDate"));
			Date endDate = new SimpleDateFormat("dd-MM-yyyy").parse(newEvent.get("endDate"));
			String[] actors = newEvent.get("actorsIds").substring(1, newEvent.get("actorsIds").length() - 1)
					.split(", ");
			this.service.addEvent(newEvent.get("title"), newEvent.get("description"), startDate, endDate, actors,
					newEvent.get("actorsInvolvement"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.view.clearNewEventFields();
	}

	/**
	 * Get all the data entered in the View about the new actor and save that
	 * actor
	 */
	public void saveNewActor() {
		String actor = this.view.getActorData();
		this.service.addActor(actor);
	}

	/**
	 * Change the working panel in the {@link View} to the
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.EventDetailsPanel}
	 * 
	 * @param x
	 *            The x coordinate of the clicked event
	 * @param y
	 *            The y coordinate of the clicked event
	 */
	public void openEventDetailsPanel(int x, int y) {
		int year = this.view.getEventYearByCoordinates(x, y);
		String eventsOfSpecificYear = "";
		String actorsJson = "";
		try {

			eventsOfSpecificYear = this.service.getEventsByYear(year);
			actorsJson = this.service.getAllActors();
			System.out.println("All events in that year = " + eventsOfSpecificYear);
			System.out.println("All actors : " + actorsJson);
			this.view.setEventDetails(eventsOfSpecificYear, actorsJson);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param downloadTimelineActionListener
	 *            The {@link ActionListener} for the view
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener) {
		this.view.addDownloadTimelineActionListener(downloadTimelineActionListener);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param addActorButtonActionListener
	 *            The {@link ActionListener} for the view
	 */
	public void addAddActorButtonActionListener(ActionListener addActorButtonActionListener) {
		this.view.addAddActorButtonActionListener(addActorButtonActionListener);
	}

	/**
	 * Add {@link ActionListener} to the {@link View}
	 * 
	 * @param saveActorButtonActionListener
	 *            The {@link ActionListener} for the view
	 */
	public void addSaveActorButtonActionListener(ActionListener saveActorButtonActionListener) {
		this.view.addSaveActorButtonActionListener(saveActorButtonActionListener);
	}

	/**
	 * Download the current timeline to a defined path
	 * 
	 * @param absolutePathDestination
	 *            The Absolute Path to where the timeline has to be donwloaded
	 */
	public void saveTimeline(String absolutePathDestination) {
		File file = new File(absolutePathDestination + ".json");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePathDestination + ".json"))) {

			String jsonToWrite = this.service.getAllEvents() + "&" + System.lineSeparator()
					+ this.service.getAllActors();

			bw.write(jsonToWrite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Change the working panel in the View to NewActorPanel
	 */
	public void changeToAddNewActorPanel() {
		String actors = this.service.getAllActors();
		this.view.changeToAddNewActorPanel(actors);
	}
}