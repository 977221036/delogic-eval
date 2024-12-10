package br.com.delogic.ticketExchange.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
	
	@Query("SELECT d.id FROM Date d")
    Page<Long> findAllIds(Pageable pageable);
}
