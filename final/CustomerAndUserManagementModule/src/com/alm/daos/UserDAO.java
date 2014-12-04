package com.alm.daos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alm.exceptions.ALMException;
import com.alm.pojos.UserPOJO;

@Repository("UserDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDAO implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public UserPOJO getUserByUid(UserPOJO u) throws ALMException {
		if (u == null) {
			throw new ALMException("no user provided");
		}
		UserPOJO user = entityManager.find(UserPOJO.class, u.getUid());
		if (user == null) {
			throw new ALMException("no user found");
		}
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<UserPOJO> getAllUsers() throws ALMException {
		Query q = entityManager.createQuery("select u from UserPOJO u");
		ArrayList<UserPOJO> al = (ArrayList<UserPOJO>) q.getResultList();
		if (al == null) {
			throw new ALMException("no users found");
		}
		return al;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<UserPOJO> getUserByName(UserPOJO user) throws ALMException {
		Query q = entityManager
				.createQuery("select u from UserPOJO u where u.username like '%"
						+ user.getUsername() + "%'");
		ArrayList<UserPOJO> al = (ArrayList<UserPOJO>) q.getResultList();
		if (al == null) {
			throw new ALMException("no user found..");
		}
		return al;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<UserPOJO> getAllUsersByGid(UserPOJO user)
			throws ALMException {
		System.out.println(user);
		Query q = entityManager
				.createQuery("select u from UserPOJO u where u.gid=?");
		q.setParameter(1, user.getGid());
		ArrayList<UserPOJO> al = (ArrayList<UserPOJO>) q.getResultList();
		if (al == null) {
			throw new ALMException("no user found..");
		}
		return al;
	}

	@Override
	public UserPOJO addUser(UserPOJO user) {
		System.out.println("in User DAO");
		return entityManager.merge(user);
	}

	@Override
	public boolean userValidation(UserPOJO user) {
		System.out.println("in userValidation of userdao");
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(username + password);
		Query query = entityManager
				.createQuery("select u from UserPOJO u where u.username=:user and u.password=:pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
		try {
			UserPOJO usr = (UserPOJO) query.getSingleResult();
			if (username.equalsIgnoreCase(usr.getUsername())
					&& password.equals(usr.getPassword())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean adminValidation(UserPOJO user) {
		System.out.println("in adminValidation of userdao");
		String username = user.getUsername();
		String password = user.getPassword();
		String role = "Admin";
		System.out.println(username + " " + password);
		Query query = entityManager
				.createQuery("select u from UserPOJO u where u.username=:user and u.password=:pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
		try {
			UserPOJO usr = (UserPOJO) query.getSingleResult();
			if (role.equalsIgnoreCase(usr.getRole())) {
				if (username.equalsIgnoreCase(usr.getUsername())
						&& password.equals(usr.getPassword())) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean removeUser(UserPOJO user) {
		System.out.println("the given user id is " + user.getUid());
		entityManager.remove(entityManager.find(UserPOJO.class, user.getUid()));
		System.out.println("query executed sucessfully....");
		return false;
	}

	@Override
	public boolean updateUser(UserPOJO user) {
		System.out.println("the user id is"
				+ (entityManager.find(UserPOJO.class, user.getUid())
						.getUsername()));
		entityManager.merge(user);
		System.out.println("update sucessfull");
		return true;
	}
}
