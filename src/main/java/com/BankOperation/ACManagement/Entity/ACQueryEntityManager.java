/**
 * 
 */
package com.BankOperation.ACManagement.Entity;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.BankOperation.ACManagement.Aggregates.ACOPsAggregate;
import com.BankOperation.ACManagement.Events.BaseEvent;
import com.BankOperation.ACManagement.Repository.ACQueryRepository;

/**
 * @author Sam
 *
 */
@Component
public class ACQueryEntityManager {

	@Autowired
	ACQueryRepository acQueryRepository;// Injecting Repository instance
	
	@Autowired
	@Qualifier("accAggrEventSourcingRepository")
	private EventSourcingRepository<ACOPsAggregate> accAggrEventSourcingRepository;
	
	@EventSourcingHandler
	public void on(BaseEvent<?> event) { // A HAndler function to handle events on our Aggregate Function [ACOPsAggregate.java]
		persistAccountDetails(ACQueryBuilder(getAccountDetails(event)));
	}

	private void persistAccountDetails(ACQueryEntityModel ACQueryEntityModel) {
		acQueryRepository.save(ACQueryEntityModel);
	}

	private ACQueryEntityModel ACQueryBuilder(ACOPsAggregate aggregate) {
		
		ACQueryEntityModel entity =  fetchExistingOrCreateNew(aggregate.getId());
		entity.setId(aggregate.getId());
		entity.setAcBalance(aggregate.getAcBalance());
		entity.setCurrency(aggregate.getCurrency());
		entity.setStatus(aggregate.getStatus());
		
		return entity;
	}

	private ACQueryEntityModel fetchExistingOrCreateNew(String id) {
		ACQueryEntityModel entity;
		if(acQueryRepository.findById(id).isPresent()) {
			entity = acQueryRepository.findById(id).get();
		}else {
			entity = new ACQueryEntityModel();
		}
		return entity;
	}

	private ACOPsAggregate getAccountDetails(BaseEvent<?> event) {

		return accAggrEventSourcingRepository.load(event._id.toString())
				.getWrappedAggregate()
				.getAggregateRoot();
	}
	   	
}
