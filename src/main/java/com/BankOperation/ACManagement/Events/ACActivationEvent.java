package com.BankOperation.ACManagement.Events;

import com.BankOperation.ACManagement.Enumeration.Status;

/**
 * @author Sam
 *
 */
public class ACActivationEvent extends BaseEvent<String>{

	public final Status _status;
	public ACActivationEvent(String id,Status status) {
		super(id);
		this._status = status;
	}

}
