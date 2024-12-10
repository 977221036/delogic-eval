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

import br.com.delogic.ticketExchange.domain.Category;
import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.repository.CategoryRepository;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUpInjectMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Category category = new Category();
        category.setId(1L);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);  
        when(categoryRepository.getReferenceById(1L)).thenReturn(category);
        when(categoryService.convertToDTO(category)).thenReturn(categoryDTO);

        Optional<CategoryDTO> result = categoryService.getCategoryById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(categoryDTO);
    }

  
   

  
}
