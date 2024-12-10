package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Category;
import br.com.delogic.ticketExchange.domain.Date;
import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.dto.DateDTO;
import br.com.delogic.ticketExchange.dto.SaleDTO;
import br.com.delogic.ticketExchange.repository.DateRepository;

@Service
public class DateService {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
    private DateRepository repository;

    public DateDTO convertToDTO(Date date) {
        return modelMapper.map(date, DateDTO.class);
    }

    public Date convertToEntity(DateDTO dateDTO) {
        return modelMapper.map(dateDTO, Date.class);
    }
	    
    public List<DateDTO> getAllDates() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
   
    public DateDTO createDate(DateDTO dateDTO) {
        return convertToDTO(repository.save(convertToEntity(dateDTO)));
    }
        
    public Optional<DateDTO> getDateById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }
    

    public void deleteDate(Long id) {
    	repository.deleteById(id);
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    }    

	
}
