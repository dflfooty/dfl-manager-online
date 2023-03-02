package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.AflPlayer;

public interface AflPlayerRepository extends JpaRepository<AflPlayer, Integer>{
	AflPlayer findByDflPlayerId(Integer playerId);
}
