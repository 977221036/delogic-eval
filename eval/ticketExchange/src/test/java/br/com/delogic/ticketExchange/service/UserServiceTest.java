package br.com.delogic.ticketExchange.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import br.com.delogic.ticketExchange.domain.User;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.repository.UserRepository;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        User user = new User();
        user.setId(1L);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);  
        when(userRepository.getReferenceById(1L)).thenReturn(user);
        when(userService.convertToDTO(user)).thenReturn(userDTO);

        Optional<UserDTO> result = userService.getUserById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userDTO);
    }

  
   

  
}
