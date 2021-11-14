package movie;

import java.util.ArrayList;

public class Book {			//유저 영화 예매 정보 저장
	private ArrayList<Movie_Info> booking = new ArrayList<Movie_Info>();
	
	public void addBooking(Movie_Info m) {
		booking.add(m);
	}
	
	public Movie_Info getBooking(int i) {
		return booking.get(i);
	}
	
	public int getSize() {
		return booking.size();
	}
	
	public void printBList() {
		for(int i = 0; i < booking.size(); i++) {
			booking.get(i).getInfo();
		}
	}
}
