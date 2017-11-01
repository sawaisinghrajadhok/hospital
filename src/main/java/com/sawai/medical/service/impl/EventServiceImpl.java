package com.sawai.medical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sawai.medical.model.Event;
import com.sawai.medical.repository.EventRepository;
import com.sawai.medical.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Event create(Event event) {
		return null;
	}

	@Override
	public Event getById(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public List<Event> getAll() {
		return null;
	}

	@Override
	public List<Event> getByHospital(Long hospitalId) {
		return null;
	}
}
