package com.fsbtech.interviews.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubCategoryEventsMap {

	private  static Map<Integer, Set<Integer>> mapSubCategoryEvents = new HashMap<Integer, Set<Integer>>();

	public static void addEventToSubCategory(Integer subCategoryId, Integer eventId) {
		if (!mapSubCategoryEvents.containsKey(subCategoryId)) {
			mapSubCategoryEvents.put(subCategoryId, new HashSet<Integer>());
		}
		
		mapSubCategoryEvents.get(subCategoryId).add(eventId);
	}
	
	public static void removeEventToSubCategory(Integer subCategoryId, Integer eventId) {
		if (mapSubCategoryEvents.containsKey(subCategoryId)) {
			mapSubCategoryEvents.remove(eventId);
		}
	}
	
	public static boolean emptyEventForSubCategory(Integer subCategoryId) {
		boolean result = (!mapSubCategoryEvents.containsKey(subCategoryId)) || 
			         	 ((mapSubCategoryEvents.get(subCategoryId)==null) || 
			         	 (mapSubCategoryEvents.get(subCategoryId).isEmpty()));
		
		
		return result;
	}
}
