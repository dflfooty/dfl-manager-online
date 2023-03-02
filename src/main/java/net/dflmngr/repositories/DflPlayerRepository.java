package net.dflmngr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflPlayer;

public interface DflPlayerRepository extends JpaRepository<DflPlayer, Integer> {
	List<DflPlayer> findByPlayerIdIn(List<Integer> playerIds);
}