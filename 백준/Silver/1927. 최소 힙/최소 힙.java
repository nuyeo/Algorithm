import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			
			if (k == 0) {
				System.out.println(minHeap.isEmpty() ? 0 : minHeap.poll());
			}
			else {
				minHeap.add(k);
			}
		}
	}

}
