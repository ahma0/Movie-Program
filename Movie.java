package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Movie {
	Random r = new Random();
	MovieList ml = new MovieList();
	UserList ul = new UserList();
	Movie_Info m;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void First_Setting() {
		//초기 영화 정보
		ml.addMlist(new Movie_Info("액시트", "액션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("해리포터", "판타지", r.nextInt(50) + 1, r.nextInt(5) + 5));
		ml.addMlist(new Movie_Info("라푼젤", "애니메이션", r.nextInt(50) + 1, r.nextInt(5) + 5));
		
		ml.printMlist();
		
		//초기 유저 세팅
		ul.addUsers(new User_Info("firstuser34", "qwerty1234", "홍길동"));
		ul.printUlist();
	}
	
	public void lr() throws IOException {		//로그인 or 회원가입
		int ans;
		
		System.out.print("(0) 로그인    (1) 회원가입: ");
		ans = Integer.parseInt(br.readLine());
		
		if(ans == 0) login();			// 로그인 함수로 이동
		else if (ans == 1) register();	// 회원가입 함수로 이동
		
	}
	
	private void login() throws IOException {
		String id, pw;
		boolean flag = false;
		
		System.out.println("\n\nLogIn\n");
		
		do {
			System.out.print("ID: ");
			id = br.readLine();
			System.out.print("PW: ");
			pw = br.readLine();
			
			if(findUser(id, pw)) {
				flag = true;
				System.out.println("로그인 되었습니다.");
			}
			else 
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			
		} while(!flag);
	}
	
	private boolean findUser(String id, String pw) {		//찾으면 true 못찾으면 false
		for(int i = 0; i < ul.getSize(); i++) {
			if(id.equals(ul.getUser(i).getID())) {
				if(pw.equals("-1")) return true;
				else {
					if(pw.equals(ul.getUser(i).getPW())) return true;
					else break;
				}
			}
		}
		
		return false;
	}
	
	private void register() throws IOException {
		boolean flag = false;
		String name, id, pw;
		
		System.out.println("\n\nRegister\n");
		
		do {
			System.out.print("Name: ");
			name = br.readLine();
			System.out.print("ID: ");
			id = br.readLine();
			System.out.print("PW: ");
			pw = br.readLine();
			
			if(!findUser(id, "-1")) {
				flag = true;
				ul.addUsers(new User_Info(id, pw, name));
				System.out.println("회원가입 되었습니다.");
				System.out.println("다시 로그인 해주세요.");
				login();
			}
			else System.out.println("이미 사용되고 있는 아이디입니다.");
			
		}while(!flag);
	}

}
