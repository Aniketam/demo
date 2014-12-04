package com.alm.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alm.daos.IUserDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.UserPOJO;

@Service
@Qualifier("UserService")
public class UserService implements IUserService {

	@Autowired()
	@Qualifier("UserDAO")
	IUserDAO userdao;
	UserPOJO user=null;

	@Override
	public UserPOJO getUserByUid(UserPOJO u)
	{
			try {
				user = userdao.getUserByUid(u);
			} catch (ALMException e) 
			{
				e.getMessage();
			}
		
		return user;
	}

	@Override
	public ArrayList<UserPOJO> getAllUsers() throws ALMException {
		return userdao.getAllUsers();
	}

	@Override
	public ArrayList<UserPOJO> getUserByName(UserPOJO user) throws ALMException {
		return userdao.getUserByName(user);
	}

	@Override
	public ArrayList<UserPOJO> getAllUsersByGid(UserPOJO user) throws ALMException {
		return userdao.getAllUsersByGid(user);
	}

	public UserPOJO addUser(UserPOJO user) {
		System.out.println("in service");
		return userdao.addUser(user);

	}

	@Override
	public boolean authenticateUser(UserPOJO user) {
		// TODO Auto-generated method stub
		return userdao.userValidation(user);
	}

	@Override
	public boolean authenticateAdmin(UserPOJO user) {
		// TODO Auto-generated method stub
		return userdao.adminValidation(user);
	}

	@Override
	public boolean removeUser(UserPOJO user) {
		return userdao.removeUser(user);
	}

	@Override
	public boolean updateUser(UserPOJO user) {
		return userdao.updateUser(user);
	}

}
