package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflTeamScores;
import net.dflmngr.model.entities.keys.DflTeamScoresPK;

@Repository
public interface DflTeamScoresRepository extends JpaRepository<DflTeamScores, DflTeamScoresPK> {}
