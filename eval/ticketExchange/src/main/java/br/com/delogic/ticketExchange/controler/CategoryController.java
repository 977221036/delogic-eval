package br.com.delogic.ticketExchange.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.service.CategoryService;

@RestController
public class CategoryController extends RootController{
	
	
	@Autowired
    private CategoryService categoryService;

        
    @GetMapping("/categories")
    public ResponseEntity<Page<Long>> getAllCategoryIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = categoryService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
