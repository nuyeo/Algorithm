import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int result = countSheep(N);
			
			System.out.println("#"+t+" "+result);
		}

	}
	
	static int countSheep(int N) {
		int cnt = 0, i = 0;
		boolean[] visited = new boolean[10]; // 0~9 포함 여부 저장
		
		while(cnt<10) {
			i++;
			int curN = i*N;
			
			while(curN>0) {
				int num = curN % 10;
				if (!visited[num]) {
					visited[num] = true;
					cnt++;
				}
				curN /= 10;	
			}	
		}

		return i*N;
	}

}
