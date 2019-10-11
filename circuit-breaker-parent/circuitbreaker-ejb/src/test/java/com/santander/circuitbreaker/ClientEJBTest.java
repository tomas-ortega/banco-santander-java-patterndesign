package com.santander.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientEJBTest 
{
	@InjectMocks
	private ClientEJB clientEJB;
	
	@Mock
	private ClientDAO clientDAO;
	
	private static ClientEJBTestHelper clientHelper;
	
	@BeforeAll
	public static void beforeAll() {
		clientHelper = new ClientEJBTestHelper();
	}
	
	@BeforeEach
	public void beforeEach() throws Exception {
		//this.clientEJB.setClientDAO(this.clientDAO);
		this.initMocksearchClientById58();
	}
	
    @Test
    public void searchClientById58() throws Exception
    {
    	ClientDTO clientFound = null;
    	
    	clientFound = this.clientEJB.searchClientById(clientHelper.getClientWithId58().id);
    	
        assertTrue(clientFound.id.equals("58"));
    }
    
    @Test
    @Disabled
    public void secondTest()
    {
    	System.out.println("Second Test!!!");
        assertTrue( true );
    }
    
    @AfterEach
    public void afterEach() {
    	System.out.println("Execution after each test!!!");
    }
    
    @AfterAll
    public static void afterAll() {
    	System.out.println("Execution after all test!!!");
    }
    
    private void initMocksearchClientById58() throws Exception {
    	Mockito.when(this.clientDAO.searchClientById(null, 
    			clientHelper.getClientWithId58().id))
    	.thenReturn(clientHelper.getClientWithId58());
    }
}
