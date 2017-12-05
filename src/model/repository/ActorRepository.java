package model.repository;

import java.util.List;

import model.Actor;
import model.Event;

public interface ActorRepository {
	public List<Actor> getActors(); 
	public boolean addActor(Actor actor);
	public boolean removeActor(int id);
	public Actor getActor(int id);
}