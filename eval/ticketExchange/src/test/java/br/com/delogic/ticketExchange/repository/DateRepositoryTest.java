package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Date;

@DataJpaTest
public class DateRepositoryTest {
	
	@Autowired
	private DateRepository dateRepository;
	
	@Test
    public void testDateSaveAndFind() throws ParseException {   	
    	Date newDate = new Date();
        String dateStr = "2024-12-08";        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date formattedDate = formatter.parse(dateStr);
            	
    	newDate.setDate(formattedDate);
    	newDate.setDay("SU");
    	newDate.setYear(2024);
    	newDate.setQuarter(4);
    	newDate.setMonth("DEC");
    	newDate.setHoliday(false);
    	
    	dateRepository.save(newDate);
        
        //Date loaded into Database               
        Optional<Date> dateAcquired =  dateRepository.findById(newDate.getId());
           
        assertThat(dateAcquired).isPresent();
        assertThat(dateStr.equals(formatter.format(dateAcquired.get().getDate())));
        
    }

}
