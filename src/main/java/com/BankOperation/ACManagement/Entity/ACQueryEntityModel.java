/**
 * 
 */
package com.BankOperation.ACManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Sam
 *
 */
@Entity
public class ACQueryEntityModel {

	@Id
	private String id;
	private Double acBalance;
	private String currency;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAcBalance() {
		return acBalance;
	}
	public void setAcBalance(Double acBalance) {
		this.acBalance = acBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	 @Override
	    public String toString() {
	        return "AccountQueryEntity{" +
	                "id='" + id + '\'' +
	                ", accountBalance=" + acBalance +
	                ", currency='" + currency + '\'' +
	                ", status='" + status + '\'' +
	                '}';
	    }
}
