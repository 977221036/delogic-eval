package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Event;
import br.com.delogic.ticketExchange.domain.Sale;

@DataJpaTest
public class SaleRepositoryTest {
	
	    final String EVENT_NAME = "NEW SHOW"; 

	
	    @Autowired
	    SaleRepository saleRepository; 
		
	    @Test
	    public void testEventSaveAndFind() throws ParseException {   	
	        Sale newSale = new Sale();
	        
	        String dateStr = "2024-12-08";        
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date formattedDate = formatter.parse(dateStr);
	            		 
	        BigDecimal pricePaid = BigDecimal.valueOf(400.00); 	
	       	        
	        newSale.setSaleTime(formattedDate);	        	        	        
	        newSale.setPricePaid(pricePaid);
	        newSale.setQuantitySold(1);	        
	        newSale.setCommissionAmount(BigDecimal.valueOf(10.00));
	        
	        
	        saleRepository.save(newSale);
	        
	        //User loaded in Database 
	             
	        Optional<Sale> saleAcquired =  saleRepository.findById(newSale.getId());
	           
	        assertThat(saleAcquired).isPresent();
	        assertThat(pricePaid.equals(saleAcquired.get().getPricePaid()));
	        
	    }

	
}
