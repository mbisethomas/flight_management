package dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import resource.DbResource;
import modal.Airline;
import modal.Place;

public class PlaceDao {
	public int storePlace(Place place) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(place);
		tran.commit();		
		return 1;
	}
	
	public List<Place> findAllPlace() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Place");
		List<Place> listOfPlace = tq.getResultList();
		return listOfPlace;
	}
	
	public String findPlaceById(int pid) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Place p = session.get(Place.class, pid);
		String pr =p.getPname();
		return pr;	
	}
}
