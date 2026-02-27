import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int [n+1];
		for (int i = 0; i <= n; i++) parent[i] = i;
		
		int cnt = n;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 유니온 파인드 풀이
			if (union(u, v)) cnt--;
		}
		
		System.out.println(cnt);
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX != rootY) {
			parent[rootY] = rootX;
			return true;
		}
		return false;
	}
}
