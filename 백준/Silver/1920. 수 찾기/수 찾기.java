import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if (Arrays.binarySearch(nums, target) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.print(sb);
	}

}
