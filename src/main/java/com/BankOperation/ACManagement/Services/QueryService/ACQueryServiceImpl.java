/**
 * 
 */
package com.BankOperation.ACManagement.Services.QueryService;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

/**
 * @author Sam
 *
 */
@Service
public class ACQueryServiceImpl implements IAccountQueryService{

	private final EventStore eventStote;
	
	public ACQueryServiceImpl(EventStore _eventStore){
		this.eventStote = _eventStore;
	}
	
	public List<Object> listACEvents(String acNumber) {
		return eventStote.readEvents(acNumber)
				.asStream()
				.map(e -> e.getPayload())
				.collect(Collectors.toList());
	}

}
