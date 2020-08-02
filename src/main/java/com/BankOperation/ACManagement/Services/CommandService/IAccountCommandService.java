/**
 * 
 */
package com.BankOperation.ACManagement.Services.CommandService;

import java.util.concurrent.CompletableFuture;

import com.BankOperation.ACManagement.DTO.Commands.ACCreationDTO;
import com.BankOperation.ACManagement.DTO.Commands.CreditAmountDTO;
import com.BankOperation.ACManagement.DTO.Commands.DebitAmountDTO;

/**
 * @author Sam
 *
 */
public interface IAccountCommandService {

	public CompletableFuture<String> createAC(ACCreationDTO acCreationDTO);
	public CompletableFuture<String> creditAmountToAC(String accountNumber, CreditAmountDTO creditAmountDTO);
	public CompletableFuture<String> debitAmountFromAC(String accountNumber, DebitAmountDTO debitAmountDTO);
	
}
