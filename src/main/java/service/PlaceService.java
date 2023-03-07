package service;

import java.util.List;

import dao.PlaceDao;
import modal.Place;

public class PlaceService {

PlaceDao pd  = new PlaceDao();
	
	public String storePlace(Place place) {
		if(pd.storePlace(place)>0) {
			return "Product data stored successfully";
		}else {
			return "Product details didn't store";
		}
	}
	
	public String findPlace(int pid) {
		String p = pd.findPlaceById(pid);
		if(p==null) {
			return "NIL";
		}else {
			return p.toString();
		}
	}
	public List<Place> findAllPlace() {
		return pd.findAllPlace();
	}
}
