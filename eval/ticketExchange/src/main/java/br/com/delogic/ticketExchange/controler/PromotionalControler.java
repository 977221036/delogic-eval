package br.com.delogic.ticketExchange.controler;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.service.ListingService;

@RestController
public class PromotionalControler extends RootController{
	
	@Autowired
    private ListingService listingService;
	
	/**Endpoint for the promocional highlight listings   
	 * 
	 * @param contextualDate
	 * @param categoryId
	 * @param city
	 * @param includeUrls
	 * @return
	 */	 
	@GetMapping("/promotional")
    public ResponseEntity<List<Long>> getPromotionalListings(
            @RequestParam(value ="contextualDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date contextualDate,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "cityName", required = false) String city){
        Optional<List<Long>> result = listingService.getPromotionalListings(contextualDate, categoryId, city);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    
    }
    

}
