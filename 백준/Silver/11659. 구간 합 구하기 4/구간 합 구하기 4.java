import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] prefixSum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		prefixSum[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= n; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(prefixSum[b] - prefixSum[a-1]).append("\n");
		}
		
		System.out.print(sb);
	}

}
