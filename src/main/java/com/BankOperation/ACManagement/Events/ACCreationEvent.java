package com.BankOperation.ACManagement.Events;

/**
 * @author Sam
 *
 */
public class ACCreationEvent extends BaseEvent<String>{

	public final double _acBalance;
	public final String _currency;
	
	public ACCreationEvent(String id, double acBalance, String currency) {
		super(id);
		this._acBalance = acBalance;
		this._currency = currency;
	}

}
