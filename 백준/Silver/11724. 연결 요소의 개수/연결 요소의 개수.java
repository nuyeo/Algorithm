import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
		}
		
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		
		// bfs 구현
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				bfs(graph, i, visited);
				cnt++;
			}
		}
		System.out.print(cnt);
	}
	
	static void bfs(HashMap<Integer, ArrayList<Integer>> graph, int i, boolean[] visited) {
		
		visited[i] = true;
		
		if (graph.get(i) == null) return;
		
		for (int node : graph.get(i)) {
			if (!visited[node]) {
				bfs(graph, node, visited);
			}
		}
	}
	

}
