package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflPlayerPredictedScores;
import net.dflmngr.model.entities.keys.DflPlayerPredictedScoresPK;

public interface DflPlayerPredictedScoresRepository extends JpaRepository<DflPlayerPredictedScores, DflPlayerPredictedScoresPK> {}
