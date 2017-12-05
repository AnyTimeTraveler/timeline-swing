package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Actor {

	private String name;
	private int id; 
	private static AtomicInteger ID_GENERATOR;

	public Actor(String name){
		this.setName(name);
		ID_GENERATOR = new AtomicInteger(1000);
		this.id = ID_GENERATOR.getAndIncrement();
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
}
