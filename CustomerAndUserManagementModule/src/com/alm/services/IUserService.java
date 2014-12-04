package com.alm.services;

import java.util.ArrayList;

import com.alm.exceptions.ALMException;
import com.alm.pojos.UserPOJO;

public interface IUserService {
	
	public UserPOJO getUserByUid(UserPOJO u);

	public ArrayList<UserPOJO> getAllUsers() throws ALMException;

	public ArrayList<UserPOJO> getUserByName(UserPOJO user) throws ALMException;

	public ArrayList<UserPOJO> getAllUsersByGid(UserPOJO user) throws ALMException;
	
	public UserPOJO addUser(UserPOJO user);
	
	public boolean authenticateUser(UserPOJO user);
	
	public boolean authenticateAdmin(UserPOJO user);

	boolean removeUser(UserPOJO user);

	boolean updateUser(UserPOJO user);

}
