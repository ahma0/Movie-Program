package movie;

import java.util.ArrayList;

public class Book {			//유저 영화 예매 정보 저장
	private ArrayList<Movie_Info> booking = new ArrayList<Movie_Info>();
	
	public void addBooking(Movie_Info m) {
		booking.add(m);
	}
	
	public Movie_Info getMovie(int i) {
		return booking.get(i);
	}
}
