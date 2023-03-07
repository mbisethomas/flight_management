package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modal.Airline;
import resource.DbResource;

public class AirlineDao {
	public int storeAirline(Airline airline) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(airline);
		tran.commit();		
		return 1;
	}
	public List<Airline> findAllAirline() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Airline");
		List<Airline> listOfAirline = tq.getResultList();
		return listOfAirline;
	}
	
	public String findAirlineById(int aid) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Airline a = session.get(Airline.class, aid);
		String ar =a.getAname();
		return ar;	
	}
	

}
