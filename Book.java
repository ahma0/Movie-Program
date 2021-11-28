package movie;

import java.util.ArrayList;

public class Book {			//유저 예약 정보 저장
	private ArrayList<Movie_Info> movies = new ArrayList<Movie_Info>();
	private ArrayList<String> seats = new ArrayList<String>();
	
	public void addBMovie(Movie_Info m) {
		movies.add(m);
	}
	
	public Movie_Info getBMovie(int i) {
		return movies.get(i);
	}
	
	public void removeMovie(int i) {
		movies.remove(i);
	}
	
	public boolean isBLEmpty() {
		return movies.isEmpty() && seats.isEmpty();
	}
	
	public int getSize() {
		return movies.size();
	}
	
	public void addSeats(String s) {
		seats.add(s);
	}
	
	public String getSeat(int i) {
		return seats.get(i);
	}
	
	public void replaceSeat(int i, String s) {
		seats.set(i, s);
	}
	
	public void removeSeat(int i) {
		seats.remove(i);
	}
	
	public ArrayList<String> getSInfo() {
		return seats;
	}
	
	public void printBSList() {
		System.out.println("예약한 좌석 목록");
		for(int i = 0; i < getSInfo().size(); i++) {		//예약한 좌석 목록 프린트
			System.out.println(i + 1 + ". " + getSeat(i));	
		}
	}
	
	public void printBList() {
		int cnt = 1;
		System.out.println("\t제목\t장르\t평점\t좌석");

		for(Movie_Info m : movies) {
			System.out.println(cnt + "\t" + m.getName() + "\t" + m.getGenre() + "\t" + m.getRatio() + "\t" + getSeat(cnt - 1));
			cnt++;
		}
	}
	
	public void printBMList() {
		int cnt = 1;
		System.out.println("\t제목\t장르\t평점");

		for(Movie_Info m : movies) {
			System.out.println(cnt + "\t" + m.getName() + "\t" + m.getGenre() + "\t" + m.getRatio());
			cnt++;
		}
	}
	
}
