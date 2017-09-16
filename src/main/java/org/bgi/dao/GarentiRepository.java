package org.bgi.dao;


import org.bgi.entities.Garantie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarentiRepository  extends JpaRepository<Garantie, Long> {

}
