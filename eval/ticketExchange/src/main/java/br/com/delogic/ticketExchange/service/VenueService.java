package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Venue;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.repository.VenueRepository;



@Service
public class VenueService {
	
	
	@Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private VenueRepository repository; 
    
    public VenueDTO convertToDTO(Venue venue) {
        return modelMapper.map(venue, VenueDTO.class);
    }

    public Venue convertToEntity(VenueDTO venueDTO) {
        return modelMapper.map(venueDTO, Venue.class);
    }
    
    public List<VenueDTO> getAllVenues() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
   
    public VenueDTO createVenue(VenueDTO venueDTO) {
        return convertToDTO(repository.save(convertToEntity(venueDTO)));
    }
    
    public Optional<VenueDTO> getVenueById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }

    public void deleteVenue(Long id) {
    	repository.deleteById(id);
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    }  

}
