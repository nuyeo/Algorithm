import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] operators = {0, 0, 0, 0}; // +, -, *, /
	static int[] numbers;
	static int maxResult, minResult;
	static int[] output;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			// 숫자의 개수
			N = Integer.parseInt(br.readLine());
			// 각 연산자의 개수 (+, -, *, /)
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}
			// 수식에 사용되는 숫자
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				numbers[n] = Integer.parseInt(st.nextToken());
			}
			
			// 최댓값, 최솟값, 계산 배열 초기화
			maxResult = -100_000_000;
			minResult = 100_000_000;
			output = new int[4];
			
			dfs(1, numbers[0]);
			
			// 출력
			int result = maxResult - minResult;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb);

	}
	
	static void dfs(int depth, int total) {
        // 연산자 모두 결정되면 결과 저장
        if (depth==N) {
            maxResult = Math.max(maxResult, total);
            minResult = Math.min(minResult, total);
            return;
        }
        
        // 연산자 뽑고 종류에 따라 결과 계산
        for (int i=0; i<4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용
                
                
                int nextTotal = total;
                if (i==0) nextTotal += numbers[depth];      // +
                else if (i==1) nextTotal -= numbers[depth]; // -
                else if (i==2) nextTotal *= numbers[depth]; // *
                else if (i==3) nextTotal /= numbers[depth]; // /
                
                dfs(depth+1, nextTotal);
                
                operators[i]++;
            }
        }
    }

}
