package movie;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		play();
	}
	
	public static void play() throws IOException {
		Movie m = new Movie();
		m.First_Setting();
		
		Seat s = new Seat(m, m.lr());
		
	}

}
