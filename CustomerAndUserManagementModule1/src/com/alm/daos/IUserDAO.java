package com.alm.daos;

import java.util.ArrayList;

import com.alm.exceptions.ALMException;
import com.alm.pojos.UserPOJO;

public interface IUserDAO {
	
	public ArrayList<UserPOJO> getAllUsers() throws ALMException;

	public ArrayList<UserPOJO> getUserByName(UserPOJO user) throws ALMException;

	public UserPOJO getUserByUid(UserPOJO user) throws ALMException;

	public ArrayList<UserPOJO> getAllUsersByGid(UserPOJO user) throws ALMException;
	
	public UserPOJO addUser(UserPOJO user);
	
	public boolean userValidation(UserPOJO user);
	
	public boolean adminValidation(UserPOJO user);

	boolean removeUser(UserPOJO user);

	boolean updateUser(UserPOJO user);
	
	
	
}
