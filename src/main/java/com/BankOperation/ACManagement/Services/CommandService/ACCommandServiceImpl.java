package com.BankOperation.ACManagement.Services.CommandService;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.BankOperation.ACManagement.Commands.ACCreationCommand;
import com.BankOperation.ACManagement.Commands.CreditAmountCommand;
import com.BankOperation.ACManagement.Commands.DebitAmountCommand;
import com.BankOperation.ACManagement.DTO.Commands.ACCreationDTO;
import com.BankOperation.ACManagement.DTO.Commands.CreditAmountDTO;
import com.BankOperation.ACManagement.DTO.Commands.DebitAmountDTO;

/**
 * @author Sam
 *
 */
@Service
public class ACCommandServiceImpl implements IAccountCommandService{

	/*
	 * CommandGateway is a convenience Interface provided by the AXON framework.
	 *  Make use of this interface to dispatch commands
	 *  
	 *  AXON automatically provides a DefaultCommandGateway Implementation of the above mentioned Interface
	 *  
	 *  send() of CommandGateway actually sends out commands.
	 * */
	private final CommandGateway commandGateway;
	
	public ACCommandServiceImpl(CommandGateway _commandGateway){
		this.commandGateway = _commandGateway;
	}

	public CompletableFuture<String> createAC(ACCreationDTO acCreationDTO) {
		return commandGateway.send(new ACCreationCommand(
				UUID.randomUUID().toString(),
				acCreationDTO.get_initBalance(),
				acCreationDTO.get_currency()
				));
	}

	public CompletableFuture<String> creditAmountToAC(String accountNumber, CreditAmountDTO creditAmountDTO) {
		return commandGateway.send(new CreditAmountCommand(
				accountNumber,
				creditAmountDTO.get_creditedAmount(),
				creditAmountDTO.get_currency()
				));
	}

	public CompletableFuture<String> debitAmountFromAC(String accountNumber, DebitAmountDTO debitAmountDTO) {
		return commandGateway.send(new DebitAmountCommand(
				accountNumber,
				debitAmountDTO.get_debitedAmount(),
				debitAmountDTO.get_currency()
				));
	}

}
