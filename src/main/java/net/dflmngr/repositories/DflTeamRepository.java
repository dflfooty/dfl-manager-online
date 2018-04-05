package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflTeam;

@Repository
public interface DflTeamRepository extends JpaRepository<DflTeam, String> {}
