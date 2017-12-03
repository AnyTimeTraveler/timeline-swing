package model.service;

import java.util.ArrayList;
import java.util.List;

import ui.Observer;

public interface Subject {

	public void notifyObservers() ;

	public void register(Observer observer) ;

	public void removeRegister(Observer observer) ;
	
}
