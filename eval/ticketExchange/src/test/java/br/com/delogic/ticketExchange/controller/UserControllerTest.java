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

import br.com.delogic.ticketExchange.controler.UserController;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.service.UserService;


public class UserControllerTest {

       
		    
	 @Mock
	 private UserService userService;
	 
	 @InjectMocks
	 private UserController userController;

	 @BeforeEach
	 public void setUpMocks() {
	    MockitoAnnotations.openMocks(this);
	 }
	 	
	 @Test
	 public void testGetAllUserIds_Ok() {		  
		   
	       List<Long> listaId = Collections.singletonList(Long.valueOf(1));
	       Pageable pageable = PageRequest.of(0, 10);
	       Page<Long> page = new PageImpl<Long>(listaId,pageable,1L) ; 
	       Optional<Page<Long>> mockValue = Optional.of(page);	       
	           
	       when(userService.getAllIds(pageable)).thenReturn(mockValue);
	       ResponseEntity<Page<Long>> response = userController.getAllUserIds(pageable);
	       assertEquals(ResponseEntity.ok(page), response);
	       
	 }
	 
	 @Test
	 public void testGetUserById_Ok() {		  
		    
		   UserDTO userDTO = new UserDTO(); 
		   userDTO.setId(1L);
	       Optional<UserDTO> mockValue = Optional.of(userDTO);	
	           
	       when(userService.getUserById(1L)).thenReturn(mockValue);
	       ResponseEntity<UserDTO> response = userController.getUserById(1L);
	       assertEquals(ResponseEntity.ok(userDTO), response);
	       
	 }

	    

   
}

