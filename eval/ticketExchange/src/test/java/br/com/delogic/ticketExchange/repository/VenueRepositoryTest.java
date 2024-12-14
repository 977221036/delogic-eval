package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Venue;

@DataJpaTest
public class VenueRepositoryTest {
	
	final String TESTNAME = "MADISON SQUARE GARDEN";
	
	@Autowired
	private VenueRepository venueRepository;
	
	@Test
    public void testDateSaveAndFind() throws ParseException {   	
    	Venue newVenue = new Venue();
        
            	
    	newVenue.setCity("NEW YORK");
    	newVenue.setName(TESTNAME);
    	newVenue.setSeatingCapacity(10000);
    	newVenue.setState("NY");
    	
    	
    	venueRepository.save(newVenue);
        
        //venue loaded into Database               
        Optional<Venue> venueAcquired =  venueRepository.findById(newVenue.getId());
           
        assertThat(venueAcquired).isPresent();
        assertThat(TESTNAME.equals(venueAcquired.get().getName()));
        
    }

}
