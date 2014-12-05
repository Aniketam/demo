package com.alm.services;

import java.util.ArrayList;

import com.alm.exceptions.ALMException;
import com.alm.pojos.GroupPOJO;
import com.alm.pojos.UserPOJO;

public interface IGroupService {
	
	public GroupPOJO addGroup(GroupPOJO g);

	public ArrayList<GroupPOJO> getAllGroups() throws ALMException;

	public ArrayList<GroupPOJO> getGroupByGroupName(GroupPOJO grouppojo);

	public GroupPOJO getGroupById(GroupPOJO grouppojo) throws ALMException;

	public boolean remove(GroupPOJO grouppojo) throws ALMException;

	public boolean update(GroupPOJO grouppojo);
	
	public ArrayList<UserPOJO> getAllmembers(int gid) throws ALMException ;
	
	

}
