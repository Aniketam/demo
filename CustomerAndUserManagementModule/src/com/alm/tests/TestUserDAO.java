package com.alm.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
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

	private UserPOJO user;
	private UserPOJO userafter;

	@BeforeClass
	public static void beforeClass() {
		//user = new UserPOJO();
		//user.setUsername("mee");
		System.out.println("Inside beforeclass....");
	}
	
	@Before
    public void setUp() throws ALMException{
        System.out.println("@Before - setUp");        
        ArrayList<UserPOJO> list = userdao.getAllUsers();
        user = list.get(0);
        userafter = list.get(0);
    }
	
	@After
    public void tearDown() {
        System.out.println("@After - tearDown");
       userdao.addUser(userafter);
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
		//assertTrue(userdao.removeUser(user));
		assertFalse(userdao.removeUser(user));
	}
}
