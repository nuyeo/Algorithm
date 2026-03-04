import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0, 0, 0};
	static final int[] dc = {0, 0, -1, 1, 0, 0};
	static final int[] dz = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] matrix = new int[n][m][h];
		boolean[][][] visited = new boolean[n][m][h];
		Queue<Node> q = new LinkedList<>();
		int result = 0;
		
		for (int d = 0; d < h; d++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					matrix[i][j][d] = Integer.parseInt(st.nextToken()); // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸
					if (matrix[i][j][d] == 1) {
						visited[i][j][d] = true;
						q.offer(new Node(i, j, d, 0));
					}
				}
			}
		}
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			result = Math.max(cur.days, result);
			
			for (int i = 0; i < 6; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				int nz = cur.z + dz[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && nz >= 0 && nz < h) {
					if (!visited[nr][nc][nz] && matrix[nr][nc][nz] == 0) {
						matrix[nr][nc][nz] = 1;
						visited[nr][nc][nz] = true;
						q.offer(new Node(nr, nc, nz, cur.days+1));
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < h; d++) {
					if (matrix[i][j][d] == 0) {
						result = -1;
					}
				}
			}
		}
		
		System.out.println(result);	
	}
	
	static class Node {
		
		int r;
		int c;
		int z;
		int days;
		
		Node (int r, int c, int z, int days) {
			this.r = r;
			this.c = c;
			this.z = z;
			this.days = days;
		}
	}

}
