package com.gdav.training.accounts.controller;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import com.gdav.training.accounts.exception.AccountDoesNotExistException;


import org.springframework.web.bind.annotation.GetMapping;
import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdav.training.accounts.model.Account;
import com.gdav.training.accounts.model.AccountContract;
import com.gdav.training.accounts.service.IAccountsService;



/**
 * @author David G
 * 
 * This controller handles the REST endpoints of the microservice for the accounts collection
 */
@RestController
@RequestMapping("/accounts")
public class AccountsController {
	 
	/** LOGGER constant */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountsController.class);
	
	@Autowired
	private IAccountsService accountsService;
	

	
    /**
     * Implementation of the HTTP GET by id controller method 
	 * 
	 * This method is idempotent, y ALL its inner processes should NEVER modify the state of a server-side resource
	 * 
     * @param id - Id of account to query
     * @return Operation code and JSON object
     * @throws AccountDoesNotExistException - Not existing resource
     */
		@GetMapping(value = "/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AccountContract> getAccountById(@PathVariable("id") Long id) 
							throws AccountDoesNotExistException{
								
        LOGGER.debug("In getAccountById controller method");
        
        AccountContract account = accountsService.getAccountById(id);
        
        
        return new ResponseEntity<>(account, HttpStatus.OK);
		
    }

    /**
     * Implementation of the listing HTTP GET controller method
	 * 
	 * This method is idempotent, y ALL its inner processes should NEVER modify the state of a server-side resource
	 * 
     * @return Operation code and JSON object with list of resources
     * @throws AccountDoesNotExistException - When the resource doesn't exist
     */
		@GetMapping(value = "",
				produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<AccountContract>> listAccounts() 
							throws AccountDoesNotExistException{
								
        LOGGER.debug("listAccounts");
        
        List<AccountContract> accounts = accountsService.listAccounts();
        
        
        return new ResponseEntity<>(accounts, HttpStatus.OK);
		
    }
							

    

    /**
     * Implementation of HTTP POST controller method, to create a resource under the collection /accounts
	 * 
 	 * This method is non-safe y NON idempotent. Its inner processes will ALWAYS affect the state of a server-side resource.
	 * 
     * @param accountContract - The Account to create
     * @param ucBuilder Generador de URIs
     * @return Operation code, and the Location header with the newly created URI
     */
		@PostMapping(value = "",
						consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Long> createAccount(@Valid @RequestBody AccountContract accountContract, 
								UriComponentsBuilder ucBuilder) {

    	LOGGER.debug("In createAccount: {}", accountContract.toString());
    	
    	
    	Long idGenerated = accountsService.createAccount(accountContract);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(idGenerated).toUri();
		
		return ResponseEntity.created(location).build();
		
    }



    /**
     * Implementation of HTTP PUT controller method, to update an existing resource under the collection /accounts
	 * 
 	 * This method is idempotent. Its inner processes could modify the state of a server-side resource.
 	 * 
     * @param id - account Id to update
     * @param accountContract - AccountContract object to update
     * @return HTTP code indicating if the operation was successful
     * @throws AccountDoesNotExistException - When the resource doesn't exist
     */
		@PutMapping(value = "/{id}",
					consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAccount(@PathVariable("id") String id, 
				@Valid @RequestBody AccountContract accountContract) throws AccountDoesNotExistException{
		
    	LOGGER.debug("In updateAccount: {}", accountContract.toString());

		accountsService.updateAccount(accountContract);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }


    /**
     * Implementation of HTTP DELETE contoller method, to delete an existing resource under the collection /accounts
	 * 
 	 * This method is idempotent. Its inner processes could modify the state of a server-side resource.
	 * 
     * @param id - account Id to delete
     * @return HTTP code indicating if the operation was successful
     * @throws AccountDoesNotExistException Exception when the resource doesn't exist
     */
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id) 
    						throws AccountDoesNotExistException{
					
    	LOGGER.debug("In deleteAccount");
        
		accountsService.deleteAccount(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }





}