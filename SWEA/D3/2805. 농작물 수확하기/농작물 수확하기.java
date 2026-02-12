import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] farm;
	static int result, N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
            result = 0;
			for (int i=0; i<N; i++) {
				String line = br.readLine();
				for (int j=0; j<N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}
			
			harvest();
			
			sb.append("#"+t+" "+result).append("\n");
		}
		System.out.print(sb);
	}
	
	static void harvest() {
		// 가운데 열 계산
		int mid = N/2;
		int midSum = 0;
		
		for (int i=0; i<N; i++) {
			result += farm[i][mid];
		}
		
		// 양쪽으로 열 이동하며 계산
		int i=1;
		while (i+mid<=N) {
			for (int j=i; j<N-i; j++) {
				result += (farm[j][mid-i] + farm[j][mid+i]);
			}
			i++;
		}
	}

}
