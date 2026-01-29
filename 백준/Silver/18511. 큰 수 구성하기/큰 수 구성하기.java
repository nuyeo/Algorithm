import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int N, K_cnt;
	static int[] k;
	static int maxNum;

	public static void main(String[] args) throws IOException {  
        
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K_cnt = sc.nextInt();
		k = new int[K_cnt];
		
		for (int i=0; i<K_cnt; i++) {
			k[i] = sc.nextInt();
		}
		
		recur(0);
		
		System.out.println(maxNum);

	}
	
	public static void recur(int cur) {
		if (cur > N) return;
		
		if (cur <= N) {
			maxNum = Math.max(maxNum, cur);
		}
		
		for (int i=0; i<K_cnt; i++) {
			if (cur > 100_000_000) return;
			recur(cur * 10 + k[i]);
		}
		
	}
    
}
