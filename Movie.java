package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Movie {
	private int userID;
	Random r = new Random();
	MovieList ml = new MovieList();
	UserList ul = new UserList();
	Movie_Info m;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	LogInRegister lr = new LogInRegister(ul);
	
	
	public void First_Setting() {
		//초기 영화 정보
		ml.addMlist(new Movie_Info("액시트", "액션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("해리포터", "판타지", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("라푼젤", "애니메이션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		
		ml.printMlist();
		
		//초기 유저 세팅
		ul.addUsers(new User_Info("firstuser34", "qwerty1234", "홍길동"));
		ul.addUsers(new User_Info("firstr34", "qwert234", "홍길"));
		ul.printUlist();
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void MBooking(int userID) throws IOException {
		String ans, ans2;
		int n;
		Seat s;
		
		System.out.println("--- 영화 예매 ---\n");
		
		do {
			System.out.print("(1) 영화 예매    (2) 예매한 영화 목록    (3) 예매 취소    (4) 나가기: ");
			ans = br.readLine();
			
			if(ans.equals("4")) {
				System.out.println("종료합니다.");
				break;
			}
			
			switch (ans) {
			case "1":
				ml.printMlist();
				
				System.out.print("예매할 영화의 이름을 작성해주세요: ");
				ans2 = br.readLine();
				
				n = findMovie(ans2);
				
				ul.getUser(userID - 1).addMovies(ml.getMovie(n));
				s = new Seat(ul, userID);
				
				break;

			case "2":
				System.out.println("-- 예매 리스트 --");
				ul.getUser(userID - 1).getBook().printBList();
				
				if(ul.getUser(userID - 1).getBook().isBLEmpty()) System.out.println("예매한 영화가 없습니다.");
				
				break;
				
			case "3":
				System.out.println("-- 예매 리스트 --");
				ul.getUser(userID - 1).getBook().printBList();
				
				if(ul.getUser(userID - 1).getBook().isBLEmpty()) System.out.println("예매한 영화가 없습니다.");
				else {
					System.out.print("취소할 영화를 선택해주세요(숫자입력): ");
					n = Integer.parseInt(br.readLine());
					ul.getUser(userID - 1).getBook().removeMovie(n - 1);
					ul.getUser(userID - 1).getBook().removeSeat(n - 1);
					
					System.out.println("취소되었습니다.");
				}
				
				break;
				
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		} while(true);
		
	}
	
	public int findMovie(String ans) {
		for(int i = 0; i < ml.getSize(); i++) {
			if(ml.getMovie(i).getName().equals(ans))
				return i;
		}
		
		return -1;
	}
	
	

}
