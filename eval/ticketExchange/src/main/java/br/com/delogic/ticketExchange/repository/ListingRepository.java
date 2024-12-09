package br.com.delogic.ticketExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
}
