package movie;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		play();
	}
	
	public static void play() throws IOException {
		int userID;
		
		Movie m = new Movie();
		m.First_Setting();
		userID = m.lr.lr();
		m.MBooking(userID);
		
	}

}
