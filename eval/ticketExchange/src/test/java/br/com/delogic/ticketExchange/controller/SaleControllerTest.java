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

import br.com.delogic.ticketExchange.controler.SalesController;
import br.com.delogic.ticketExchange.dto.SaleDTO;
import br.com.delogic.ticketExchange.service.SaleService;


public class SaleControllerTest {

       
		    
	 @Mock
	 private SaleService saleService;
	 
	 @InjectMocks
	 private SalesController saleController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 
	
	 @Test
	 public void testGetAllSaleIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	                 
	       when(saleService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = saleController.getAllSaleIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }

	 @Test
	 public void testGetSaleById_Ok() {		  
		    
		   SaleDTO saleDTO = new SaleDTO();  
		   saleDTO.setId(1L);
		   Optional<SaleDTO> mockValue = Optional.of(saleDTO);	
	           
	       when(saleService.getSaleById(1L)).thenReturn(mockValue);
	       ResponseEntity<SaleDTO> response = saleController.getSaleById(1L);
	       assertEquals(ResponseEntity.ok(saleDTO), response);
	       
	 }       

   
}

