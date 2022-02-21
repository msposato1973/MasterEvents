package com.fsbtech.interviews.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsbtech.interviews.entities.Event;

public  class EventRepository {

	static private Map<Integer,Event> mapEvent = new HashMap<Integer,Event>();
	
	public static synchronized void addEvent(Event event) {
		
		mapEvent.put(event.getId(), event);
	}
	
	public static Event getEvent(Integer id) {
		return mapEvent.get(id);
	}
	
	public static void remove(Integer id) {
		 mapEvent.remove(id);
	}

	@Override
	public String toString() {
		
		return "EventRepository [getClass()=" + getClass() +
				", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public static String printFormattedOutput() {
		String resultEvents = "Events : " + mapEvent.toString(); 
		
		return resultEvents;
	}
	
	public static List<Event> listEvents() {
		
		return null;
	}
	
}
