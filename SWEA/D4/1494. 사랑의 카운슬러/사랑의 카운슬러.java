import java.io.*;
import java.util.*;

public class Solution {
	
	static long[][] worms;
	static int n;
	static long vecSum;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			worms = new long[n][2];

			vecSum = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				worms[i][0] = Long.parseLong(st.nextToken());
				worms[i][1] = Long.parseLong(st.nextToken());
			}
			
			dfs(0, 0, new boolean[n]);
			
			sb.append("#").append(t).append(" ").append(vecSum).append("\n");
		}
		System.out.println(sb);
	}
	
	// + 지렁이 선택 (안 뽑힌 나머지는 -)
	static void dfs(int idx, int depth, boolean[] visited) {
		
		if (depth == n / 2) {
			long vecX = 0;
			long vecY = 0;
			
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					vecX += worms[i][0];
					vecY += worms[i][1];
				} else {
					vecX -= worms[i][0];
					vecY -= worms[i][1];
				}
			}
			vecSum = Math.min(vecSum, vecX * vecX + vecY * vecY);
			return;
		}
		
		if (idx == n) return;
		
		// 현재 지렁이 선택
		visited[idx] = true;
		dfs(idx + 1, depth + 1, visited);
		
		// 현재 지렁이 미선택
		visited[idx] = false;
		dfs(idx + 1, depth, visited);
		
		
	}

}
