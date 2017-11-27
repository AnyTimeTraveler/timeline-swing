package repository;

import java.util.*;

import model.Event;

public interface Repository {
	public List<Event> getEvents(); 
	public boolean addEvent();
	public boolean removeEvent(Event events);
	public Event getEvent(int id);
}
