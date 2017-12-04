package ui;

import java.util.List;

import model.service.Subject;
import ui.datasets.timeline.Event;

public interface Observer {

	void update(String eventsJson);
	
}
