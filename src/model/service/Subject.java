package model.service;

import java.util.List;

import ui.Observer;

public interface Subject {
  
	public void notifyObservers();

  public void register(Observer obs);

  public void removeRegister(Observer obs);
}