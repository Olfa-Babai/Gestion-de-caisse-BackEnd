package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.PayCashing;

public interface PayCashingRepo extends JpaRepository<PayCashing, Long> {

}
