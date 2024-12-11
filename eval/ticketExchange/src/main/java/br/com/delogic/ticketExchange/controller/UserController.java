package br.com.delogic.ticketExchange.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.service.UserService;

@RestController
public class UserController extends RootController{
	
	@Autowired
    private UserService userService;

        
    @GetMapping("/users")
    public ResponseEntity<Page<Long>> getAllUserIds(Pageable pageable) {    	
    	Optional<Page<Long>> result = userService.getAllIds(pageable);
    	return result.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());    
    }
    

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	

}
