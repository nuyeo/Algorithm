import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	static int[] memo = new int[100000];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			Arrays.fill(memo, -1);
			System.out.println("#" + t + " " + solve(N));
		}

	}
	
	static int solve(int n) {
		// N이 한 자리 수
		if (n<10) return 0;
		
		// 이미 계산했던 수
		if (memo[n]!=-1) return memo[n];
		
		int maxTurn = 0; // 최대 턴 수
		String s = String.valueOf(n); 
		int len = s.length();
		
		// 비트마스크로 간격 선택
		for (int i=1; i<(1<<(len-1)); i++) {
			List<Integer> parts = new ArrayList<>();
			int start = 0;
			
			for (int j=0; j<len-1; j++) {
				if ((i&(1<<j))!=0) {
					parts.add(Integer.parseInt(s.substring(start, j+1)));
					start = j+1;
				}
			}
			
			// 마지막 남은 부분 추가
            parts.add(Integer.parseInt(s.substring(start)));

            // 쪼개진 숫자들의 곱 구하기
            int product = 1;
            for (int p : parts) product *= p;

            // 최댓값 갱신
            maxTurn = Math.max(maxTurn, 1 + solve(product));
			
		}
		
		return memo[n] = maxTurn;
	}

}
