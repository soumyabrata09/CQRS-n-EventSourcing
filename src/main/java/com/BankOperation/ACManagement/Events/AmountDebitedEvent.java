package com.BankOperation.ACManagement.Events;

/**
 * @author Sam
 *
 */
public class AmountDebitedEvent extends BaseEvent<String>{

	public final double _debitedAmount;
	public final String _currency;
	
	public AmountDebitedEvent(String id, double debitedAmount, String currency) {
		super(id);
		this._debitedAmount = debitedAmount;
		this._currency = currency;
	}
}
