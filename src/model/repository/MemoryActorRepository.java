package model.repository;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Event;

public class MemoryActorRepository implements ActorRepository{

	private List<Actor> actors; 
	
	public MemoryActorRepository(){
		this.actors = new ArrayList<Actor>(); 
	}
	
	@Override
	public List<Actor> getActors() {
		return this.actors; 
	}

	@Override
	public boolean addActor(Actor actor) {
		try{
		this.actors.add(actor); 
		return true; 
		}catch(Exception e){
			return false; 
		}	
	}

	@Override
	public boolean removeActor(int id) {
		for(int i = 0;i<this.actors.size() ; i++){
			if(actors.get(i).getId() == id){
				this.actors.remove(i);
				return true; 
			}
		}
		return false;
	}

	@Override
	public Actor getActor(int id) {
		for(int i = 0;i<this.actors.size() ; i++){
			if(actors.get(i).getId() == id){ 
				return this.actors.get(i); 
			}
		}
		return null; 
	}

	
	
	
}
