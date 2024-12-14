package br.com.delogic.ticketExchange.dto;

public class CategoryDTO {
	
	
    private Long Id;
    private String group;
    private String name;
    private String description;
    
    /**Getters and Setters **/
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
}