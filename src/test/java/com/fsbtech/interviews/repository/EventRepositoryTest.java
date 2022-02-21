package com.fsbtech.interviews.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
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

class EventRepositoryTest {
	private static Logger logger = LoggerFactory.getLogger(EventRepositoryTest.class);

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
	void testAddEvent() {
		Event event1 = null;
		Event event2 = null;
		try {
			Event event = null;
			event1 = buildEventCase1();
			event2 = buildEventCase2();

			EventRepository.addEvent(event1);
			event = EventRepository.getEvent(1);
			logger.info("Event = " + EventRepository.getEvent(1));

			EventRepository.addEvent(event2);
			event = EventRepository.getEvent(1);
			logger.info("Event = " + EventRepository.getEvent(1));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private Event buildEventCase1() {
		Integer id = Integer.valueOf(1);
		String name = "Manchester United v Arsenal";
		SubCategory subCategory = new SubCategory(1, "Premier League", new Category(1, "Football"));
		Collection<MarketRefType> marketRefTypes = List.of(new MarketRefType(1, "Home"));
		Boolean completed = Boolean.FALSE;

		Event event = new Event(id, name, subCategory, marketRefTypes, completed);
		return event;
	}

	private Event buildEventCase2() {
		Integer id = Integer.valueOf(1);
		String name = "Manchester City v Chelsea";
		SubCategory subCategory = new SubCategory(1, "Premier League", new Category(1, "Football"));
		Collection<MarketRefType> marketRefTypes = List.of(new MarketRefType(1, "Home"));
		Boolean completed = Boolean.FALSE;

		Event event = new Event(id, name, subCategory, marketRefTypes, completed);
		return event;
	}

}
