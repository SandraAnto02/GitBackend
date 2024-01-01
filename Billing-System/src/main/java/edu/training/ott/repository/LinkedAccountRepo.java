package edu.training.ott.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.training.ott.model.LinkedAccount;

@Repository
public interface LinkedAccountRepo extends JpaRepository<LinkedAccount, Integer> {

}
