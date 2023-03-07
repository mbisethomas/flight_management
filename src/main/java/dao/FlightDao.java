package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modal.Flight;
import resource.DbResource;

public class FlightDao {
	public int storeFlight(Flight flight) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(flight);
		tran.commit();		
		return 1;
	}
	
	public List<Flight> findAllFlight() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Flight");
		List<Flight> listOfFlight = tq.getResultList();
		return listOfFlight;
	}

	public List<String[]> fetchAvailableFlight(int travelFrom, int travelTo, String travelDate) throws SQLException {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		List<String[]> listOfAvailabeFlight=new ArrayList<>();
		String query="from Flight fg where fg.fdate >='"+travelDate+"' and fg.fsource ='"+travelFrom+"' and fg.fdestination='"+travelTo+"'";
		return listOfAvailabeFlight= session.createQuery(query).list();
	}

}
