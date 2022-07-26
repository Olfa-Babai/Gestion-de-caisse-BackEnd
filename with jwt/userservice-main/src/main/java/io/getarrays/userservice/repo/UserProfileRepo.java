package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.AdmUserProfile;


public interface UserProfileRepo extends JpaRepository<AdmUserProfile, Long> {

}
