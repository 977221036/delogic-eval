package br.com.delogic.ticketExchange.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.delogic.ticketExchange.controller.CategoryController;
import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.service.CategoryService;


public class CategoryControllerTest {

       
		    
	 @Mock
	 private CategoryService categoryService;
	 
	 @InjectMocks
	 private CategoryController categoryController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testGetAllCategoryIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	                 
	       when(categoryService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = categoryController.getAllCategoryIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }

	 @Test
	 public void testGetCategoryById_Ok() {		  
		    
		   CategoryDTO categoryDTO = new CategoryDTO();
		   categoryDTO.setId(1L);		   
	       Optional<CategoryDTO> mockValue = Optional.of(categoryDTO);	
	           
	       when(categoryService.getCategoryById(1L)).thenReturn(mockValue);
	       ResponseEntity<CategoryDTO> response = categoryController.getCategoryById(1L);
	       assertEquals(ResponseEntity.ok(categoryDTO), response);
	       
	 }   

   
}

