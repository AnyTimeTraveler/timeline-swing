package model.repository;

import java.util.List;

import model.Event;

public interface EventRepository {
	public List<Event> getEvents(); 
	public boolean addEvent(Event event);
	public boolean removeEvent(int id);
	public Event getEvent(int id);
}

