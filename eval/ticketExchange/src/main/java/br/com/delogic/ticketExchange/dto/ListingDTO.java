package br.com.delogic.ticketExchange.dto;

import java.math.BigDecimal;
import java.util.Date;



public class ListingDTO {
	
    private Long id;
    private UserDTO seller;
    private EventDTO event;
    private DateDTO date;
    private Integer numberOfTickets;
    private BigDecimal pricePerTicket;
    private BigDecimal totalPrice;
    private Date listingTime;
    
    /**Getters and Setters **/
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDTO getSeller() {
		return seller;
	}
	public void setSeller(UserDTO seller) {
		this.seller = seller;
	}
	public EventDTO getEvent() {
		return event;
	}
	public void setEvent(EventDTO event) {
		this.event = event;
	}
	public DateDTO getDate() {
		return date;
	}
	public void setDate(DateDTO date) {
		this.date = date;
	}
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public BigDecimal getPricePerTicket() {
		return pricePerTicket;
	}
	public void setPricePerTicket(BigDecimal pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public java.util.Date getListingTime() {
		return listingTime;
	}
	public void setListingTime(java.util.Date listingTime) {
		this.listingTime = listingTime;
	}	
	
	

}
