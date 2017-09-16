package org.bgi.dao;

import org.bgi.entities.Machine;
import org.bgi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
