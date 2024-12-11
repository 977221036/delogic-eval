package br.com.delogic.ticketExchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.ListingDTO;
import br.com.delogic.ticketExchange.service.ListingService;


@RestController
public class ListingController extends RootController{
	
	@Autowired
    private ListingService listingService;

        
    @GetMapping("/listings")
    public ResponseEntity<Page<Long>> getAllListingIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = listingService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/listings/{id}")
    public ResponseEntity<ListingDTO> getListingById(@PathVariable Long id) {
        return listingService.getListingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
