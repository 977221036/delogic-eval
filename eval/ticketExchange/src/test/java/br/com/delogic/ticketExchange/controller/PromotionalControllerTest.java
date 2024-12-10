package br.com.delogic.ticketExchange.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.delogic.ticketExchange.controler.PromotionalControler;
import br.com.delogic.ticketExchange.service.ListingService;


public class PromotionalControllerTest {
	
	
    
    
	 @Mock
	 private ListingService listingService;
	 
	 @InjectMocks
	 private PromotionalControler promotionalController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testPromotionalListing_Ok() throws ParseException {		  
		   
	       List<Long> mockListId = Collections.singletonList(Long.valueOf(1));
	       
	       Optional<List<Long>> mockValue = Optional.of(mockListId);
	       
	       String dateStr = "2008-12-01";        
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	       java.util.Date formattedDate = formatter.parse(dateStr);	               
	             
	       when(listingService.getPromotionalListings(formattedDate,  7L, "New York City")).thenReturn(mockValue);
	       ResponseEntity<List<Long>> response = promotionalController.getPromotionalListings(formattedDate, 7L, "New York City");
	       assertEquals(ResponseEntity.ok(mockListId), response);
	       
	 }


}
