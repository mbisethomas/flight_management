package modal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight")

public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private int fairline;
	private String fdate;
	private int fsource;
	private int fdestination;
	private Float fprice;
//	@ManyToOne
//    @JoinColumn(name = "fsource",referencedColumnName = "pid", insertable=false, updatable=false)
//	@JoinColumn(name = "fdestination",referencedColumnName = "pid", insertable=false, updatable=false)
//	private Place pname;
//	@ManyToOne
//	@JoinColumn(name = "fairline",referencedColumnName = "aid", insertable=false, updatable=false)
//	private Airline aname;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getFairline() {
		return fairline;
	}
	public void setFairline(int fairline) {
		this.fairline = fairline;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	
	public int getFsource() {
		return fsource;
	}
	public void setFsource(int fsource) {
		this.fsource = fsource;
	}
	public int getFdestination() {
		return fdestination;
	}
	public void setFdestination(int fdestination) {
		this.fdestination = fdestination;
	}
	public Float getFprice() {
		return fprice;
	}
	public void setFprice(Float fprice) {
		this.fprice = fprice;
	}
	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", fairline=" + fairline + ", fdate=" + fdate + ", fsource=" + fsource
				+ ", fdestination=" + fdestination + ", fprice=" + fprice + "]";
	}
	
	 
//	    public Place getPlaceName() {
//	        return pname;
//	    }
//	    
//	    public Airline getAirlineName() {
//	        return aname;
//	    }
	 
}
