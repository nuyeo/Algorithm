import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			LinkedList<Docs> docs = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				docs.add(new Docs(Integer.parseInt(st.nextToken()), i));
			}
			int cnt = 0;
			
			while (cnt <= n) {
				int curPriority = docs.peek().priority;
				boolean canPrint = true;
				for (Docs doc : docs) {
					if (doc.priority > curPriority) {
						docs.add(docs.poll());
						canPrint = false;
						break;
					}
				}
				if (canPrint) {
					Docs curDoc = docs.poll();
					cnt++;
					
					if(curDoc.idx == m) {
						System.out.println(cnt);
						break;
					}
				}
			}
		}
		
	}
	
	static class Docs {
		int priority;
		int idx;
		
		Docs(int priority, int idx) {
			this.priority = priority;
			this.idx = idx;
		}

	}

}
