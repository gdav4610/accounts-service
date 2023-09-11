package com.gdav.training.accounts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gdav.training.accounts.config.AccountsConfig;
import com.gdav.training.accounts.exception.AccountDoesNotExistException;
import com.gdav.training.accounts.service.IAccountsService;
import com.gdav.training.accounts.service.AccountsService;




@SpringBootTest
public class AccountsServiceTest {


	/** La Constante LOGGER. Obtiene el Logger de la clase */
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountsServiceTest.class);	


    @Autowired
    private IAccountsService service;

    @MockBean
	private AccountsConfig config;





	@TestConfiguration
    static class AccountsServiceConfig {
        @Bean
        public IAccountsService accountsService() {
            return new AccountsService();
        }
    }


    @Test
    public void getAccount() throws AccountDoesNotExistException {

    }
    
    
    @Test
    public void getAccountDoesNotExistException() throws AccountDoesNotExistException{

    }





	@Test
	public void createAccount() {


	}





    @Test
    public void updateAccount() throws AccountDoesNotExistException  {

    }

    
    @Test
    public void updateAccountDoesNotExistException() throws AccountDoesNotExistException  {

    }

    
    
    
   

    @Test
    public void deleteAccount() throws AccountDoesNotExistException  {

    }

    
    @Test
    public void deleteAccountDoesNotExistException() throws AccountDoesNotExistException  {

    }



}