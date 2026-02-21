import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		String[] result = set.toArray(new String[0]);
		
		Arrays.sort(result, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : result) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}

}
