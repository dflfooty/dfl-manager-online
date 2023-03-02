package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflPlayerScores;
import net.dflmngr.model.entities.keys.DflPlayerScoresPK;

public interface DflPlayerScoresRepository extends JpaRepository<DflPlayerScores, DflPlayerScoresPK> {}
