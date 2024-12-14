package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Event;

@DataJpaTest
public class EventRepositoryTest {
	
	    final String EVENT_NAME = "NEW SHOW"; 

	
	    @Autowired
	    EventRepository eventRepository; 
		
	    @Test
	    public void testEventSaveAndFind() throws ParseException {   	
	        Event newEvent = new Event();
	        
	        String dateStr = "2024-12-08";        
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date formattedDate = formatter.parse(dateStr);
	            		    	        
	        newEvent.setEventStart(formattedDate); 	       
	        newEvent.setName(EVENT_NAME);
	        	        	        
	        
	        eventRepository.save(newEvent);
	        
	        //Event loaded into Database 
	             
	        Optional<Event> eventAcquired =  eventRepository.findById(newEvent.getId());
	           
	        assertThat(eventAcquired).isPresent();
	        assertThat(EVENT_NAME.equals(eventAcquired.get().getName()));
	        
	    }

	
}
