import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] targets = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 카드 개수를 배열에 저장
		final int MAX_NUM = 20_000_001;
		int[] counts = new int[MAX_NUM];
		for (int card : cards) {
			counts[card + 10_000_000]++;
		}
		
		// 가지고 있는 개수를 결과 배열에 저장
		ArrayList<Integer> result = new ArrayList<>();
		for (int target : targets) {
			result.add(counts[target + 10_000_000]);
		}
		
		for (int k : result) {
			sb.append(k + " ");
		}
		
		System.out.print(sb);
	}

}
