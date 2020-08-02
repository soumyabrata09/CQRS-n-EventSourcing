package com.BankOperation.ACManagement.Commands;

/**
 * @author Sam
 *
 */
public class ACCreationCommand extends BaseCommand<String>{
	
	public final double _acBalance;
	public final String _currency;

	public ACCreationCommand(String id, double accountBal,String currency) {
		super(id);
		this._acBalance = accountBal;
		this._currency = currency;
	}
}
