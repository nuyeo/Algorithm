import java.util.Scanner;

// BufferedReader 쓰면 에러남
public class Solution {
	
	static int[] H;
	static int N;
	static long cnt;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			cnt = 0;
			H = new int[N];
			for (int n=0; n<N; n++) {
				H[n] = sc.nextInt();
			}
			
			findMountains(0);
			
			System.out.println("#"+t+" "+cnt);
		}
		
	}
	
	static void findMountains(int idx) {
		while (idx<N-1) {
			int up = 0, down = 0;
			
			// 올라가는 구간 찾기
			while (idx<N-1 && H[idx]<H[idx+1]) {
				up++;
				idx++;
			}
			
			// 내려가는 구간 찾기
			while (idx<N-1 && H[idx]>H[idx+1]) {
				down++;
				idx++;
			}
			
			// 산 조건을 만족할 경우
			if (up>0 && down>0) {
				cnt += (long) up*down;
			}
		}
	}

}
