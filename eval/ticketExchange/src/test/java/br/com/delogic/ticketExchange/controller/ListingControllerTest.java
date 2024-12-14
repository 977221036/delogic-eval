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

import br.com.delogic.ticketExchange.controller.ListingController;
import br.com.delogic.ticketExchange.dto.ListingDTO;
import br.com.delogic.ticketExchange.service.ListingService;


public class ListingControllerTest {

       
		    
	 @Mock
	 private ListingService listingService;
	 
	 @InjectMocks
	 private ListingController listingController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testGetAllListingIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	                 
	       when(listingService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = listingController.getAllListingIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }

	    

	 @Test
	 public void testGetListingById_Ok() {		  
		    
		   ListingDTO listingDTO = new ListingDTO();  
		   listingDTO.setId(1L);
		   Optional<ListingDTO> mockValue = Optional.of(listingDTO);	
	           
	       when(listingService.getListingById(1L)).thenReturn(mockValue);
	       ResponseEntity<ListingDTO> response = listingController.getListingById(1L);
	       assertEquals(ResponseEntity.ok(listingDTO), response);
	       
	 }    
   
}

