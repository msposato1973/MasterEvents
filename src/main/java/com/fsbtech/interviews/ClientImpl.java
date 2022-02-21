package com.fsbtech.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;
import com.fsbtech.interviews.entities.SubCategoryEventsMap;
import com.fsbtech.interviews.repository.CategoryRepository;
import com.fsbtech.interviews.repository.EventRepository;
import com.fsbtech.interviews.repository.SubCategoryRepository;

public class ClientImpl implements Client {
	
	
	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		
		EventRepository.addEvent(event);
		SubCategoryRepository.addSubCategory(event.getSubCategory());
	
		CategoryRepository.addCategory(event.getSubCategory().getCategory());
		SubCategoryEventsMap.addEventToSubCategory(event.getSubCategory().getId(), event.getId());
		
	}

	public void eventCompleted(Integer id) {
		// TODO Auto-generated method stub
		Event event = EventRepository.getEvent(id);
		
		EventRepository.remove(event.getId());
		SubCategoryEventsMap.removeEventToSubCategory(event.getSubCategory().getId(), id);
		if(SubCategoryEventsMap.emptyEventForSubCategory(event.getSubCategory().getId())) {
			SubCategoryRepository.removeSubCategory(event.getSubCategory().getId());
		}
	}

	public void attachMarketRefTypeToEvent(Integer id, MarketRefType marketRefType) {
		// TODO Auto-generated method stub
		
		Event event = EventRepository.getEvent(id);
		
		event.getMarketRefTypes().add(marketRefType);
		Event updatedEvent = new Event(id, event.getName(), event.getSubCategory(),
				event.getMarketRefTypes(), event.getCompleted()
		);
		
	
		EventRepository.addEvent(updatedEvent);
	}

	public void removeMarketRefTypeFromEvent(Integer id, MarketRefType marketRefType) {
		// TODO Auto-generated method stub	

		Event event = EventRepository.getEvent(id);
		
		event.getMarketRefTypes().remove(marketRefType);
		Event updatedEvent = new Event(id, event.getName(), event.getSubCategory(),
				event.getMarketRefTypes(), event.getCompleted()
		);
		
	
		EventRepository.addEvent(updatedEvent);
	}

	public Collection<String> futureEventNamesCollection(String cat, String subcat, String marketRefName) {
		// TODO Auto-generated method stub
		
		return new ArrayList<String>(Arrays.asList(cat,subcat,marketRefName));
	}

	public String dumpFullStructure() {
		// TODO Auto-generated method stub
		String result = EventRepository.printFormattedOutput() + "\n" +
						SubCategoryRepository.printFormattedOutput() + "\n" +
					    CategoryRepository.printFormattedOutput() + "\n";
		return result;
	}

	 

}
