package com.alm.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.alm.daos.IGroupDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.GroupPOJO;
import com.alm.pojos.UserPOJO;

@Service
@Qualifier("GroupService")
public class GroupService implements IGroupService {

	@Autowired()
	@Qualifier("GroupDAO")
	IGroupDAO groupdao;

	@Override
	public GroupPOJO addGroup(GroupPOJO g) {
		return groupdao.addGroup(g);
	}
	
	@Override
	public ArrayList<GroupPOJO> getAllGroups() throws ALMException 
	{
		return groupdao.getAllGroups();
	}
	
	@Override
	public ArrayList<GroupPOJO> getGroupByGroupName(GroupPOJO grouppojo) {
		return groupdao.getGroupByGroupName(grouppojo);

	}
	
	@Override
	public GroupPOJO getGroupById(GroupPOJO grouppojo) throws ALMException
	{
		return groupdao.getGroupById(grouppojo);

	}
	
	@Override
	public boolean remove(GroupPOJO grouppojo) throws ALMException
	{
		return groupdao.remove(grouppojo);
	}
	
	@Override
	public boolean update(GroupPOJO grouppojo) {
		return groupdao.update(grouppojo);

	}
	
	@Override
	public ArrayList<UserPOJO> getAllmembers(int gid) throws ALMException 
	{
		return groupdao.getAllmembers(gid);
	}
	
	

	
}
