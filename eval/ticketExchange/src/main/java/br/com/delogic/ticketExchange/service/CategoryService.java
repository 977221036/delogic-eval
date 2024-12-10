package br.com.delogic.ticketExchange.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delogic.ticketExchange.domain.Category;
import br.com.delogic.ticketExchange.domain.User;
import br.com.delogic.ticketExchange.dto.CategoryDTO;
import br.com.delogic.ticketExchange.dto.DateDTO;
import br.com.delogic.ticketExchange.dto.UserDTO;
import br.com.delogic.ticketExchange.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository repository; 

    public CategoryDTO convertToDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public Category convertToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }
    
    public List<CategoryDTO> getAllCategories() {
    	return repository.findAll().stream().map(this::convertToDTO).toList();
    }
   
    public CategoryDTO createCategory(CategoryDTO CategoryDTO) {
        return convertToDTO(repository.save(convertToEntity(CategoryDTO)));
    }
    
    
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return Optional.of(convertToDTO(repository.getReferenceById(id)));
    }
    
    public Optional<Page<Long>> getAllIds(Pageable pageable) {
        return Optional.of(repository.findAllIds(pageable));
    }   

    public void deleteCategory(Long id) {
    	repository.deleteById(id);
    }


}
