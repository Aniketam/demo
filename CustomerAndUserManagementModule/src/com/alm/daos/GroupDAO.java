package com.alm.daos;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.alm.exceptions.ALMException;
import com.alm.pojos.GroupPOJO;
import com.alm.pojos.UserPOJO;

@Repository("GroupDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class GroupDAO implements IGroupDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GroupPOJO> getAllGroups() throws ALMException 
	{

		System.out.println("inside get all groups....");
		Query query1 = entityManager.createQuery("Select g from GroupPOJO g ");
		ArrayList<GroupPOJO> list1 = (ArrayList<GroupPOJO>) query1
				.getResultList();
		System.out.println("querry executed sucessfully...");
		if(list1==null)
		{
			throw new ALMException("no group found...");
		}
		for (GroupPOJO g : list1) {
			System.out.print("Group id is" + g.getGid());

		}

		return list1;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserPOJO> getAllmembers(int gid) throws ALMException 
	{

		System.out.println("inside get all members in a group....");
		Query query1 = entityManager.createQuery("Select u from UserPOJO u where gid = :id");
		query1.setParameter("id",gid);
		ArrayList<UserPOJO> list1 = (ArrayList<UserPOJO>) query1.getResultList();
		System.out.println("querry executed sucessfully...");
		if(list1==null)
		{
			throw new ALMException("no group found...");
		}
		for (UserPOJO u : list1) {
			System.out.print("User name is" + u.getUsername());

		}

		return list1;
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<GroupPOJO> getGroupByGroupName(GroupPOJO g) {
		System.out.println("the given group name is " + g.getName());
		Query query1 = entityManager
				.createQuery("Select g from GroupPOJO g where g.name LIKE :code");
		query1.setParameter("code", "%" + g.getName() + "%");
		ArrayList<GroupPOJO> list1 = (ArrayList<GroupPOJO>) query1
				.getResultList();
		System.out.println("querry executed sucessfully...");
		return list1;

	}

	@Override
	public GroupPOJO getGroupById(GroupPOJO g) throws ALMException
	{ 
		if(g == null)
		{
			throw  new ALMException("group not provided for finding");
		}
		GroupPOJO grouppojo=entityManager.find(GroupPOJO.class, g.getGid());
		if(grouppojo == null)
		{
			throw  new ALMException("group not found");
		}
		return grouppojo;
	}

	@Override
	public boolean remove(GroupPOJO g) throws ALMException
	{
		if(g==null)
		{
			 throw new ALMException("no group provided for deletion");
		}
		System.out.println("the given group id is " + g.getGid());
		entityManager.remove(entityManager.find(GroupPOJO.class, g.getGid()));
		System.out.println("query executed sucessfully....");

		return false;
	}

	@Override
	public boolean update(GroupPOJO grouppojo) {

		System.out.println("the group id is"
				+ (entityManager.find(GroupPOJO.class, grouppojo.getGid())
						.getName()));
		entityManager.merge(grouppojo);
		System.out.println("update sucessfull");
		return true;
	}

	@Override
	public GroupPOJO addGroup(GroupPOJO g) {
		return entityManager.merge(g);
	}
}
