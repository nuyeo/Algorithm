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
		int[] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		Arrays.fill(result, 1);
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			degree[b]++;
		}
		
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : list[cur]) {
				result[next] = Math.max(result[next], result[cur] + 1);
				degree[next]--;
				
				if (degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);

	}

}
