package br.com.delogic.ticketExchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.EventDTO;
import br.com.delogic.ticketExchange.service.EventService;


@RestController
public class EventController extends RootController{
	
	@Autowired
    private EventService eventService;

        
    @GetMapping("/events")
    public ResponseEntity<Page<Long>> getAllEventIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = eventService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
