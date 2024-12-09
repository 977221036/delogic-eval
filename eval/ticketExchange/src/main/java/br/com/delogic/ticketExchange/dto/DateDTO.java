package br.com.delogic.ticketExchange.dto;

public class DateDTO {
	
	private Long id;
    private java.util.Date date;
    private String day;
    private Integer week;
    private String month;
    private Integer quarter;
    private Integer year;
    private Boolean holiday;
    
    /**Getters and Setters **/ 
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getQuarter() {
		return quarter;
	}
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Boolean getHoliday() {
		return holiday;
	}
	public void setHoliday(Boolean holiday) {
		this.holiday = holiday;
	}
	  
    
	  

}
