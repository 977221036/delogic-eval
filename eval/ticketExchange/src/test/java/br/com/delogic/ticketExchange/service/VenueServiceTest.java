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

import br.com.delogic.ticketExchange.domain.Venue;
import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.repository.VenueRepository;

public class VenueServiceTest {

    @Mock
    private VenueRepository venueRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private VenueService venueService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Venue venue = new Venue();
        venue.setId(1L);
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(1L);  
        when(venueRepository.getReferenceById(1L)).thenReturn(venue);
        when(venueService.convertToDTO(venue)).thenReturn(venueDTO);

        Optional<VenueDTO> result = venueService.getVenueById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(venueDTO);
    }

  
   

  
}
