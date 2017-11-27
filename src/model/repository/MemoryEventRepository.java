package model.repository;

import java.util.ArrayList;
import java.util.List;

import model.Event;

public class MemoryEventRepository implements EventRepository {

	private List<Event> events; 
	
	public MemoryEventRepository(){
		this.events = new ArrayList<Event>(); 
	}
	
	@Override
	public List<Event> getEvents() {
		return this.events;
	}

	@Override
	public boolean addEvent(Event event) {
		try{
			this.events.add(event);
			return true;
		}catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return false;	
		}
	}

	@Override
	public boolean removeEvent(int id) {
		try{
			//Search through all events to find matching id
			for(int i = 0;i<this.events.size() ; i++){
				if(id == this.events.get(i).getId()){
				this.events.remove(i);
				//Return true after event deleted
				return true;
				}
			}
			//Return false if no event was deleted during loop
			return false; 
		}catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return false;	
		}
	}

	@Override
	public Event getEvent(int id) {
		try{
			for(int i = 0;i<this.events.size() ; i++){
				if(id == this.events.get(i).getId()){
				return this.events.get(i);
				}
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
			return null; 
		}
		return null; 
	}

}
