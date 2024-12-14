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

import br.com.delogic.ticketExchange.domain.Event;
import br.com.delogic.ticketExchange.dto.EventDTO;
import br.com.delogic.ticketExchange.repository.EventRepository;

public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Event event = new Event();
        event.setId(1L);
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(1L);  
        when(eventRepository.getReferenceById(1L)).thenReturn(event);
        when(eventService.convertToDTO(event)).thenReturn(eventDTO);

        Optional<EventDTO> result = eventService.getEventById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(eventDTO);
    }

  
   

  
}
