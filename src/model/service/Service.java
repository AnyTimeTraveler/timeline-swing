package model.service;

import java.util.ArrayList;
import java.util.List;

import ui.Observer;

public class Service implements Subject {

	List<Observer> observers = new ArrayList<Observer>(); 
	
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++){
			observers.get(i).update(); 
		} 
	}

	@Override
	public void register(Observer obs) {
		this.observers.add(obs);
	}

	@Override
	public void removeRegister(Observer obs) {
		for (int i = 0; i<observers.size(); i++){
			if(observers.get(i).equals(obs)){
				observers.remove(i);
			}
		}
	}
}
