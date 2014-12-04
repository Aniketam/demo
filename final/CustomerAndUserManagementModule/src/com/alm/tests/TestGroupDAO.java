package com.alm.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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

	private static GroupPOJO g;

	@BeforeClass
	public static void beforeClass() {
		g = new GroupPOJO();
	}

	@Test
	public void testGetAllGroups() throws ALMException 
	{
		assertNotNull(groupdao.getAllGroups());
	}

	@Test
	public void testGetGroupByGroupName() {
		g.setName("e");
		assertNotNull(groupdao.getGroupByGroupName(g));
	}
	
	@Test
	public void testAddGroup() {
		g = groupdao.addGroup(g);
		assertNotNull(g);
	}

	@Test
	public void testGetGroupById() throws ALMException 
	{
		assertNotNull(groupdao.getGroupById(g));
	}

	@Test
	public void testRemove() throws ALMException {
		assertTrue(groupdao.remove(g));
	}
}
