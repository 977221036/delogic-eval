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

import br.com.delogic.ticketExchange.domain.Date;
import br.com.delogic.ticketExchange.dto.DateDTO;
import br.com.delogic.ticketExchange.repository.DateRepository;

public class DateServiceTest {

    @Mock
    private DateRepository DateRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private DateService DateService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Date date = new Date();
        date.setId(1L);
        DateDTO dateDTO = new DateDTO();
        dateDTO.setId(1L);  
        when(DateRepository.getReferenceById(1L)).thenReturn(date);
        when(DateService.convertToDTO(date)).thenReturn(dateDTO);

        Optional<DateDTO> result = DateService.getDateById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(dateDTO);
    }

  
   

  
}
