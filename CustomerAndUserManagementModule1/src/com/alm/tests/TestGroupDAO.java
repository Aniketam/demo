package com.alm.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alm.daos.IGroupDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.GroupPOJO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/dispatcher-servlet.xml")
public class TestGroupDAO {

	@Autowired
	@Qualifier("GroupDAO")
	private IGroupDAO groupdao;

	private GroupPOJO g;
	private GroupPOJO gafter;
	
	
	@BeforeClass
	public static void beforeClass() {
		//g = new GroupPOJO();
		//g.setGid(100);
		//g.setName("test1");
		//g.setDescription("NA");
		//g.setStatus("NA");
		System.out.println("Inside beforeclass....");
	}
	
	@Before
    public void setUp() throws ALMException{
        System.out.println("@Before - setUp");        
        	ArrayList<GroupPOJO> list = groupdao.getAllGroups();
        	g = list.get(0);
        	gafter = list.get(0);
    }
	
	@After
    public void tearDown() {
        System.out.println("@After - tearDown");
        groupdao.addGroup(gafter);
    }
	
	@Test
	public void testAddGroup() {
		g = groupdao.addGroup(g);
		System.out.println("add group" + g);
		assertNotNull(g);
	}
	@Test
	public void testGetAllGroups() throws ALMException 
	{
		assertNotNull(groupdao.getAllGroups());
	}

	@Test
	public void testGetGroupByGroupName() {
		assertNotNull(groupdao.getGroupByGroupName(g));
	}	
	

	@Test
	public void testGetGroupById() throws ALMException 
	{
		System.out.println("In group test: " + g.getGid());
		assertNotNull(groupdao.getGroupById(g));
	}

	@Test
	public void testRemove() throws ALMException {
		assertFalse(groupdao.remove(g));
	}
}
