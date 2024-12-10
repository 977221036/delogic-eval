package br.com.delogic.ticketExchange.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.delogic.ticketExchange.controler.EventController;
import br.com.delogic.ticketExchange.dto.EventDTO;
import br.com.delogic.ticketExchange.service.EventService;


public class EventControllerTest {

       
		    
	 @Mock
	 private EventService eventService;
	 
	 @InjectMocks
	 private EventController eventController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testGetAllEventIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	                 
	       when(eventService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = eventController.getAllEventIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }

	 @Test
	 public void testGetEventById_Ok() {		  
		    
		   EventDTO eventDTO = new EventDTO();  
		   eventDTO.setId(1L);
		   Optional<EventDTO> mockValue = Optional.of(eventDTO);	
	           
	       when(eventService.getEventById(1L)).thenReturn(mockValue);
	       ResponseEntity<EventDTO> response = eventController.getEventById(1L);
	       assertEquals(ResponseEntity.ok(eventDTO), response);
	       
	 }       

   
}

