package org.bgi.dao;

import org.bgi.entities.Ecrans;
import org.bgi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcranRepository extends JpaRepository<Ecrans, Long> {

}
