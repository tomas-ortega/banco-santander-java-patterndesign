package com.santander.circuitbreaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;

import com.santander.circuitbreaker.dao.IClientDAO;

@Stateless(name = "ClientDAO")
public class ClientDAO implements IClientDAO {

	@Override
	public ClientDTO searchClientById(Connection connectionReference, 
									  String id) throws SQLException {
		StringBuilder sql = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		ClientDTO foundClient = null;
		
		try {
			sql = new StringBuilder();
			
			sql.append("SELECT ");
			
			sql.append("client.id,");
			sql.append("client.name");
			
			sql.append(" FROM ");
			sql.append("client");
			
			sql.append(" WHERE ");
			
			sql.append("client.id = ?");
			
			//Preparado de sentencia
			
			pstm = connectionReference.prepareStatement(sql.toString());
			
			pstm.setString(1, id);
			
			//Ejecucion
			resultSet = pstm.executeQuery();
			
			while(resultSet.next()) {
				foundClient = new ClientDTO();
				
				foundClient.id = resultSet.getString("id");
				foundClient.name = resultSet.getString("name");
			}
			
			return foundClient;
		} catch(SQLException exception) {
			throw exception;
		}
	}
}
