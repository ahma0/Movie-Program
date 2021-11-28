package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogInRegister {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	UserList ul;
	
	public LogInRegister(UserList ul) {
		this.ul = ul;
	}
	
	public int lr() throws IOException {		//로그인 or 회원가입
		int ans;
		
		while(true) {
			System.out.print("(0) 로그인    (1) 회원가입: ");
			ans = Integer.parseInt(br.readLine());
		
			if(ans == 0) return login();			// 로그인 함수로 이동
			else if (ans == 1) return register();	// 회원가입 함수로 이동
			else
				System.out.println("잘못된 입력입니다.");
		}
		
	}
	
	private int login() throws IOException {
		String id, pw;
		int num;
		
		System.out.println("\n\nLogIn\n");
		
		while(true) {
			System.out.print("ID: ");
			id = br.readLine();
			System.out.print("PW: ");
			pw = br.readLine();
			
			num = findUser(id, pw);
			
			if(num != -1) {
				
				System.out.println("로그인 되었습니다.");
				return num;
			}
			else 
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			
		}
	}
	
	private int findUser(String id, String pw) {		//찾으면 식별번호 리턴 못찾으면 -1
		for(int i = 0; i < ul.getSize(); i++) {
			if(id.equals(ul.getUser(i).getID())) {
				if(pw.equals("-1")) 
					return ul.getUser(i).getUserNum();
				else {
					if(pw.equals(ul.getUser(i).getPW())) 
						return ul.getUser(i).getUserNum();
					else break;
				}
			}
		}
		
		return -1;
	}
	
	private int register() throws IOException {
		String name, id, pw;
		int num;
		
		System.out.println("\n\nRegister\n");
		
		while(true) {
			System.out.print("Name: ");
			name = br.readLine();
			System.out.print("ID: ");
			id = br.readLine();
			System.out.print("PW: ");
			pw = br.readLine();
			
			num = findUser(id, "-1");
			
			if(num == -1) {
				ul.addUsers(new User_Info(id, pw, name));
				System.out.println("회원가입 되었습니다.");
				System.out.println("다시 로그인 해주세요.");
				num = login();
				return num;
			}
			else System.out.println("이미 사용되고 있는 아이디입니다.");
			
		}
	}
}
