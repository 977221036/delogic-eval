package br.com.delogic.ticketExchange.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query("SELECT e.id FROM Event e")
    Page<Long> findAllIds(Pageable pageable);
}
