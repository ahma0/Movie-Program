package movie;

import java.util.ArrayList;

public class User_Info {		//유저정보 저장
	private String id;
	private String pw;
	private String name;
	private final int UserNum = 1;
	ArrayList<String> movieName = new ArrayList<String>();

	User_Info(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		
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
	
	public void getInfo() {
		System.out.println(name + " " + id + " " + pw);
	}

}
