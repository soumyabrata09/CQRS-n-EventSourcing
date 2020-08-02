/**
 * 
 */
package com.BankOperation.ACManagement.Services.QueryService;

import java.util.List;

/**
 * @author Sam
 *
 */
public interface IAccountQueryService {

	public List<Object> listACEvents(String acNumber);
	
}
