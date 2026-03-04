import java.io.*;

public class Main {
	
	static int n;
	static int[] stairs;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		stairs = new int[301];
		dp = new int[301];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		if (n >= 2) dp[2] = stairs[1] + stairs[2];
		if (n >= 3) {
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
			}
		}
		
		System.out.println(dp[n]);
	}

}
