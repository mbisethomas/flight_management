package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modal.Customer;
import resource.DbResource;

public class CustomerDao {
	
	public int storeCustomer(Customer customer) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(customer);
			//int result = (int) session.createQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		tran.commit();		
		return 1;
	}
	
	public int getcustomerBYuuid(String cuniqueid) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		String query="select c.cid from Customer c where c.cuniqueid='"+cuniqueid+"'";
		int cr = (int) session.createQuery(query).uniqueResult(); 
		return cr;	
	}
}
