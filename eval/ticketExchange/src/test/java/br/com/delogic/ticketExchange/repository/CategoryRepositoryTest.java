package br.com.delogic.ticketExchange.repository;




import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.Category;

@DataJpaTest
public class CategoryRepositoryTest {
	
	final String TESTNAME = "DELOGIC";

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void testCategorySaveAndFind() {   	
    	Category newCategory = new Category();
    	newCategory.setName(TESTNAME);
    	newCategory.setGroupName(TESTNAME);
    	newCategory.setDescription(TESTNAME);

    	categoryRepository.save(newCategory);
        
        //Category loaded into Database               
        Optional<Category> CategoryAcquired =  categoryRepository.findById(newCategory.getId());
           
        assertThat(CategoryAcquired).isPresent();
        assertThat(TESTNAME.equals(CategoryAcquired.get().getGroupName()));
        
    }
}


