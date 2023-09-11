package com.gdav.training.accounts.service;

import java.util.List;

import com.gdav.training.accounts.model.AccountContract;
import com.gdav.training.accounts.exception.AccountDoesNotExistException;

/**
 * @author David G
 * 
 * Interfaz publica para las operaciones de negocio de la entidad Account
 */
public interface IAccountsService {


	/**
	 * Consulta de entidad de negocio
	 * 
	 * @param id El id de la entidad a consultar
	 * @return Objeto de la entidad consultada
	 * @throws AccountDoesNotExistException  Exception when the resource doesn't exist
	 */
	AccountContract getAccountById(Long id) throws AccountDoesNotExistException;

	/**
	 * Consulta de listado de entidades de negocio
	 * 
	 * @param id El id de la entidad a consultar
	 * @return Objeto de la entidad consultada
	 * @throws AccountDoesNotExistException Exception when the resource doesn't exist
	 */
	List<AccountContract> listAccounts() throws AccountDoesNotExistException;




	/**
	 * Creacion de entidad de negocio
	 * @param account El objeto de la entidad a crear
	 * @return Id Entidad creada
	 */
	Long  createAccount(AccountContract account);



	/**
	 * Actualizacion de entidad de negocio
	 * 
	 * @param account El objeto de la entidad a actualizar
	 * @return account El objeto en su estado actual
	 * @throws AccountDoesNotExistException  Exception when the resource doesn't exist
	 */
	 void updateAccount(AccountContract account) throws AccountDoesNotExistException;




	/**
	 * Eliminacion de entidad de negocio
	 * 
	 * @param id El id de la entidad a eliminar
	 * @throws AccountDoesNotExistException  Exception when the resource doesn't exist
	 */
	void deleteAccount(Long id) throws AccountDoesNotExistException;


}
