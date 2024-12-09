package br.com.delogic.ticketExchange.dto;

import java.util.Date;

public class EventDTO {
	
	private Long id;
	private String name;
	private Date startTime;
	private VenueDTO venue;
	private CategoryDTO category;
	private DateDTO date;
	  
	/**Getters and Setters **/
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public VenueDTO getVenue() {
		return venue;
	}
	public void setVenue(VenueDTO venue) {
		this.venue = venue;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public DateDTO getDate() {
		return date;
	}
	public void setDate(DateDTO date) {
		this.date = date;
	}
	  

}
