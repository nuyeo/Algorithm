import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] trees;
	static int N, result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			trees = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				trees[n] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(trees);
			result = Math.min(findMinDays(trees[N-1]), findMinDays(trees[N-1]+1));
			
			sb.append("#"+t+" "+result).append("\n");
		}
		System.out.print(sb);
	}
	
	static int findMinDays(int target) {
		int cnt1 = 0, cnt2 = 0; // 1의 개수, 2의 개수
		// 1의 개수, 2의 개수 구하기
		for (int i=0; i<N; i++) {
			int diff = target - trees[i];
			cnt2 += diff / 2;
			cnt1 += diff % 2;
		}
		
		// 
		if (cnt2>cnt1) {
			// 2의 개수 > 1의 개수
			// 2의 개수와 1의 개수가 비슷해질 때까지 2를 1 두 개로 쪼개기
			while(cnt2 - cnt1 > 1) {
				cnt2--;
				cnt1 += 2;
			}
		}
			
		if (cnt2<cnt1) {
			return cnt1*2 - 1;
		} else { 
			// 2의 개수 == 1의 개수
			// 2의 개수 < 1의 개수
			return cnt2*2;
		} 
	}

}
