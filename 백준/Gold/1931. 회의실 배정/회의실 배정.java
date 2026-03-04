import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meetings = new int[n][2];
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}
		
		// 종료시간 기준 오름차순 정렬, 종료 시간이 같으면 시작 시간 기준 오름차순 정렬
		Arrays.sort(meetings, (a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			} else {
				return Integer.compare(a[1], b[1]);
			}
		});
		
		int prevEndTime = 0; // 이전 회의 종료 시간
		for (int i = 0; i < n; i++) {
			if (meetings[i][0] >= prevEndTime) {
				prevEndTime = meetings[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
