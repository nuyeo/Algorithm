import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static boolean[] visited;
	static Node[] nodes;
	static int ans;
	static Node home;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			nodes = new Node[n];
			visited = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node office = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 회사 좌표
			home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 집 좌표
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // n명의 고객 좌표
			}
			
			// 회사에서 가장 가까운 고객 방문
			ans = Integer.MAX_VALUE;
			dfs(0, 0, office);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int getDist(Node node1, Node node2) {
		return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y); 
	}
	
	static void dfs(int cnt, int sum, Node cur) {
		// 가지치기
	    if (sum >= ans) return;

	    // 모든 고객을 다 방문했을 때
	    if (cnt == n) {
	        int totalDist = sum + getDist(cur, home);
	        ans = Math.min(ans, totalDist);
	        return;
	    }

	    for (int i = 0; i < n; i++) {
	        if (!visited[i]) {
	            visited[i] = true;
	            dfs(cnt + 1, sum + getDist(cur, nodes[i]), nodes[i]);
	            visited[i] = false;
	        }
	    }
	}
}
