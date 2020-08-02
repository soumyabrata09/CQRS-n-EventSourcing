package com.BankOperation.ACManagement.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BankOperation.ACManagement.Services.QueryService.IAccountQueryService;

import io.swagger.annotations.Api;

/**
 * @author Sam
 *
 */
@RestController
@RequestMapping(value = "/accounts")
@CrossOrigin(origins="*")
@Api(value = "Account Operation Queries", tags = "Account Queries", 
	description = " Endpoints related to Account operation commands model")
public class ACQueryController {

	private final IAccountQueryService accountQueryService;
	
	public ACQueryController(IAccountQueryService _accountQueryService){
		this.accountQueryService = _accountQueryService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{accNumber}/events")
	public List<Object> eventLists(@PathVariable(value = "accNumber") String accNumber){
		return accountQueryService.listACEvents(accNumber);
	}
}
