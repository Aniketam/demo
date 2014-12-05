package com.alm.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alm.daos.IClientDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/dispatcher-servlet.xml")
public class TestClientDAO {

	@Autowired
	@Qualifier("ClientDAO")
	private IClientDAO clntdao;

	private ClientPOJO client;
	private ClientPOJO clientafter;

	@BeforeClass
	public static void beforeClass() {
		//client = new ClientPOJO();
		System.out.println("Inside beforeclass....");
	}
	
	@Before
    public void setUp() throws ALMException{
        System.out.println("@Before - setUp");        
        List<ClientPOJO> list = clntdao.allClient();	
        client = list.get(0);
        clientafter = list.get(0);
    }
	
	@After
    public void tearDown() {
        System.out.println("@After - tearDown");
       clntdao.registerClient(clientafter);
    }
	
	@Test
	public void testRegisterClient() {
		client=clntdao.registerClient(client);
		assertNotNull(client);
	}

	@Test
	public void testAllClients() throws ALMException 
	{
		assertNotNull(clntdao.allClient());
	}

	@Test
	public void testGetClientByName() throws ALMException 
	{
		assertNotNull(clntdao.getClientbyname(client));	
	}

	@Test
	public void testRemoveClientById() throws ALMException {
		assertTrue(clntdao.removeClientbyid(client));
	}

}
