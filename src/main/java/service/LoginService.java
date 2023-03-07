package service;

import java.sql.SQLException;
import java.util.List;

import dao.LoginDao;
import modal.Login;

public class LoginService {
LoginDao ld  = new LoginDao();
	
	public int adminLogin(String email,String password) throws SQLException {
		int adminId = ld.adminLogin(email,password);
		if(adminId>0) {
			return adminId;
		}else {
			return 0;
		}
	}
	
	public String updateAdminPass(String newPassword,int adminId) {
			if(ld.updateAdminPass(newPassword,adminId)>0) {
				return "SUCCESS";
			}else {
				return "FAIL";
			}
		}
		
	public String findAdminPass(int aid) {
		String pass = ld.findAdminById(aid);
		if(pass==null) {
			return "NIL";
		}else {
			return pass.toString();
		}
	}
	
	public List<Login> findAllAdmin() {
		return ld.findAllAdmin();
	}

}
