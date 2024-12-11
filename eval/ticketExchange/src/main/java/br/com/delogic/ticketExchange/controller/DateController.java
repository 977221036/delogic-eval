package br.com.delogic.ticketExchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.DateDTO;
import br.com.delogic.ticketExchange.service.DateService;

@RestController
public class DateController extends RootController{
	
	@Autowired
    private DateService dateService;

        
    @GetMapping("/dates")
    public ResponseEntity<Page<Long>> getAllDateIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = dateService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/dates/{id}")
    public ResponseEntity<DateDTO> getDateById(@PathVariable Long id) {
        return dateService.getDateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
