package com.alm.services;

import java.util.ArrayList;
import java.util.List;

import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;

public interface IClientService
{
	
	public ArrayList<ClientPOJO> getClientbyname(ClientPOJO client) throws ALMException;
	
	public void registerClient(ClientPOJO client);
	
	public List<ClientPOJO> allClients() throws ALMException;
	
	public boolean removeClientById(ClientPOJO client) throws ALMException;
	public ClientPOJO  getClientbyid(ClientPOJO client) throws ALMException;
}
