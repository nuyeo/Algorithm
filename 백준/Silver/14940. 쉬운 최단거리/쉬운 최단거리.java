import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	static int[][] dist;
	static int[][] matrix;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		dist = new int[n][m];
		
		int startX = 0;
		int startY = 0;
		
		matrix = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < m; j++) {
		        matrix[i][j] = Integer.parseInt(st.nextToken());
		        
		        if (matrix[i][j] == 0) {
		            dist[i][j] = 0;
		        } else if (matrix[i][j] == 2) {
		            startX = i;
		            startY = j;
		            dist[i][j] = 0;
		        } else {
		            dist[i][j] = -1;
		        }
		    }
		}
		
		bfs(startX, startY);
		
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        sb.append(dist[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int startX, int startY) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY});
		dist[startX][startY] = 0;
		
		while (!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (matrix[nx][ny] == 1 && dist[nx][ny] == -1) {
						dist[nx][ny] = dist[x][y] + 1;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}

}
