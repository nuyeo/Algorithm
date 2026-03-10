import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] moves = new int[101];
		for (int i = 0; i <= 100; i++) {
			moves[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int ladderStart = Integer.parseInt(st.nextToken());
			int ladderEnd = Integer.parseInt(st.nextToken());
			moves[ladderStart] = ladderEnd;
		}
		
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int snakeStart = Integer.parseInt(st.nextToken());
			int snakeEnd = Integer.parseInt(st.nextToken());
			moves[snakeStart] = snakeEnd;
		}
		
		int[] visited = new int[101];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		visited[1] = 0;
		q.offer(1);
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			
			if (cur == 100) {
				System.out.println(visited[100]);
				break;
			}
			
			for (int k = 1; k <= 6; k++) {
				int nxt = cur + k;
				if (nxt <= 100) {
					nxt = moves[nxt];
					
					if (visited[nxt] == -1) {
						visited[nxt] = visited[cur] + 1;
						q.offer(nxt);
					}
				}
			}
		}
	}
}
