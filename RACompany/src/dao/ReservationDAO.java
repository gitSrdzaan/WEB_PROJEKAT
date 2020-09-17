package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reservation;



public class ReservationDAO {

	private Map<Long, Reservation> reservations = new HashMap<Long,Reservation>();
	private String contextPath;
	
	public ReservationDAO(String contexPath){
		this.contextPath = contexPath;
		
		try {
			loadReservation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metoda za ucitavanje rezervacija
	 * */
	private void loadReservation() throws IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = null;
		
		File reservationFile = new File(this.contextPath + "data/reservation.json");
		StringBuilder json = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new FileReader(reservationFile));
			while ((line = br.readLine()) !=null) {
				json.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			br.close();
		}
		
		List<Reservation> reservations = mapper.readValue(json.toString(), 
				new TypeReference<ArrayList<Reservation>>() {
			
		});
		this.reservations.clear();
		for (Reservation reservation : reservations) {
			this.reservations.put(reservation.getID(), reservation);
		}
	}

	
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		
		return new ArrayList<Reservation>(this.reservations.values());
	}

	public void putReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		List<Reservation> allReservations = (List<Reservation>) this.reservations.values();
		
		allReservations.sort((a,b) -> Long.compare(b.getID(), a.getID()));
		
		Long maxId = allReservations.get(0).getID();
		reservation.setID(++maxId);
		
		this.reservations.put(reservation.getID(), reservation);
		
	}
	public Reservation findById(Long id) {
		// TODO Auto-generated method stub
		Reservation reservation  = this.reservations.get(id);

		return reservation;
		
	}
	
	
	/**
	 * Metoda za cuvanje rezervavija
	 * @throws Exception
	 * */
	public void saveReservation() throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		File reservationFile = new File(this.contextPath + "data/reservation.json");
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(reservationFile, 
					this.reservations.values());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri upisivanju rezervacija u fajl");
		}
		
		
		
	}
	public void modifyReservation(Reservation reservation, Long id) {
		// TODO Auto-generated method stub
		Reservation temp = this.findById(id);
		temp = reservation;
		this.reservations.put(id, temp);
		
		
	}
	public ArrayList<Reservation> findByUser(String username) {
		// TODO Auto-generated method stub
		ArrayList<Reservation> retList = new ArrayList<Reservation>(this.reservations.values());
		
		for(Reservation iter : retList) {
			if(!iter.getGuest().getUsername().equals(username)) {
				retList.remove(iter);
			}
			
		}
		
		
		return retList;
	}
}
