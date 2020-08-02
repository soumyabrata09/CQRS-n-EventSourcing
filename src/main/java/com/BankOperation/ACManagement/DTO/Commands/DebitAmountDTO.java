/**
 * 
 */
package com.BankOperation.ACManagement.DTO.Commands;

/**
 * @author Sam
 *
 */
public class DebitAmountDTO {

	private double _debitedAmount;
	private String _currency;
	public double get_debitedAmount() {
		return _debitedAmount;
	}
	public void set_debitedAmount(double _debitedAmount) {
		this._debitedAmount = _debitedAmount;
	}
	public String get_currency() {
		return _currency;
	}
	public void set_currency(String _currency) {
		this._currency = _currency;
	}
	
	
}
