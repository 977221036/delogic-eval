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

import br.com.delogic.ticketExchange.domain.Listing;
import br.com.delogic.ticketExchange.dto.ListingDTO;
import br.com.delogic.ticketExchange.repository.ListingRepository;

public class ListingsServiceTest {

    @Mock
    private ListingRepository listingRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private ListingService listingService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Listing listing = new Listing();
        listing.setId(1L);
        ListingDTO listingDTO = new ListingDTO();
        listingDTO.setId(1L);  
        when(listingRepository.getReferenceById(1L)).thenReturn(listing);
        when(listingService.convertToDTO(listing)).thenReturn(listingDTO);

        Optional<ListingDTO> result = listingService.getListingById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(listingDTO);
    }

  
   

  
}
