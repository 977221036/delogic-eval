package br.com.delogic.ticketExchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.service.VenueService;

@RestController
public class VenueController extends RootController{
	
	@Autowired
    private VenueService venueService;

        
    @GetMapping("/venues")
    public ResponseEntity<Page<Long>> getAllVenueIds(Pageable pageable) {
    	Optional<Page<Long>> result = venueService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    	
    	
    }
    

    @GetMapping("/venues/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	
	

}
