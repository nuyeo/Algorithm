import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t=0; t<T; t++) {
			String s = br.readLine();

			int[] result = isPalindrome(s);
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static int[] recursion(String s, int l, int r, int cnt) {
		cnt++;
		
		if (l >= r) {
			return new int[] {1, cnt};
		}
		else if (s.charAt(l) != s.charAt(r)) {
			return new int[] {0, cnt};
		}
		else {
			return recursion(s, l+1, r-1, cnt);
		}
	}
	
	public static int[] isPalindrome(String s) {
		return recursion(s, 0, s.length()-1, 0);
	}

}
