package com.alm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alm.daos.IClientDAO;
import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;

@Service
@Qualifier("ClientService")
@Component
public class ClientService implements IClientService {
	@Autowired
	@Qualifier("ClientDAO")
	IClientDAO clientdao;

	@Override
	public void registerClient(ClientPOJO client) {
		System.out.println("inside service " + client);
		clientdao.registerClient(client);

	}

	@Override
	public List<ClientPOJO> allClients() throws ALMException {
		return clientdao.allClient();
	}

	@Override
	public ArrayList<ClientPOJO> getClientbyname(ClientPOJO client)
			throws ALMException {
		return clientdao.getClientbyname(client);
	}

	@Override
	public boolean removeClientById(ClientPOJO client) throws ALMException {
		return clientdao.removeClientbyid(client);
	}

	@Override
	public ClientPOJO getClientbyid(ClientPOJO client) throws ALMException {
		return clientdao.getClientbyid(client);
	}

}
