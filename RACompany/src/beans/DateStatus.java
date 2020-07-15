package beans;

import java.util.Date;

/**
 * Klasa sa enkapsulaciju datuma i statusa zauzeca
 * */
public class DateStatus {
	
	private Date date;
	private boolean status;
	
	public DateStatus() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
