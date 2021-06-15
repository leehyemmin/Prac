package ex03;

import java.util.*;

public class HashMapEx01 {

	public static void main(String[] args) {

		HashMap map = new HashMap();
		
		// ID, PW
		map.put("myId", "1234");
		map.put("aaaa", "1111");
		map.put("aaaa", "1234");
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 pw를 입력해주세요.");
			System.out.println("id : ");
			String id = s.nextLine().trim(); 
			
			System.out.println("pw : ");
			String pw = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}else {
				if(!(map.get(id)).equals(pw)) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}else {
					System.out.println("id와 pw가 일치합니다.");
					break;
				}
			}
		}
	}

}
