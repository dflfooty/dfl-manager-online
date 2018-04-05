package net.dflmngr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflSelectedPlayer;
import net.dflmngr.model.entities.keys.DflSelectedPlayerPK;

@Repository
public interface DflSelectedPlayerRepository extends JpaRepository<DflSelectedPlayer, DflSelectedPlayerPK> {
	List<DflSelectedPlayer> findByRoundAndTeamCode(int round, String teamCode);
}
