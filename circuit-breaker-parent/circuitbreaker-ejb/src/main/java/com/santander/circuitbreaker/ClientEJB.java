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
		
		try {
			return this.clientDAO.searchClientById(connectionReference, 
												id);
		} catch(Exception exception) {
			throw exception;
		}
	}
   
}
