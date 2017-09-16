package org.bgi.dao;

import org.bgi.entities.Maintenances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceDAO extends JpaRepository<Maintenances, Long> {

}
