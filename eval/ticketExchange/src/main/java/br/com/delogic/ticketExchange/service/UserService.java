package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.User;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UserRepository repository; 
    
    public UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
    
    public List<UserDTO> getAllUsers() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    }  
   
    public Optional<UserDTO> createUser(UserDTO userDTO) {
        return Optional.of(convertToDTO(repository.save(convertToEntity(userDTO))));
    }
    
    public Optional<UserDTO> getUserById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }

    public void deleteUser(Long id) {
    	repository.deleteById(id);
    }

}
