/**
 * 
 */
package com.BankOperation.ACManagement.Events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author Sam
 *
 */
public class BaseEvent<T> {

	@TargetAggregateIdentifier
	public final T _id;
	
	public BaseEvent(T id){
		this._id = id;
	}
}
