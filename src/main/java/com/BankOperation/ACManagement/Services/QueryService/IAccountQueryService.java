/**
 * 
 */
package com.BankOperation.ACManagement.Services.QueryService;

import java.util.List;

import com.BankOperation.ACManagement.Entity.ACQueryEntityModel;

/**
 * @author Sam
 *
 */
public interface IAccountQueryService {

	public List<Object> listACEvents(String acNumber);
	public ACQueryEntityModel getAccount(String ACNumber);
	
}
