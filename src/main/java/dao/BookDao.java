package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modal.Book;
import resource.DbResource;

public class BookDao {

	public int storebookingdata(Book b) {
			SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
				session.save(b);
			tran.commit();		
			return 1;
		
	}

}
