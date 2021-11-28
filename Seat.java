package movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seat {			//자리 예매
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private char s[][] = new char[12][12];
	private int userID = 0;
	//Movie m;
	UserList u = new UserList();
	
	Seat(UserList u, int userID) throws IOException {
		//this.m = m;
		this.userID = userID;
		this.u = u;
		
		init();
		book();
	}
	

	private void init() {
		int alpha = 97;
		int n = 48;
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				
				if(i == 0 && j == 0) s[i][j] = ' ';
				else if(i == 0 && j != 6) {
					s[i][j] = (char)alpha;
					alpha++;
				}
				else if(j == 0 && i != 6) {
					s[i][j] = (char)n;
					n++;	
				}
				else if(i == 6 || j == 6) s[i][j] = ' ';
				else s[i][j] = '□';
			}
		}
	}
	
	private void book() throws IOException {				//함수로 나눠야할듯..
		//boolean flag = false;
		String ans;
		//int n = 0, ansn = 0;
		
		printSeat();
		System.out.print("예약할 좌석을 선택해주세요: ");
		ans = br.readLine();
		SBooking(ans);
		u.getUser(userID - 1).getBook().addSeats(ans);
		
		/*
		do {	
			System.out.print("(1) 좌석 예약 \t (2) 좌석 변경 \t (3) 좌석 취소 \t (4) 나가기: ");
			n = Integer.parseInt(br.readLine());
			if(n == 4) {
				System.out.println("종료되었습니다.");
				return;
			}
		
			switch (n) {
			case 1:
				printSeat();
				System.out.print("예약할 좌석을 선택해주세요: ");
				ans = br.readLine();
				SBooking(ans);
				u.getUser(userID - 1).getBook().addSeats(ans);
				
				break;

			case 2:
				changeSeat();
				
				break;
				
			case 3:
				u.getUser(userID - 1).getBook().printBSList();
				
				if(u.getUser(userID - 1).getBook().getSInfo().isEmpty()) {
					System.out.println("\t목록이 비어있습니다.");
					break;
				}
				
				System.out.print("취소할 좌석 번호를 선택해주세요: ");
				ansn = Integer.parseInt(br.readLine());
				u.getUser(userID - 1).getBook().removeSeat(ansn - 1);
				System.out.println("취소되었습니다.\n");
				
				u.getUser(userID - 1).getBook().printBSList();
				
				break;
				
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
	
		} while(!flag);
		*/
	}
	
	private void SBooking(String ans) {
		int index[] = findSeat(ans.charAt(0), ans.charAt(1));
		
		if(index[0] == -1) {
			System.out.println("다시 입력해주세요.");
			return;
		}
		
		if(s[index[0]][index[1]] == '■')
			System.out.println("이미 예약된 좌석입니다.");
		else {
			s[index[0]][index[1]] = '■';
			System.out.println("예약되었습니다.");
		}
		
	}
	
	/*
	private void changeSeat() throws IOException {
		String ans;
		int ansn = 0;
		
		printSeat();
		u.getUser(userID - 1).getBook().printBSList();		//예약한 좌석 목록 프린트
		
		if(u.getUser(userID - 1).getBook().getSInfo().isEmpty()) {
			System.out.println("\t목록이 비어있습니다.");
			return;
		}
			
		
		
		System.out.print("변경할 좌석 번호를 선택해주세요: ");
		ansn = Integer.parseInt(br.readLine());
		System.out.print("변경하고싶은 좌석을 선택해주세요: ");
		ans = br.readLine();
		
		int index[] = findSeat(u.getUser(userID - 1).getBook().getSeat(ansn - 1).charAt(0), u.getUser(userID - 1).getBook().getSeat(ansn - 1).charAt(1));
		
		if(index[0] == -1) 
			System.out.println("존재하지 않는 좌석입니다.");
		else {
			s[index[0]][index[1]] = '□';
			u.getUser(userID - 1).getBook().replaceSeat(ansn - 1, ans);
			SBooking(ans);
		}
		
	}
	*/
	private int[] findSeat(char a, char b) {
		int ans[] = new int[2];
		
		for(int i = 0; i < 12; i++) {
			if(s[0][i] == a) {
				ans[0] = i;
				
				for(int j = 0; j < 12; j++) {
					if(s[j][0] == b) {
						ans[1] = j;
						return ans;
					}
						
				}
			}
		}
		
		for(int i : ans) i = -1;
		return ans;
	}
	
	public void printSeat() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++)
				System.out.print(s[i][j] + " ");
			System.out.println();
		}
		
	}
}

