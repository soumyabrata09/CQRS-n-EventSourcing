package com.BankOperation.ACManagement.Aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.BankOperation.ACManagement.Commands.ACCreationCommand;
import com.BankOperation.ACManagement.Commands.CreditAmountCommand;
import com.BankOperation.ACManagement.Commands.DebitAmountCommand;
import com.BankOperation.ACManagement.Enumeration.Status;
import com.BankOperation.ACManagement.Events.ACActivationEvent;
import com.BankOperation.ACManagement.Events.ACCreationEvent;
import com.BankOperation.ACManagement.Events.ACHeldEvent;
import com.BankOperation.ACManagement.Events.AmountCreditedEvent;
import com.BankOperation.ACManagement.Events.AmountDebitedEvent;

/**
 * @author Sam
 *
 *@Aggregate / @AggregateIdentifier equivalent to @Entity and @Id of JPA
 *These are two AXOn annotations
 */
@Aggregate
public class ACOPsAggregate {

	@AggregateIdentifier
	private String id;
	private Double acBalance;
	private String currency;
	private String status;
	
	public ACOPsAggregate(){
		//Axon Framework requires a default/no-args Constructor to be explicitly declared
	}
	
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
	
	@CommandHandler
	// A/C Creation Command
	public ACOPsAggregate(ACCreationCommand _acCreationCommand){
		//Event Registration :: A/C Creation
		AggregateLifecycle.apply(
				new ACCreationEvent(
						_acCreationCommand._id,
						_acCreationCommand._acBalance,
						_acCreationCommand._currency
						));	
	}
	
	@EventSourcingHandler
	// A/C Creation Event Handler
	protected void on(ACCreationEvent _acCreationEvent){
		this.id = _acCreationEvent._id;
		this.acBalance = _acCreationEvent._acBalance;
		this.currency = _acCreationEvent._currency;
		this.status = String.valueOf(Status.CREATED);
		
		//Another cascaded Event Registration :: A/C Activation
		AggregateLifecycle.apply(
				new ACActivationEvent(
						this.id,
						Status.ACTIVATED
						));
	}
	
	@EventSourcingHandler
	// A/C Activation Event Handler
	protected void on(ACActivationEvent _acActivationEvent){
		this.status = String.valueOf(_acActivationEvent._status);
	}
	
	@CommandHandler
	// Credit Command
	protected void on(CreditAmountCommand _creditAmountCommand){
		//Event Registration :: Credit
		AggregateLifecycle.apply(new AmountCreditedEvent(
				_creditAmountCommand._id,
				_creditAmountCommand._creditAmount,
				_creditAmountCommand._currency
				));
	}
	
	@EventSourcingHandler
	// Credit Amount Event Handler
	protected void on(AmountCreditedEvent _amountCreditedEvent){
		if(this.acBalance < 0 & (this.acBalance + _amountCreditedEvent._amountCredited) >= 0){
			//Event Registration :: A/C Activation
			AggregateLifecycle.apply(
					new ACActivationEvent(
							this.id,
							Status.ACTIVATED
							));
		}
		
		this.acBalance += _amountCreditedEvent._amountCredited;
	}
	
	@CommandHandler
	// Debit Command
	protected void on(DebitAmountCommand _debitAmountCommand){
		//Event Registration :: Debit Amount Event
		AggregateLifecycle.apply(
				new AmountDebitedEvent(
						_debitAmountCommand._id,
						_debitAmountCommand._debitAmount,
						_debitAmountCommand._currency
						));
	}
	
	@EventSourcingHandler
	// Debit Amount Event Handler
	protected void on(AmountDebitedEvent _amountDebitedEvent){
		if(this.acBalance >= 0 & (this.acBalance - _amountDebitedEvent._debitedAmount) < 0){
			//Event Registration :: A/C Held Event
			AggregateLifecycle.apply(
					new ACHeldEvent(
							this.id,
							Status.HOLD
							));
		}
		
		this.acBalance -= _amountDebitedEvent._debitedAmount;
	}
	
	@EventSourcingHandler
	protected void on(ACHeldEvent _acHeldEvent){
		this.status = String.valueOf(_acHeldEvent._status);
	}
	
}
