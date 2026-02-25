import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> list = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		
		for (int j = 0; j < m; j++) {
			String name = br.readLine();
			if (list.contains(name)) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		sb.append(result.size() + "\n");
		for (String s : result) {
			sb.append(s + "\n");
		}
		
		System.out.print(sb);
	}

}
