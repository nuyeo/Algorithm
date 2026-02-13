import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static final int[] dx = {0, 0, 1, 0, -1}; // 0: 제자리, 1: 상, 2: 우, 3: 하, 4: 좌
	static final int[] dy = {0, -1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // M: 총 이동 시간
			int N = Integer.parseInt(st.nextToken()); // N: BC의 개수
			
			int[] A = new int[M+1]; // A: A의 이동 정보
			int[] B = new int[M+1]; // B: B의 이동 정보
			// 첫 이동은 0으로 설정 (= 초기 위치)
			A[0] = 0;
			B[0] = 0;
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<BC> bcList = new ArrayList<>(); // bc: BC 정보
			
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1; // x: BC의 x좌표 ((0, 0) 시작으로 보정)
				int y = Integer.parseInt(st.nextToken()) - 1; // y: BC의 y좌표 ((0, 0) 시작으로 보정)
				int c = Integer.parseInt(st.nextToken()); // c: BC의 충전 범위
				int p = Integer.parseInt(st.nextToken()); // p: BC의 충전량
				
				bcList.add(new BC(x, y, c, p));
			}
			
			int result = solve(M, A, B, bcList);
			
			sb.append("#"+t+" "+result).append("\n");
			
		}
		
		System.out.print(sb);

	}
	
	static int solve(int M, int[]A, int[]B, ArrayList<BC> bcList) {
		// A, B 충전량 합의 최댓값 계산
		
		int totalSum = 0; // A, B의 누적 충전량의 합
		int ax = 0, ay = 0; // A의 초기 좌표
		int bx = 9, by = 9; // B의 초기 좌표
		
		for (int time=0; time<M+1; time++) {
			// 1. 현재 A, B 좌표 구하기
			int[] posA = move(ax, ay, A[time]);
			ax = posA[0];
			ay = posA[1];
			
			int[] posB = move(bx, by, B[time]);
			bx = posB[0];
			by = posB[1];
			
			// 2. 그때의 최댓값 계산하기
			// 가능한 모든 충전기에 대한 경우의 수 탐색, 그 중 최댓값을 curSum에 저장
			int N = bcList.size();
			int curSum = 0;
			for (int i=0; i<N; i++) {
				int curA = charge(ax, ay, bcList.get(i));
				for (int j=0; j<N; j++) {
					int curB = charge(bx, by, bcList.get(j));
					
					// A와 B가 같은 BC에 연결할 경우, 충전량을 반으로 나눔
					if (i==j) curSum = Math.max(curSum, curB);
					else curSum = Math.max(curSum, curA+curB);
				}
			}
			
			// 구한 curSum을 누적 충전량에 더해줌
			totalSum += curSum;
		}
		
		return totalSum;
	}
	
	// 충전 범위에 포함되면 파워(충전량) 반환
	static int charge(int x, int y, BC bc) {
		int d = Math.abs(bc.x - x) + Math.abs(bc.y - y);
		return d <= bc.c ? bc.p : 0;
	}
	
	
	// 주어진 방향으로 좌표 이동
	static int[] move(int x, int y, int dir) {
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		return new int[] {nx, ny};
	}
	
	static class BC {
		
		int x; // x 좌표
		int y; // y 좌표
		int c; // 충전 범위
		int p; // 충전량
		

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

}
