import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	static int minTime, N;
	static int[][] matrix;
	static int[][] minDist;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			minDist= new int[N][N];
			for (int i=0; i<N; i++) {
				String str = br.readLine();
				for (int j=0; j<N; j++) {
					matrix[i][j] = str.charAt(j) - '0';
					minDist[i][j] = Integer.MAX_VALUE;
				}
			}
			dfs(0, 0, 0);
			
			System.out.println("#"+t+" "+minDist[N-1][N-1]);
		}

	}
	
	static void dfs(int x, int y, int time) {
		
		if (time >= minDist[x][y]) return;
		
		minDist[x][y] = time;
		
		if (x==N-1 && y==N-1) return;
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx>=0 && nx<N && ny>=0 && ny<N) {
				dfs(nx, ny, time + matrix[nx][ny]);
			}
		}
		
	}

}
