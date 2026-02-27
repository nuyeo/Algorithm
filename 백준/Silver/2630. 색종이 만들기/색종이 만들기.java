import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] matrix;
	static int n;
	static int Wcnt = 0, Bcnt = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		matrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, n);
		System.out.print(Wcnt + "\n" + Bcnt);
		
	}
	
	static void solve(int r, int c, int size) {
		
		if (isSameColor(r, c, size)) {
			if (matrix[r][c] == 0) {
				Wcnt++;
			}
			else {
				Bcnt++;
			}
			return;
		}
		
		size /= 2;
		
		solve(r, c, size);
		solve(r + size, c, size);
		solve(r, c + size, size);
		solve(r + size, c + size, size);
		
	}
	
	static boolean isSameColor(int r, int c, int size) {
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (matrix[i][j] != matrix[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

}
