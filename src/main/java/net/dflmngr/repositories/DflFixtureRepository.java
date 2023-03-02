package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.DflFixture;
import net.dflmngr.model.entities.keys.DflFixturePK;

public interface DflFixtureRepository extends JpaRepository<DflFixture, DflFixturePK> {}
