package tn.arabsoft.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.arabsoft.spring.models.*;

@Repository
public interface IAdmUserProfileRepository extends JpaRepository<AdmUserProfile, Integer> {
	public AdmUserProfile findByLogin(String login);
}
