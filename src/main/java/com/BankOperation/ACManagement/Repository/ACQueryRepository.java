/**
 * 
 */
package com.BankOperation.ACManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BankOperation.ACManagement.Entity.ACQueryEntityModel;

/**
 * @author Sam
 *
 */
@Repository
public interface ACQueryRepository extends JpaRepository<ACQueryEntityModel,String>{

}
