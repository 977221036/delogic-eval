package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Listing;

@DataJpaTest
public class ListingRepositoryTest {
	
	    
	
	    @Autowired
	    ListingRepository listingRepository; 
	    
	    	
		
	    @Test
	    public void testListingSaveAndFind() throws ParseException {   	
	        Listing newListing = new Listing();
	        
	        String dateStr = "2024-12-08";        
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date formattedDate = formatter.parse(dateStr);
	            		    	        
	        BigDecimal totalPrice = BigDecimal.valueOf(400.00); 	       
	        
	        
	        newListing.setNumberOfTickets(4);
	        newListing.setPricePerTicket(BigDecimal.valueOf(100.00));
	        newListing.setTotalPrice(totalPrice);
	        
	        newListing.setListingTime(formattedDate);
	        	        	        
	        
	        listingRepository.save(newListing);
	        
	        //User loaded in Database 
	             
	        Optional<Listing> listingAcquired =  listingRepository.findById(newListing.getId());
	           
	        assertThat(listingAcquired).isPresent();
	        assertThat(totalPrice.equals(listingAcquired.get().getTotalPrice()));
	        
	    }
	    
	    
	    
	
}
