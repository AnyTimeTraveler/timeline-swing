package model.repository;

import ui.Observer;

public interface Subject {
  
public void notifyObservers();

  public void register(Observer obs);

  public void removeRegister(Observer obs);
}