package movie;

import java.util.ArrayList;

public class UserList {
	private ArrayList<User_Info> u = new ArrayList<User_Info>();
	
	public int getSize() {
		return u.size();
	}
	
	public void addUsers(User_Info uI) {
		u.add(uI);
	}
	
	public User_Info getUser(int i) {
		return u.get(i);
	}
	

}
