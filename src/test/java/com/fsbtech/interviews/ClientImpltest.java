package com.fsbtech.interviews;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsbtech.interviews.entities.Category;
import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;
import com.fsbtech.interviews.entities.SubCategory;
import com.fsbtech.interviews.repository.EventRepository;

class ClientImpltest {
	private static Logger logger = LoggerFactory.getLogger(ClientImpltest.class);
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEventCase1() {
		Client client ;
		Event event = null;
		
		try {
			client = new ClientImpl();
			event = buildEventCase1();
			assertTrue(event!=null);
			client.addEvent(event);
			client.addEvent(event);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	

	@Test
	void testAddEventCase2() {
		Client client ;
		Event event = null;
		
		try {
			client = new ClientImpl();
			event = buildEventCase1();
			assertTrue(event!=null);
			client.eventCompleted(event.getId());
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testAsCompleteCase1() {
		Client client ;
		Event event = null;
		
		try {
			client = new ClientImpl();
			event = buildEventCase2();
			assertTrue(event!=null);
			client.eventCompleted(event.getId());
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testAddMarketRefTypeCase1() {
		Client client ;
		Event event = null;
		
		try {
			client = new ClientImpl();
			event = buildEventCase2();
			assertTrue(event!=null);
			client.attachMarketRefTypeToEvent(null, null);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testRemoveMarketRefTypeCase1() {
		Client client ;
		Event event = null;
		
		try {
			client = new ClientImpl();
			event = buildEventCase2();
			assertTrue(event!=null);
			client.eventCompleted(event.getId());
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	private Event buildEventCase1() {
		Integer id = Integer.valueOf(1) ;
	    String name = "Manchester United v Arsenal";
	    SubCategory subCategory = new SubCategory(1, "Premier League", new Category(1, "Football"));
	    Collection<MarketRefType> marketRefTypes = new HashSet<MarketRefType>();
	    marketRefTypes.add(new MarketRefType(1, "Home"));
	    Boolean completed=Boolean.FALSE;

	    
		Event event = new Event(id, name, subCategory, marketRefTypes, completed);
		return event;
	}
	
	private Event buildEventCase2() {
		Integer id = Integer.valueOf(2) ;
	    String name = "Manchester City v Chelsea";
	    SubCategory subCategory = new SubCategory(1, "Premier League", new Category(1, "Football"));
	    Collection<MarketRefType> marketRefTypes = new HashSet<MarketRefType>();
	    marketRefTypes.add(new MarketRefType(1, "Home"));
	    Boolean completed=Boolean.TRUE;

	    
		Event event = new Event(id, name, subCategory, marketRefTypes, completed);
		return event;
	}
	
	private MarketRefType buildMarketRefTypeCase1() {
		return new MarketRefType(1, "Home");
	}
	
	private MarketRefType buildMarketRefTypeCase2() {
		return new MarketRefType(2, "Away");
	}
	
	

}
