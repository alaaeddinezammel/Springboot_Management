package org.bgi.dao;

import org.bgi.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface MachineRepository extends JpaRepository<Machine, Long> {
 
    @Procedure(name = "deletel")
    void deletel(@Param("idm") Long idm,@Param("idl") Long idl);

    
    @Procedure(name = "deletep")
    void deletep(@Param("idm") Long idm,@Param("idp") Long idp);

    @Procedure(name = "deleteu")
    void deleteu(@Param("idm") Long idm,@Param("idu") Long idu);

	
	//@Query("delete  from Machine o where  o.numL=:x and Machine.numMachine=:y")
//	public void deleteLogfromM(@Param("x") Long numL,@Param("y") Long  numMachine );
}
