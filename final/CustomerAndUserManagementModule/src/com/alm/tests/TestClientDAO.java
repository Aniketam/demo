package com.alm.tests;

import static org.junit.Assert.*;
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

	private static ClientPOJO client;

	@BeforeClass
	public static void beforeClass() {
		client = new ClientPOJO();
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
