package com.BankOperation.ACManagement.Commands;

/**
 * @author Sam
 *
 */
public class CreditAmountCommand extends BaseCommand<String>{

	public final double _creditAmount;
	public final String _currency;
	
	public CreditAmountCommand(String id, double creditAmount, String currency) {
		super(id);
		this._creditAmount = creditAmount;
		this._currency = currency;
	}
}
