package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Sale;
import br.com.delogic.ticketExchange.dto.ListingDTO;
import br.com.delogic.ticketExchange.dto.SaleDTO;
import br.com.delogic.ticketExchange.dto.VenueDTO;
import br.com.delogic.ticketExchange.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
    private SaleRepository repository;

    public SaleDTO convertToDTO(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }

    public Sale convertToEntity(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }
			    
	public List<SaleDTO> getAllSales() {
	 	return repository.findAll().stream().map(this::convertToDTO).toList();
	}
	   
	public SaleDTO createSale(SaleDTO SaleDTO) {
	   return convertToDTO(repository.save(convertToEntity(SaleDTO)));
	}
	

	public Optional<SaleDTO> getSaleById(Long id) {
	    return Optional.of(convertToDTO(repository.getReferenceById(id)));
	}
	
	public void deleteSale(Long id) {
	  	repository.deleteById(id);
	}
	
	
	public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    }   
}
