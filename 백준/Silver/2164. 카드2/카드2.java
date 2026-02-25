import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> cards = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			cards.add(i);
		}
		
		while(cards.size() > 1) {
			cards.poll();
			cards.add(cards.poll());
		}
		
		System.out.print(cards.poll());

	}

}
