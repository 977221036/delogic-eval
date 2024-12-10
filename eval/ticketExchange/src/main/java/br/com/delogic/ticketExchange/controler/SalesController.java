package br.com.delogic.ticketExchange.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.SaleDTO;
import br.com.delogic.ticketExchange.service.SaleService;

@RestController
public class SalesController extends RootController{
	
	@Autowired
    private SaleService saleService;

        
    @GetMapping("/sales")
    public ResponseEntity<Page<Long>> getAllSaleIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = saleService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
