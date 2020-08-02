package com.BankOperation.ACManagement.Configs;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BankOperation.ACManagement.Aggregates.ACOPsAggregate;

/**
 * @author Sam
 *
 */
@Configuration
public class AxonConfig {

	@Bean
	EventSourcingRepository<ACOPsAggregate> accAggrEventSourcingRepository(EventStore eventStore){
		EventSourcingRepository<ACOPsAggregate> repo = EventSourcingRepository.builder(ACOPsAggregate.class).eventStore(eventStore).build();
		
		return repo;
	}
}
