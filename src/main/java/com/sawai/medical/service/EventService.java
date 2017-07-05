package com.sawai.medical.service;

import java.util.List;
import com.sawai.medical.model.Event; 

public interface EventService {
	public Event create(Event event);

	public Event getById(Long id);

	public void delete(Long id);

	public List<Event> getAll();

	public List<Event> getByHospital(Long hospitalId);
}
