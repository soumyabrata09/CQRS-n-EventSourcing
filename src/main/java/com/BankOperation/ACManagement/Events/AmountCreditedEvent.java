package com.BankOperation.ACManagement.Events;

/**
 * @author Sam
 *
 */
public class AmountCreditedEvent extends BaseEvent<String>{

	public final double _amountCredited;
	public final String _currency;
	
	public AmountCreditedEvent(String id,double amountCredited, String currency) {
		super(id);
		this._amountCredited = amountCredited;
		this._currency = currency;
	}

}
