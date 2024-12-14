package br.com.delogic.ticketExchange.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Listing;
import br.com.delogic.ticketExchange.dto.EventDTO;
import br.com.delogic.ticketExchange.dto.ListingDTO;
import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.repository.ListingRepository;

@Service
public class ListingService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ListingRepository repository;

    public ListingDTO convertToDTO(Listing listing) {
        return modelMapper.map(listing, ListingDTO.class);
    }

    public Listing convertToEntity(ListingDTO listingDTO) {
        return modelMapper.map(listingDTO, Listing.class);
    }
            
    public List<ListingDTO> getAllListings() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
   
    public ListingDTO createListing(ListingDTO listingDTO) {
        return convertToDTO(repository.save(convertToEntity(listingDTO)));
    }
    
    public Optional<ListingDTO> getListingById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }

    public void deleteListing(Long id) {
    	repository.deleteById(id);
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    } 
    
    public Optional<List<Long>> getPromotionalListings(Date contextualDate, Long categoryId, String cityName) {
    	List<Long> unsoldListings = repository.findAllUnsoldListings(contextualDate, categoryId, cityName);
        return Optional.of(unsoldListings);  
        
    }

    

}
