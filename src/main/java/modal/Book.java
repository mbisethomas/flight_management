package modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int bid;
	    private int cid;
		private int fid;
		private int nopassenger;
		private int seatno;
		private String ticketno;
		
		public int getBid() {
			return bid;
		}
		public void setBid(int bid) {
			this.bid = bid;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public int getNopassenger() {
			return nopassenger;
		}
		public void setNopassenger(int nopassenger) {
			this.nopassenger = nopassenger;
		}
		public int getSeatno() {
			return seatno;
		}
		public void setSeatno(int seatno) {
			this.seatno = seatno;
		}
		public String getTicketno() {
			return ticketno;
		}
		public void setTicketno(String ticketno) {
			this.ticketno = ticketno;
		}
		@Override
		public String toString() {
			return "Book [cid=" + cid + ", fid=" + fid + ", nopassenger=" + nopassenger + ", seatno=" + seatno
					+ ", ticketno=" + ticketno + "]";
		}
		
}
