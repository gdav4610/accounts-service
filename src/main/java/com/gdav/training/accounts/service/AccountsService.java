package com.gdav.training.accounts.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.gdav.training.accounts.exception.AccountDoesNotExistException;





import com.gdav.training.accounts.model.Account;
import com.gdav.training.accounts.model.AccountContract;





/**
 * @author David G
 * 
 * Esta es la clase principal de este microservicio, encargada de orquestador la logica de negocio relacionada 
 * solamente a accounts y sus datos (persistencia)
 * 
 * En esta clase puede haber invocacion a otros componentes con sufijo *Service,
 * los cuales a su vez pudieran invocar a otros microservicios o APIs, pero sin contener logica de negocio.
 */
@Service
public class AccountsService implements IAccountsService {


	/** La Constante LOGGER. Obtiene el Logger de la clase */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountsService.class);
	






	@Override
	public AccountContract getAccountById(Long id) 
								throws AccountDoesNotExistException {

						


		//TODO: Colocar logica de negocio relacionada al dominio funcional de Accounts


		return new AccountContract();

	}
	
	
					
	@Override
	public List<AccountContract> listAccounts() 
								throws AccountDoesNotExistException{

		return null;
		
	}
		
		
								


	@Override
	public Long  createAccount(AccountContract accountContract) {

		//TODO: Colocar logica de negocio relacionada al dominio funcional de Accounts
	
		return null;

	}

	


	@Override
	public void updateAccount(AccountContract accountContract) 
							throws AccountDoesNotExistException{


	}

		


	@Override
	public void deleteAccount(Long id) 
							throws AccountDoesNotExistException{

		//TODO: Colocar logica de negocio relacionada al dominio funcional de Accounts

	}
		

}
