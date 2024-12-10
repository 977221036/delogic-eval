package br.com.delogic.ticketExchange.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
	
	@Query("SELECT v.id FROM Venue v")
    Page<Long> findAllIds(Pageable pageable);	
}
