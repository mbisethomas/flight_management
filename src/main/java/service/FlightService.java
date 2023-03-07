package service;

import java.sql.SQLException;
import java.util.List;

import dao.FlightDao;
import modal.Flight;

public class FlightService {
FlightDao fd  = new FlightDao();
	
	public String storeFlight(Flight flight) {
		if(fd.storeFlight(flight)>0) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}
	
	public List<Flight> findAllFlight() {
		return fd.findAllFlight();
	}

	public List<String[]> fetchAvailableFlight(int travelFrom,int travelTo,String travelDate) throws SQLException {
		return fd.fetchAvailableFlight(travelFrom,travelTo,travelDate);
		
	}
}
