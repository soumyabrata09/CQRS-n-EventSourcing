package com.BankOperation.ACManagement.Events;

import com.BankOperation.ACManagement.Enumeration.Status;

/**
 * @author Sam
 *
 */
public class ACHeldEvent extends BaseEvent<String>{

	public final Status _status;
	
	public ACHeldEvent(String id, Status status) {
		super(id);
		this._status = status;
	}

}
