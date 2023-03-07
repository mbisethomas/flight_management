package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modal.Login;
import resource.DbResource;

public class LoginDao {
		

	@SuppressWarnings("rawtypes")
	public int adminLogin(String email ,String password) throws SQLException {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Query tq =session.createQuery("select log.aid from Login log where log.email =:umail and log.password =:upass");
		tq.setParameter("umail",email);
		tq.setParameter("upass", password);
		List lr =tq.getResultList();
		if(lr.isEmpty()) {
			return 0;
		}else {
		int adminId =(int) lr.get(0);
		return adminId;
		}
	}
	
	public String findAdminById(int aid) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Login lg = session.get(Login.class, aid);
		String apass =lg.getPassword();
		return apass;	
	}
	
	public int updateAdminPass(String newPassword,int adminId) { 
			SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Login lg2 =session.load(Login.class, adminId);
			lg2.setPassword(newPassword);
			Transaction tran = session.getTransaction();
			tran.begin();
				session.update(lg2);
			tran.commit();
			return 1;
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Login> findAllAdmin() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq = session.createQuery("from Login");
		List<Login> listOfAdmin = tq.getResultList();
		return listOfAdmin;
	}
}
