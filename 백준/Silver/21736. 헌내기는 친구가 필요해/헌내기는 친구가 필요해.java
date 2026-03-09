import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static char[][] matrix;
	static boolean[][] visited;
	static int n;
	static int m;
	static int cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new char[n][m];
		visited = new boolean[n][m];
		cnt = 0;
		int startR = 0;
		int startC = 0;
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = s.charAt(j); // O: 빈 공간, X: 벽, I: 도연이, P: 사람
				if (matrix[i][j] == 'I') {
					startR = i;
					startC = j;
					visited[i][j] = true;
				}
			}
		}
		dfs(startR, startC);
		
		System.out.println(cnt == 0 ? "TT" : cnt);

	}
	
	static void dfs(int r, int c) {
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!visited[nr][nc] && matrix[nr][nc] != 'X') {
					if (matrix[nr][nc] == 'P') cnt++;
					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}

}
