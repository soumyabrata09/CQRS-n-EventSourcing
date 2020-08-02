package com.BankOperation.ACManagement.Controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BankOperation.ACManagement.DTO.Commands.ACCreationDTO;
import com.BankOperation.ACManagement.DTO.Commands.CreditAmountDTO;
import com.BankOperation.ACManagement.DTO.Commands.DebitAmountDTO;
import com.BankOperation.ACManagement.Services.CommandService.IAccountCommandService;

import io.swagger.annotations.Api;

/**
 * @author Sam
 *
 */
@RestController
@RequestMapping(value = "/accounts")
@CrossOrigin(origins="*")
@Api(value = "Account Operation Commands", tags = "Account Commands", 
	description = " Endpoints related to Account operation commands model")
public class ACCommandController {

	private final IAccountCommandService acccountCommandService;
	public ACCommandController(IAccountCommandService _acccountCommandService){
		this.acccountCommandService = _acccountCommandService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CompletableFuture<String> create(@RequestBody ACCreationDTO acCreationDTO){
		return acccountCommandService.createAC(acCreationDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/credits/{accNumber}")
	public CompletableFuture<String> creditBalance( @PathVariable(value ="accNumber") String accNumber,
					@RequestBody CreditAmountDTO creditAmountDTO){
		return acccountCommandService.creditAmountToAC(accNumber, creditAmountDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/debits/{accNumber}")
	public CompletableFuture<String> debittBalance( @PathVariable(value ="accNumber") String accNumber,
					@RequestBody DebitAmountDTO debitAmountDTO){
		return acccountCommandService.debitAmountFromAC(accNumber, debitAmountDTO);
	}
	
}
