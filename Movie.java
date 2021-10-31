package movie;

import java.util.Random;

public class Movie {
	Random r = new Random();
	MovieList ml = new MovieList();
	Movie_Info m;
	
	public void First_Audience() {
		ml.addMlist(new Movie_Info("액시트", "액션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("해리포터", "판타지", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("라푼젤", "애니메이션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		
		ml.printMlist();
	}

}
