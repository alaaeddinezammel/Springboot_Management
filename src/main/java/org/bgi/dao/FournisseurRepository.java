package org.bgi.dao;

import org.bgi.entities.Fournisseur;
import org.bgi.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
