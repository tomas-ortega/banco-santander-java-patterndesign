package com.santander.circuitbreaker;

import java.sql.Connection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.santander.circuitbreaker.dao.IClientDAO;

@Stateless(name = "ClientEJB")
public class ClientEJB implements IClientLogic {
	IClientDAO clientDAO;
	
	@Inject
	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	@Override
	public ClientDTO searchClientById(String id) throws Exception {
		Connection connectionReference = null;
		ClientDTO clientFound = null;
		
		try {
			clientFound = this.clientDAO.searchClientById(connectionReference, 
													id);
			clientFound.id = "asdf";
			
			return clientFound;
		} catch(Exception exception) {
			throw exception;
		}
	}
   
}
