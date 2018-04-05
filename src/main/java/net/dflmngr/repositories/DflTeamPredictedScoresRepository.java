package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflTeamPredictedScores;
import net.dflmngr.model.entities.keys.DflTeamPredictedScoresPK;

@Repository
public interface DflTeamPredictedScoresRepository extends JpaRepository<DflTeamPredictedScores, DflTeamPredictedScoresPK> {}
