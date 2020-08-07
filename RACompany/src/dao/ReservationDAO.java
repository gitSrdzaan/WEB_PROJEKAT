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

import beans.Reservations;


public class ReservationDAO {

	private Map<Long, Reservations> reservations = new HashMap<Long,Reservations>();
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
		
		List<Reservations> reservations = mapper.readValue(json.toString(), 
				new TypeReference<ArrayList<Reservations>>() {
			
		});
		this.reservations.clear();
		for (Reservations reservation : reservations) {
			this.reservations.put(reservation.getID(), reservation);
		}
	}

	public List<Reservations> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
