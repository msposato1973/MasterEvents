package com.fsbtech.interviews.repository;

import java.util.HashMap;
import java.util.Map;

import com.fsbtech.interviews.entities.SubCategory;

public  class SubCategoryRepository {

	static private Map<Integer,SubCategory> mapSubCategory = new HashMap<Integer,SubCategory>();

	public static synchronized void addSubCategory(SubCategory subCategory) {
		mapSubCategory.put(subCategory.getId(), subCategory);
	}
	
	public static SubCategory getSubCategory(Integer id) {
		return mapSubCategory.get(id);
	}
	
	public static void removeSubCategory(Integer id) {
		 mapSubCategory.remove(id);
	}
	
	public static String printFormattedOutput() {
		String resultEvents = "SubCategory : " + mapSubCategory.toString(); 
		
		return resultEvents;
	}
}
