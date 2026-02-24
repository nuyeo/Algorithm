import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M]; // 체스판 칠해진 정보
		int[][] wrongPaint = new int[N][M]; // 잘못 칠해진 칸 정보
		int[][] prefixSum = new int[N+1][M+1]; // 누적합 저장할 배열
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if ((i + j) % 2 == 0) {
					if (board[i][j] != 'W') {
						wrongPaint[i][j] = 1;
					}
				} else {
					if (board[i][j] == 'W') {
						wrongPaint[i][j] = 1;
					}
				}
			}
		}
		
		// 누적합 배열 생성
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				prefixSum[i][j] = wrongPaint[i-1][j-1] 
								+ prefixSum[i-1][j] 
								+ prefixSum[i][j-1] 
								- prefixSum[i-1][j-1];
			}
		}
		
		int minSquares = 64;
		
		for (int i = 8; i <= N; i++) {
			for (int j = 8; j <= M; j++) {
				int curSum = prefixSum[i][j]
						   - prefixSum[i-8][j]
						   - prefixSum[i][j-8]
						   + prefixSum[i-8][j-8];
				curSum = Math.min(curSum, 64 - curSum);
				minSquares = Math.min(minSquares, curSum);
			}
		}
		
		System.out.print(minSquares);
		br.close();

	}

}
