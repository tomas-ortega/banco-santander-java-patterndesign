package com.santander.circuitbreaker.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.santander.circuitbreaker.ClientDTO;

public interface IClientDAO {
	public ClientDTO searchClientById(Connection connectionReference,
									  String id) throws SQLException;
}
