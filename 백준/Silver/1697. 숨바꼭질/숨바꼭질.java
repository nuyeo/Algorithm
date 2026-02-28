import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[100001];
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		dist[n] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == k) {
				System.out.println(dist[cur]);
				return;
			}
			
			int[] nextCur = {cur-1, cur+1, cur*2};
			
			for (int next : nextCur) {
				if (next >= 0 && next <= 100000 && dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}
	}

}
