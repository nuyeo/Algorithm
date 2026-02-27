import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0};
	static int[][] matrix;
	static boolean[][] visited;
	static int m;
	static int n;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			matrix = new int[m][n];
			visited = new boolean[m][n];
			int cnt = 0;
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && matrix[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.print(sb);

	}
	
	static void dfs(int x, int y) {
		
		if (visited[x][y]) return;
		
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
				if (matrix[nx][ny] == 1) {
					dfs(nx, ny);
				}
				
			}
		}
	}

}
