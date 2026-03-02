import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		int[] degree = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			degree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int j = 1; j <= n; j++) {
			if (degree[j] == 0) {
				q.add(j);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int k : list[cur]) {
				degree[k]--;
				if (degree[k] == 0) {
					q.add(k);
				}
			}
		}
		
		System.out.println(sb);
	}

}
