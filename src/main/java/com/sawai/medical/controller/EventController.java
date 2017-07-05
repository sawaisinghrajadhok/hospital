package com.sawai.medical.controller;

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sawai.medical.model.Event;
import com.sawai.medical.service.EventService;

@RestController
@RequestMapping("/event")
@Api(value = "Event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Event create(@RequestBody Event event) {
		return eventService.create(event);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Event> getAll() {
		return eventService.getAll();
	}
	
	@RequestMapping(value = "/hospital/{hospitalId}", method = RequestMethod.GET)
	public List<Event> getByHospital(@PathVariable("hospitalId") Long hospitalId) {
		return eventService.getByHospital(hospitalId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		eventService.delete(id);
	}
}
