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

import br.com.delogic.ticketExchange.domain.Sale;
import br.com.delogic.ticketExchange.dto.SaleDTO;
import br.com.delogic.ticketExchange.repository.SaleRepository;

public class SalesServiceTest {

    @Mock
    private SaleRepository saleRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private SaleService saleService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Sale sale = new Sale();
        sale.setId(1L);
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(1L);  
        when(saleRepository.getReferenceById(1L)).thenReturn(sale);
        when(saleService.convertToDTO(sale)).thenReturn(saleDTO);

        Optional<SaleDTO> result = saleService.getSaleById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(saleDTO);
    }

  
   

  
}
