package br.com.delogic.ticketExchange.dto;

import java.math.BigDecimal;
import java.util.Date;



public class SaleDTO {


    private Long Id;
    private ListingDTO listing;
    private UserDTO seller;
    private UserDTO buyer;
    private EventDTO event;
    private DateDTO date;
    private Integer quantitySold;
    private BigDecimal pricePaid;
    private BigDecimal commissionAmount;
    private Date saleTime;
    
    /**Getters and Setters **/
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public ListingDTO getListing() {
		return listing;
	}
	public void setListing(ListingDTO listing) {
		this.listing = listing;
	}
	public UserDTO getSeller() {
		return seller;
	}
	public void setSeller(UserDTO seller) {
		this.seller = seller;
	}
	public UserDTO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserDTO buyer) {
		this.buyer = buyer;
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
	public Integer getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}
	public BigDecimal getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(BigDecimal pricePaid) {
		this.pricePaid = pricePaid;
	}
	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}
	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
    
    
    
    
    
}
