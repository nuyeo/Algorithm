import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 그래프 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 그래프 정렬
		for (int i = 0; i <= n; i++) {
			Collections.sort(graph[i]);
		}
		
		// dfs
		visited = new boolean[n+1];
		dfs(v);
		sb.append("\n");
		
		// bfs
		visited = new boolean[n+1];
		bfs(v);
		
		System.out.println(sb);
		
	}
	
	static void dfs(int x) {
		
		visited[x] = true;
		sb.append(x).append(" ");
		
		for (int nx : graph[x]) {
			if (!visited[nx]) {
				dfs(nx);
			}
		}
	}
	
	static void bfs(int x) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int nx : graph[cur]) {
				if (!visited[nx]) {
					visited[nx] = true;
					q.add(nx);
				}
			}
			
		}
	}

}
