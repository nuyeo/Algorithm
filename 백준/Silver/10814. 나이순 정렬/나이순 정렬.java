import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Member[] members = new Member[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(members, (m1, m2) -> m1.age - m2.age);
		
		for (Member m : members) {
			sb.append(m.age + " " + m.name + "\n");
		}
		
		System.out.print(sb);

	}
	
	static class Member {
		int age;
		String name;
		
		Member(int age, String name){
			this.age = age;
			this.name = name;
		}
	}

}
