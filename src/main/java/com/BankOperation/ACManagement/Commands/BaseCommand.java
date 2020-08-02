package com.BankOperation.ACManagement.Commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author Sam
 *
 */
public class BaseCommand<T> {

	@TargetAggregateIdentifier
	public final T _id;
	
	public BaseCommand(T id){
		this._id = id;
	}
}
