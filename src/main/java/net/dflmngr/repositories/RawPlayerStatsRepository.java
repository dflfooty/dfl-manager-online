package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.RawPlayerStats;
import net.dflmngr.model.entities.keys.RawPlayerStatsPK;

@Repository
public interface RawPlayerStatsRepository extends JpaRepository<RawPlayerStats, RawPlayerStatsPK> {
	RawPlayerStats findByRoundAndTeamAndJumperNo(int round, String team, int jumperNo);
}
