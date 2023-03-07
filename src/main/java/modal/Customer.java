package modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customerdetails")

public class Customer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cid;
		private String cfirstname;
		private String clastname;
		private String cphone;
		private String cuniqueid;
		
		public String getCuniqueid() {
			return cuniqueid;
		}
		public void setCuniqueid(String cuniqueid) {
			this.cuniqueid = cuniqueid;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCfirstname() {
			return cfirstname;
		}
		public void setCfirstname(String cfirstname) {
			this.cfirstname = cfirstname;
		}
		public String getClastname() {
			return clastname;
		}
		public void setClastname(String clastname) {
			this.clastname = clastname;
		}
		public String getCphone() {
			return cphone;
		}
		public void setCphone(String cphone) {
			this.cphone = cphone;
		}
		@Override
		public String toString() {
			return "Place [cid=" + cid + ", cfirstname=" + cfirstname + ", clastname=" + clastname + ", cphone="
					+ cphone + "]";
		}
		

}
