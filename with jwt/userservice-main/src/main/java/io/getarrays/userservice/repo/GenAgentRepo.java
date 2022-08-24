package io.getarrays.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.GenAgent;

public interface GenAgentRepo extends JpaRepository<GenAgent, Long> {
	public GenAgent findByAgelogin(String name);
}
