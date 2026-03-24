import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int dPow = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); // 두 중심 사이 거리의 제곱
			int rMinusPow = (r1 - r2) * (r1 - r2);
			int rPlusPow = (r1 + r2) * (r1 + r2);
			
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append("\n");
			} else if (dPow > rPlusPow || dPow < rMinusPow) {
				sb.append(0).append("\n");
			} else if (dPow == rPlusPow || dPow == rMinusPow) {
				sb.append(1).append("\n");
			} else {
				sb.append(2).append("\n");
			}
		}
		System.out.println(sb);
	}

}
