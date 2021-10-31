package movie;

import java.util.ArrayList;

public class MovieList {
	ArrayList<Movie_Info> mlist = new ArrayList<Movie_Info>();
	
	public int getSize() {
		return mlist.size();
	}
	
	public void addMlist(Movie_Info m) {
		mlist.add(m);
	}
	
	public void printMlist() {
		for(int i = 0; i < getSize(); i++) {
			System.out.print((i + 1) + " ");
			mlist.get(i).getInfo();
		}
	}
	
}
