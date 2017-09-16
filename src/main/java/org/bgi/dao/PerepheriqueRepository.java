package org.bgi.dao;

import org.bgi.entities.Perepherique;
import org.bgi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerepheriqueRepository extends JpaRepository<Perepherique, Long> {

}
