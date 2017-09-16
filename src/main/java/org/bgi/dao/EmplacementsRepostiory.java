package org.bgi.dao;

import org.bgi.entities.Emplacements;
import org.bgi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplacementsRepostiory extends JpaRepository<Emplacements, Long> {

}
