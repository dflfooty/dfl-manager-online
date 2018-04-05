package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dflmngr.model.entities.DflFixture;
import net.dflmngr.model.entities.keys.DflFixturePK;

@Repository
public interface DflFixtureRepository extends JpaRepository<DflFixture, DflFixturePK> {}
