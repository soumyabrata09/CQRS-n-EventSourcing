/**
 * 
 */
package com.BankOperation.ACManagement.DTO.Commands;

/**
 * @author Sam
 *
 */
public class ACCreationDTO {
	
	private double _initBalance;
	private String _currency;
	
	public double get_initBalance() {
		return _initBalance;
	}
	public void set_initBalance(double _initBalance) {
		this._initBalance = _initBalance;
	}
	public String get_currency() {
		return _currency;
	}
	public void set_currency(String _currency) {
		this._currency = _currency;
	}
}
