package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflTeamPredictedScores;
import net.dflmngr.model.entities.keys.DflTeamPredictedScoresPK;

public interface DflTeamPredictedScoresRepository extends JpaRepository<DflTeamPredictedScores, DflTeamPredictedScoresPK> {}
