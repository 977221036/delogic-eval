package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Event;
import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.dto.DateDTO;
import br.com.delogic.ticketExchange.dto.EventDTO;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private EventRepository repository;

    public EventDTO convertToDTO(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    public Event convertToEntity(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }
    
    public List<EventDTO> getAllEvents() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
   
    public EventDTO createEvent(EventDTO eventDTO) {
        return convertToDTO(repository.save(convertToEntity(eventDTO)));
    }
    
  
    public Optional<EventDTO> getEventById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }
    

    public void deleteEvent(Long id) {
    	repository.deleteById(id);
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    } 
}
