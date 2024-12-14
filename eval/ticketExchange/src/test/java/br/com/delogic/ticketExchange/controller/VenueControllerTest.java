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

import br.com.delogic.ticketExchange.controller.VenueController;
import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.service.VenueService;


public class VenueControllerTest {

       
		    
	 @Mock
	 private VenueService venueService;
	 
	 @InjectMocks
	 private VenueController venueController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testGetAllVenueIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	                 
	       when(venueService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = venueController.getAllVenueIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }
	 
	 
	 @Test
	 public void testGetVenueById_Ok() {		  
		    
		   VenueDTO venueDTO = new VenueDTO();  
		   venueDTO.setId(1L);
		   Optional<VenueDTO> mockValue = Optional.of(venueDTO);	
	           
	       when(venueService.getVenueById(1L)).thenReturn(mockValue);
	       ResponseEntity<VenueDTO> response = venueController.getVenueById(1L);
	       assertEquals(ResponseEntity.ok(venueDTO), response);
	       
	 }      


	    

   
}

