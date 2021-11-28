package movie;

import java.util.ArrayList;
import java.util.Collections;

public class MovieList {
	ArrayList<Movie_Info> mlist = new ArrayList<Movie_Info>();
	
	public int getSize() {
		return mlist.size();
	}
	
	public Movie_Info getMovie(int i) {
		return mlist.get(i);
	}
	
	public void addMlist(Movie_Info m) {
		mlist.add(m);
	}
	
	public void sortMlist() {
		Collections.sort(mlist);
	}
	
	public void printMlist() {
		int cnt = 1;
		
		//sortMlist();
		Collections.sort(mlist);
		
		System.out.println("순위\t제목\t장르\t평점");
		
		for(Movie_Info m : mlist) {
			System.out.println(cnt + "\t" + m.getName() + "\t" + m.getGenre() + "\t" + m.getRatio());
			cnt++;
		}
	}
	
}
