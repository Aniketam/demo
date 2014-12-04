package com.alm.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alm.daos.IUserDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.UserPOJO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/dispatcher-servlet.xml")
public class TestUserDAO {

	@Autowired
	@Qualifier("UserDAO")
	private IUserDAO userdao;

	private static UserPOJO user;

	@BeforeClass
	public static void beforeClass() {
		user = new UserPOJO();
		user.setUsername("mee");
	}

	@Test
	public void testAddUser() {
		user = userdao.addUser(user);
		assertNotNull(user);
	}

	@Test
	public void testGetAllUsers() throws ALMException {
		assertNotNull(userdao.getAllUsers());
	}

	@Test
	public void testGetUserByUid() throws ALMException
	{
		assertNotNull(userdao.getUserByUid(user));
	}

	@Test
	public void testGetAllUserByGid() throws ALMException {
		assertNotNull(userdao.getAllUsersByGid(user));
	}

	@Test
	public void testGetUserByName() throws ALMException {
		assertNotNull(userdao.getUserByName(user));
	}

	@Test
	public void testRemoveUser() {
		assertTrue(userdao.removeUser(user));
	}
}
