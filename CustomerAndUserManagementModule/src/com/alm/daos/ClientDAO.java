package com.alm.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alm.exceptions.ALMException;
import com.alm.pojos.ClientPOJO;

@Repository("ClientDAO")
/*@Qualifier("ClientDAO")*/
@Transactional(propagation = Propagation.REQUIRED)
public class ClientDAO implements IClientDAO {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<ClientPOJO> getClientbyname(ClientPOJO client) throws ALMException
	{
		//em.getTransaction().begin();
		if(client==null)
		{
			throw new ALMException("no client object found for query");
		}
		Query q = em.createQuery("select c from ClientPOJO c where c.name like ?");
		q.setParameter(1, "%"+client.getName()+"%");
		ArrayList<ClientPOJO> al = (ArrayList<ClientPOJO>) q.getResultList();
		if(al == null)
		{
			throw new ALMException("no client found");
		}
		return al;

	}

	@Override
	public boolean removeClientbyid(ClientPOJO client) throws ALMException
	{
		//ClientPOJO clnt = em.find(ClientPOJO.class, c.getId());
		if(client==null)
		{
			throw new ALMException("No client found for removal");
		}
		Query q = em.createQuery("delete from ClientPOJO c where c.id=?");
		q.setParameter(1, client.getId());
		int i = q.executeUpdate();
		if(i==1)
			return true;
		else
			return false;
	}

	@Override
	public ClientPOJO registerClient(ClientPOJO client) {
		System.out.println("in client dao " + client);
		return em.merge(client);
	}
	
	@Override
	public List<ClientPOJO> allClient() throws ALMException
	
	{

		@SuppressWarnings("unchecked")
		List<ClientPOJO> result = (List<ClientPOJO>) em.createQuery(
				"SELECT c from ClientPOJO c").getResultList();
		if(result == null)
		{
			throw new ALMException("no client found");
		}

		return result;
	}
	
	@Override
	public ClientPOJO getClientbyid(ClientPOJO client) throws ALMException
	{
		if(client==null)
		{
			throw new ALMException("no client object found for query");
		}
		Query q = em.createQuery("select c from ClientPOJO c where c.id=?");
		q.setParameter(1, client.getId());
		ClientPOJO al = (ClientPOJO) q.getSingleResult();
		if(al == null)
		{
			throw new ALMException("no client found");
		}
		return al;

	}

}
