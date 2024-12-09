package br.com.delogic.ticketExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.delogic.ticketExchange.domain.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
}
