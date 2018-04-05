package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.AflPlayer;

@Repository
public interface AflPlayerRepository extends JpaRepository<AflPlayer, Integer>{
	AflPlayer findByDflPlayerId(Integer playerId);
}
