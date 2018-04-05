package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflPlayerPredictedScores;
import net.dflmngr.model.entities.keys.DflPlayerPredictedScoresPK;

@Repository
public interface DflPlayerPredictedScoresRepository extends JpaRepository<DflPlayerPredictedScores, DflPlayerPredictedScoresPK> {}
