package br.com.delogic.ticketExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
