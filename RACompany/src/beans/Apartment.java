package beans;

import java.util.Date;
import java.util.List;

public class Apartment {
	
	private ApartmentType type;
	private Integer roomNumber;
	private Integer guestNumber;
	private Location appartmentLocation;
	private Host appartmentHost;
	
	private List<DateStatus> appartmentResevartionDates;
	private List<Comment> comments;
	
	private Double pricePerNight;
	
	private Date checkInTime;
	private Date checkOutTime;
	
	private boolean appartmentStatus;
	
	private List<Amenities> amenities;
	private List<Reservations> reservations;
	

	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ApartmentType getType() {
		return type;
	}



	public void setType(ApartmentType type) {
		this.type = type;
	}



	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(Integer guestNumber) {
		this.guestNumber = guestNumber;
	}
	public Location getAppartmentLocation() {
		return appartmentLocation;
	}
	public void setAppartmentLocation(Location appartmentLocation) {
		this.appartmentLocation = appartmentLocation;
	}
	public Host getAppartmentHost() {
		return appartmentHost;
	}
	public void setAppartmentHost(Host appartmentHost) {
		this.appartmentHost = appartmentHost;
	}
	public List<DateStatus> getAppartmentResevartionDates() {
		return appartmentResevartionDates;
	}
	public void setAppartmentResevartionDates(List<DateStatus> appartmentResevartionDates) {
		this.appartmentResevartionDates = appartmentResevartionDates;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public boolean isAppartmentStatus() {
		return appartmentStatus;
	}
	public void setAppartmentStatus(boolean appartmentStatus) {
		this.appartmentStatus = appartmentStatus;
	}
	public List<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}
	public List<Reservations> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
