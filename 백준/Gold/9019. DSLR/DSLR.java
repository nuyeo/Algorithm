import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultSb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 초기 값
			int b = Integer.parseInt(st.nextToken()); // 최종 값
			
			boolean[] visited = new boolean[10000];
			int[] parent = new int[10000];
			char[] command = new char[10000];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(a);
			visited[a] = true;
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				if (cur == b) break;
				
				for (char cmd : new char[] {'D', 'S', 'L', 'R'}) {
					int nxt = calc(cmd, cur);
					
					if (!visited[nxt]) {
						visited[nxt] = true;
						parent[nxt] = cur;
						command[nxt] = cmd;
						q.add(nxt);
					}
				}
				
			}
			
			StringBuilder sb = new StringBuilder();
            int now = b;
            while (now != a) {
                sb.append(command[now]);
                now = parent[now];
            }
            resultSb.append(sb.reverse().toString()).append("\n");
        }
        System.out.print(resultSb);			

	}
	
	static int calc(char cmd, int n) {
		
		switch (cmd) {
		case 'D':
			return (n * 2) % 10000;
		case 'S':
			return (n == 0) ? 9999 : n - 1;
		case 'L':
			return (n % 1000) * 10 + (n / 1000);
		case 'R':
			return (n % 10) * 1000 + (n / 10);
		default:
			return n;
		}
	}

}
