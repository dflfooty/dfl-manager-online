package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflTeamScores;
import net.dflmngr.model.entities.keys.DflTeamScoresPK;

public interface DflTeamScoresRepository extends JpaRepository<DflTeamScores, DflTeamScoresPK> {}
