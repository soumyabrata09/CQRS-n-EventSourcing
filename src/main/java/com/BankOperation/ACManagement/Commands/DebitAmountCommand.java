package com.BankOperation.ACManagement.Commands;

/**
 * @author Sam
 *
 */
public class DebitAmountCommand extends BaseCommand<String> {

	public final double _debitAmount;
	public final String _currency;
	
	public DebitAmountCommand(String id, double debitAmount, String currency) {
		super(id);
		this._debitAmount = debitAmount;
		this._currency = currency;
	}

}
