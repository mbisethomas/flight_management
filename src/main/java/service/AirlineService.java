package service;

import java.util.List;

import modal.Airline;
import dao.AirlineDao;

public class AirlineService {
AirlineDao ad =new AirlineDao();

	public String storeAirline(Airline airline) {
		if(ad.storeAirline(airline)>0) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}
	
	public String findAirline(int aid) {
		String a = ad.findAirlineById(aid);
		if(a==null) {
			return "NIL";
		}else {
			return a.toString();
		}
	}
	
	public List<Airline> findAllAirline() {
		return ad.findAllAirline();
	}
	
}
