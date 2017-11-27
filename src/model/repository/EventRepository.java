package model.repository;

import java.util.List;

import model.Event;

public interface EventRepository {
	public List<Event> getEvents(); 
	public boolean addEvent();
	public boolean removeEvent(Event events);
	public Event getEvent(int id);
}

