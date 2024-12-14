package br.com.delogic.ticketExchange.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
	
	@Query("SELECT l.id FROM Listing l")
    Page<Long> findAllIds(Pageable pageable);
	
	/*
	 SQL equivalent to HQL 
	    Listing -> Event (Category.id) INNER JOIN
	    Event -> Venue (City) INNER JOIN 
	    LIsting -> Sale LEFT JOIN	  
	*/	
	@Query("SELECT l.id FROM Listing l " +	         
	        "JOIN l.event e " +
	        "JOIN e.venue v " + 
	        "LEFT JOIN Sale s ON s.listing.id = l.id " +
	        "WHERE " +
	        "(e.eventStart <= :contextualDate ) " +  //Mandatory 
	        "AND (:categoryId IS NULL OR e.category.id = :categoryId) " +  //Optional
	        "AND (:cityName IS NULL OR v.city = :cityName) "+  //Optional
	        "AND (s.id IS NULL) " +
	        "ORDER BY "+
	        "e.eventStart DESC LIMIT 10 ")
	 List<Long> findAllUnsoldListings(
			 @Param("contextualDate") Date contextualDate,@Param("categoryId") Long categoryId,@Param("cityName") String cityName);
	
}
