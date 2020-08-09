/**
 * 
 */
package com.BankOperation.ACManagement.Services.QueryService;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.BankOperation.ACManagement.Entity.ACQueryEntityModel;
import com.BankOperation.ACManagement.Repository.ACQueryRepository;

/**
 * @author Sam
 *
 */
@Service
public class ACQueryServiceImpl implements IAccountQueryService{

	private final EventStore eventStote;
	private final ACQueryRepository acQueryRepository;
	
	public ACQueryServiceImpl(EventStore _eventStore,ACQueryRepository _acQueryRepository){
		this.eventStote = _eventStore;
		this.acQueryRepository =_acQueryRepository;
	}

	@Override
	public ACQueryEntityModel getAccount(String ACNumber) {
		
		return acQueryRepository.findById(ACNumber).get();
	}

	@Override
	public List<Object> listACEvents(String acNumber) {
		return eventStote.readEvents(acNumber)
				.asStream()
				.map(e -> e.getPayload())
				.collect(Collectors.toList());
	}

}
