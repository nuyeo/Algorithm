import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		int start = 0;
		int end = trees[n-1];
		int ans = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			
			for (int tree : trees) {
				 sum += (tree > mid ? tree - mid : 0);
			}
			
			if (sum >= m) {
				ans = mid;
				start = mid + 1;	
			} else {
				end = mid - 1;
			}
		}
		
		System.out.print(ans);

	}

}
