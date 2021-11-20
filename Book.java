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
		int cnt = 1;
		System.out.println("\t제목\t장르\t평점");

		for(Movie_Info m : booking) {
			System.out.println(cnt + "\t" + m.getName() + "\t" + m.getGenre() + "\t" + m.getRatio());
			cnt++;
		}
	}
}
