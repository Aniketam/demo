package com.alm.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;
import com.alm.pojos.GroupPOJO;
import com.alm.pojos.UserPOJO;
import com.alm.services.IClientService;
import com.alm.services.IGroupService;
import com.alm.services.IUserService;

@Controller
@RequestMapping("/")
/*
 * Code integration and rest applied by ankit
 */public class MainController {

	@Autowired
	@Qualifier("UserService")
	private IUserService userservice;

	@Autowired
	@Qualifier("GroupService")
	private IGroupService groupservice;

	@Autowired
	@Qualifier("ClientService")
	private IClientService clntsrvc;

	// log4j
	 private static Logger logger = Logger.getLogger(MainController.class.getName());

	// ===================================================done by
	// Shakeeb=================================

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> addUser(@RequestBody UserPOJO userpojo) {
		//System.out.println("the given user pojo is " + userpojo.getUsername());
		userpojo.setRole("user");
		userservice.addUser(userpojo);
		logger.fatal("Added user by Name " + userpojo.getUsername());
		HashMap<String, String> hm = new HashMap<>();
		hm.put("result", "true");
		return hm;
	}

	// Method to validate a user
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> validateUser(@RequestBody UserPOJO userpojo,
			HttpSession session) {
		// System.out.println("in validate user of controller ");
		HashMap<String, String> hm = new HashMap<>();
		if (userservice.authenticateUser(userpojo)) {
			session.setAttribute("validUser", userpojo);
			logger.fatal("Login as a user " + userpojo.getUsername());
			hm.put("result", "true");
		} else
			hm.put("result", "false");
		return hm;
	}

	// Method to validate admin
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> validateAdmin(@RequestBody UserPOJO userpojo,
			HttpSession session) {
		// System.out.println("in validate user of controller ");
		HashMap<String, String> hm = new HashMap<>();
		if (userservice.authenticateAdmin(userpojo)) {
			session.setAttribute("validAdmin", userpojo);
			logger.fatal("Login as a Admin " + userpojo.getUsername());
			hm.put("result", "true");
		} else
			hm.put("result", "false");
		return hm;
	}

	// ========================user done by ankit=============================

	// get all users registered
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<UserPOJO> getAllUsers() {
		// System.out.println("display all users called");
		ArrayList<UserPOJO> alluser = null;
		try {
			alluser = userservice.getAllUsers();
		} catch (ALMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.fatal("Search for all user ");
		System.out.println(alluser);
		return alluser;
	}

	// get all users in a particular group
	@RequestMapping(value = "/user/group/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<UserPOJO> getUsersByGid(@PathVariable("id") int gid) {
		//System.out.println("Hi we reached...!!!!!!!!! " + gid);
		UserPOJO user = new UserPOJO();
		user.setGid(gid);
		ArrayList<UserPOJO> userbyid = null;
		logger.fatal("User Search by group id " + gid);
		try {
			userbyid = userservice.getAllUsersByGid(user);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		// logger.fatal("User Search by group id " + gid);
		return userbyid;
	}

	// get all user by name
	@RequestMapping(value = "/user/search/{name}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<UserPOJO> getUserByName(@PathVariable("name") String name) {
		UserPOJO user = new UserPOJO();
		user.setUsername(name);
		ArrayList<UserPOJO> userbyname = null;
		logger.fatal("User Search by Name " + name);
		try {
			userbyname = userservice.getUserByName(user);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("user by name " + userbyname);
		return userbyname;
	}

	// get all user by uid
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody
	UserPOJO getUserByUid(@PathVariable("id") int id) {
		UserPOJO user = new UserPOJO();
		user.setUid(id);
		logger.fatal("User Search by user id " + id);
		return userservice.getUserByUid(user);
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public @ResponseBody
	boolean editUser(@RequestBody UserPOJO user) {
		logger.fatal("Edited User ");
		return userservice.updateUser(user);
	}

	@RequestMapping(value = "/user/remove/{id}", method = RequestMethod.GET)
	public @ResponseBody
	boolean removeUser(@PathVariable("id") int id) {
		UserPOJO user = new UserPOJO();
		user.setUid(id);
		userservice.removeUser(user);
		return true;
	}

	// =====================Groups done by Priyanka
	// ====================================

	// Get group By id

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	public @ResponseBody
	GroupPOJO getGroupById(@PathVariable("id") int gid) {
		// System.out.println("Inside get group by id");
		GroupPOJO grouppojo = new GroupPOJO();
		grouppojo.setGid(gid);
		GroupPOJO responsepojo = null;
		try {
			responsepojo = groupservice.getGroupById(grouppojo);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		// System.out.println("the response group is " + responsepojo);
		// logger.fatal("User Search by group id " + gid);
		return responsepojo;

	}

	// Method to search a group by name
	@RequestMapping(value = "/group/search/{name}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<GroupPOJO> getGroupByName(@PathVariable("name") String name) {
		// System.out.println("the given group name is " + name);
		GroupPOJO grouppojo = new GroupPOJO();
		grouppojo.setName(name);
		ArrayList<GroupPOJO> al = groupservice.getGroupByGroupName(grouppojo);
		// System.out.println("al=" + al);
		logger.fatal("Group Search by name " + name);
		return al;
	}

	// Method to add a group and also used in edit a group in a database

	@RequestMapping(value = "/group/add", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> addGroup(@RequestBody GroupPOJO grouppojo) {
		// System.out.println("the given group pojo is " + grouppojo.getName());
		groupservice.addGroup(grouppojo);
		logger.fatal("Added group " + grouppojo.getName());
		HashMap<String, String> hm = new HashMap<>();
		hm.put("result", "true");
		return hm;
	}

	// Edit a group

	@RequestMapping(value = "/group/edit")
	public void editGroup(@RequestBody GroupPOJO grouppojo) {
		groupservice.update(grouppojo);
		logger.fatal("Edited group " + grouppojo.getName());
		// System.out.println("the group pojo is updated successfully...");

	}

	// Remove a group
	@RequestMapping("/group/remove/{id}")
	public @ResponseBody
	boolean removeGroup(@PathVariable("id") int gid) {
		GroupPOJO grouppojo = new GroupPOJO();
		grouppojo.setGid(gid);
		try {
			groupservice.remove(grouppojo);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.fatal("Removed group " + gid);
		return true;
	}

	//Method to get all groups
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<GroupPOJO> getAllGroups() {
		ArrayList<GroupPOJO> allgroups = null;
		try {
			allgroups = groupservice.getAllGroups();
		} catch (ALMException e) {
			e.printStackTrace();
		}
		logger.fatal("Get all group ");
		return allgroups;

	}
  
	//Method to get all members of a particular group
	
	@RequestMapping(value = "group/getallmembers/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<UserPOJO> getAllMembers(@PathVariable("id") int gid) {
		ArrayList<UserPOJO> allmembers = null;
		try {
			allmembers = groupservice.getAllmembers(gid);
		} catch (ALMException e) {
			e.printStackTrace();
		}
		logger.fatal("Get all group ");
		return allmembers;

	}
	
	
	
	
	

	// =======================================Client Done by Lakshmi and
	// Aniket===============================

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public @ResponseBody
	List<ClientPOJO> listAllClients() {
		List<ClientPOJO> allclients = null;
		logger.fatal("Get all Client ");
		try {
			allclients = clntsrvc.allClients();
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return allclients;
	}

	@RequestMapping(value = "/client/add", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> addClient(@RequestBody ClientPOJO client) {
		clntsrvc.registerClient(client);
		HashMap<String, String> hm = new HashMap<>();
		hm.put("result", "true");
		logger.fatal("Added client " + client.getName());
		return hm;
	}

	@RequestMapping(value = "/client/search/{name}", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<ClientPOJO> getClientByName(@PathVariable("name") String name) {
		// System.out.println("Inside post get");
		// System.out.println("Name" + client.getName());
		// System.out.println("Client By Name: "
		ClientPOJO client = new ClientPOJO();
		client.setName(name);
		ArrayList<ClientPOJO> clientbyname = null;
		try {
			clientbyname = clntsrvc.getClientbyname(client);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.fatal("Get client by name " + client.getName());
		return clientbyname;
	}

	@RequestMapping(value = "/client/remove/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String removeClientByName(@PathVariable("id") int id) {
		ClientPOJO client = new ClientPOJO();
		client.setId(id);
		try {
			clntsrvc.removeClientById(client);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.fatal("Removed client by id " + id);
		return "removed";
	}

	@RequestMapping(value = "/client/searchbyid/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ClientPOJO getClientById(@PathVariable("id") int id) {
		System.out.println("Inside post get");
		System.out.println("Client By Name: " + id);
		ClientPOJO client = new ClientPOJO();
		client.setId(id);
		ClientPOJO clientbyname = null;
		try {
			clientbyname = clntsrvc.getClientbyid(client);
		} catch (ALMException e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.fatal("Get client by Id " + client.getId());
		return clientbyname;
	}

}
