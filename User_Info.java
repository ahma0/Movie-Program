package movie;

public class User_Info {		//유저정보 저장
	private String id;
	private String pw;
	private String name;
	private static int MaxUserNum = 0;
	private int UserNum = 0;
	private Book booking = new Book();
	//private ArrayList<String> seats = new ArrayList<String>();
	
	User_Info(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		MaxUserNum++;
		UserNum = MaxUserNum;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getID() {
		return id;
	}
	
	public String getPW() {
		return pw;
	}
	
	public int getUserNum() {
		return UserNum;
	}
	
	public void addMovies(Movie_Info m) {
		booking.addBMovie(m);
	}
	
	public Book getBook() {
		return booking;
	}
	
	/*
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
	*/
	
	public void printUInfo() {
		System.out.println(name + " " + id + " " + pw);
	}
	
	/*
	public ArrayList<String> getSInfo() {
		return seats;
	}
	
	public void printBSList() {
		System.out.println("예약한 좌석 목록");
		for(int i = 0; i < getSInfo().size(); i++) {		//예약한 좌석 목록 프린트
			System.out.println(i + 1 + ". " + getSeat(i));	
		}
	}
	*/

}
