package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.*;

public interface PayCashDebtRepo extends JpaRepository<PayCashDebt, Long> {

}
