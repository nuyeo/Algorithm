import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static int[][] matrix;
	static boolean[][] visited;
	static int n;
	static int minBridge = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int islandIdx = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j] && matrix[i][j] != 0) {
					bfs(i, j, islandIdx++);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] >= 2) {
					boolean isEdge = false;
					for (int d = 0; d < 4; d++) {
					    int ni = i + dr[d];
					    int nj = j + dc[d];
					    if (ni >= 0 && ni < n && nj >= 0 && nj < n && matrix[ni][nj] == 0) {
					        isEdge = true; // 섬의 가장자리
					        break;
					    }
					}
					
					if (isEdge) {
						int result = solve(i, j, matrix[i][j]);
						if (result != -1) {
							minBridge = Math.min(minBridge, result);
						}
					}
				}
			}
		}
		
		System.out.println(minBridge);

	}
	
	static void bfs(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		matrix[r][c] = cnt;
		q.offer(new int[]{r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (!visited[nr][nc] && matrix[nr][nc] != 0) {
						visited[nr][nc] = true;
						matrix[nr][nc] = cnt;
						q.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	static int solve(int r, int c, int curIsland) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] bridgeVisited = new boolean[n][n];
		
		q.offer(new int[] {r, c, 0});
		bridgeVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int dist = cur[2];
			
			if (dist >= minBridge) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (bridgeVisited[nr][nc]) continue;
				
				// 다음 칸이 다른 섬 (다리 끝냄)
				if (matrix[nr][nc] != 0 && matrix[nr][nc] != curIsland) {
					return dist;
				}
				
				// 다음 칸이 바다 (다리 계속 놓음)
				if (matrix[nr][nc] == 0) {
					bridgeVisited[nr][nc] = true;
					q.offer(new int[] {nr, nc, dist+1});
				}
			}
		}
		
		return -1;
	}

}
