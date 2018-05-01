package net.dflmngr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dflmngr.model.entities.Globals;
import net.dflmngr.model.entities.keys.GlobalsPK;

public interface GlobalsRespository extends JpaRepository<Globals, GlobalsPK>  {}
