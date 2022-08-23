package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.*;

public interface PartyRepo extends JpaRepository<Party, Long>  {

}
