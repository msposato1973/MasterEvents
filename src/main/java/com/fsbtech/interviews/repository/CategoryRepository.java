package com.fsbtech.interviews.repository;

import java.util.HashMap;
import java.util.Map;

import com.fsbtech.interviews.entities.Category;

public  class CategoryRepository {

	static private Map<Integer,Category> mapCategory = new HashMap<Integer,Category>();

	public static synchronized void addCategory(Category category) {
		mapCategory.put(category.getId(), category);
	}
	
	public static Category getCategory(Integer id) {
		return mapCategory.get(id);
	}
	
	public static void removeCategory(Integer id) {
		 mapCategory.remove(id);
	}
	
	public static String printFormattedOutput() {
		String resultEvents = "Category : " + mapCategory.toString(); 
		
		return resultEvents;
	}
}
