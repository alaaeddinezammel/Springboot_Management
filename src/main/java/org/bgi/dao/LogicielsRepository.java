package org.bgi.dao;

import org.bgi.entities.Logiciels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;





public interface LogicielsRepository extends JpaRepository<Logiciels, Long> {

	

}
