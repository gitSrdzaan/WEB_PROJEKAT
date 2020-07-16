package beans;

import java.util.Date;
import java.util.List;

public class Apartment {
	
	private Long Id;
	
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
	
	private boolean apartmentStatus;
	
	private List<Amenities> amenities;
	private List<Reservations> reservations;
	

	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public Long getId() {
		return Id;
	}





	public void setId(Long id) {
		Id = id;
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
	public Location getApartmentLocation() {
		return appartmentLocation;
	}
	public void setApartmentLocation(Location appartmentLocation) {
		this.appartmentLocation = appartmentLocation;
	}
	public Host getApartmentHost() {
		return appartmentHost;
	}
	public void setApartmentHost(Host appartmentHost) {
		this.appartmentHost = appartmentHost;
	}
	public List<DateStatus> getApartmentResevartionDates() {
		return appartmentResevartionDates;
	}
	public void setApartmentResevartionDates(List<DateStatus> appartmentResevartionDates) {
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
	public boolean isApartmentStatus() {
		return apartmentStatus;
	}
	public void setApartmentStatus(boolean appartmentStatus) {
		this.apartmentStatus = appartmentStatus;
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
