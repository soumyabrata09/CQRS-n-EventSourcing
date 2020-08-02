package com.BankOperation.ACManagement.Aggregates;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @author Sam
 *
 *@Aggregate / @AggregateIdentifier equivalent to @Entity and @Id of JPA
 *These are two AXOn annotations
 */
@Aggregate
public class ACOPsAggregate {

	@AggregateIdentifier
	private String _id;
	private Double _acBalance;
	private String _currency;
	private String _status;
}
