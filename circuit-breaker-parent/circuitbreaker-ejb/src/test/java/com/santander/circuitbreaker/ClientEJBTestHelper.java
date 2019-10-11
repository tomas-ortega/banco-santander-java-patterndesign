package com.santander.circuitbreaker;

public class ClientEJBTestHelper {
	private ClientDTO clientWithId58;
	private ClientDTO clientWithId36AndNamePakoAndSurnameJuanito;
	
	public ClientEJBTestHelper() {
		this.clientWithId58 = null;
		this.clientWithId36AndNamePakoAndSurnameJuanito = null;
		
		this.initClientWithId58();
		this.initClientWithId36AndNamePakoAndSurnameJuanito();
	}
	
	private void initClientWithId58() {
		this.clientWithId58 = new ClientDTO();
		this.clientWithId58.id = "58";
	}
	
	private void initClientWithId36AndNamePakoAndSurnameJuanito() {
		this.clientWithId36AndNamePakoAndSurnameJuanito = new ClientDTO();
		this.clientWithId36AndNamePakoAndSurnameJuanito.id = "36";
		this.clientWithId36AndNamePakoAndSurnameJuanito.name = "Pako";
		this.clientWithId36AndNamePakoAndSurnameJuanito.surname = "Juanito";
	}
	
	public ClientDTO getClientWithId58() {
		return this.clientWithId58;
	}
	
	public ClientDTO getClientWithId36AndNamePakoAndSurnameJuanito() {
		return this.clientWithId36AndNamePakoAndSurnameJuanito;
	}
}
