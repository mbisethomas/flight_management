package service;

import modal.Customer;
import dao.CustomerDao;

public class CustomerService {
	CustomerDao cd = new CustomerDao();
	public int storeCustomer(Customer customer) {
		int result =cd.storeCustomer(customer);
		if(result>0) {
			return result;
		}else {
			return 0;
		}
	}
	
	public int getcustomerBYuuid(String cuniqueID) {
		int ccid = cd.getcustomerBYuuid(cuniqueID);
		if(ccid>0) {
			return ccid;
		}else {
			return 0;
		}
	
	}
	
}
