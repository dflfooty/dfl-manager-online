package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflPlayerScores;
import net.dflmngr.model.entities.keys.DflPlayerScoresPK;

@Repository
public interface DflPlayerScoresRepository extends JpaRepository<DflPlayerScores, DflPlayerScoresPK> {}
