package com.alm.daos;

import java.util.ArrayList;
import java.util.List;

import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;

public interface IClientDAO {

	public ArrayList<ClientPOJO> getClientbyname(ClientPOJO client) throws ALMException;

	//public ClientPOJO removeClientbyid(ClientPOJO c);
	public boolean removeClientbyid(ClientPOJO client) throws ALMException;

	public ClientPOJO registerClient(ClientPOJO client);
	
	public List<ClientPOJO> allClient() throws ALMException ;
	
	//public void addClient(ClientPOJO c);
	
	public ClientPOJO getClientbyid(ClientPOJO client) throws ALMException;

}
