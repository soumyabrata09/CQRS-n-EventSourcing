/**
 * 
 */
package com.BankOperation.ACManagement.DTO.Commands;

/**
 * @author Sam
 *
 */
public class CreditAmountDTO {

	private double _creditedAmount;
	private String _currency;
	public double get_creditedAmount() {
		return _creditedAmount;
	}
	public void set_creditedAmount(double _creditedAmount) {
		this._creditedAmount = _creditedAmount;
	}
	public String get_currency() {
		return _currency;
	}
	public void set_currency(String _currency) {
		this._currency = _currency;
	}
	
}
