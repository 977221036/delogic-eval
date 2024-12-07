package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Listing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ListingRepositoryTest {

    @Autowired
    private ListingRepository listingRepository;

    @Test
    public void testSaveAndFindListing() {
        Listing listing = new Listing();
        listing.setTotalPrice(BigDecimal.valueOf(100));
        listingRepository.save(listing);

        Optional<Listing> foundListing = listingRepository.findById(listing.getId());
        assertThat(foundListing).isPresent();
        assertThat(foundListing.get().getTotalPrice()).isEqualTo(BigDecimal.valueOf(100));
    }

    @Test
    public void testFindAllIds() {
        Listing listing1 = new Listing();
        listing1.setTotalPrice(BigDecimal.valueOf(100));
        listingRepository.save(listing1);

        Listing listing2 = new Listing();
        listing2.setTotalPrice(BigDecimal.valueOf(200));
        listingRepository.save(listing2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = listingRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(listing1.getId(), listing2.getId());
    }
}