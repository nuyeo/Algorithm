import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] matrix;
	static boolean[][] visited;
	static int n;
	static int m;
	static int totalDays;
	static Queue<Node> q = new LinkedList<>();
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()); // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸
				if (matrix[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new Node(i, j, 0));
				}
			}
		}
		
		// bfs 구현
		bfs();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					totalDays = -1;
				}
			}
		}
		
		System.out.println(totalDays);
	}
	
	static void bfs() {
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			totalDays = Math.max(totalDays, cur.days);
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if (!visited[nr][nc] && matrix[nr][nc] == 0) {
						matrix[nr][nc] = 1;
						visited[nr][nc] = true;
						q.offer(new Node(nr, nc, cur.days + 1));
					}
				}
			}
		}
	}
	
	static class Node {
		
		int r;
		int c;
		int days;

		Node(int r, int c, int days) {
			this.r = r;
			this.c = c;
			this.days = days;
		}
	}
}
