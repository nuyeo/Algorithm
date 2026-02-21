import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			// 배열에 숫자 채우기
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
			
            boolean isReversed = false;
            boolean isError = false;
            
            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed; // 정방향/역방향 여부 저장
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast(); // 뒤집힌 상태면 뒤에서 제거
                    } else {
                        deque.removeFirst(); // 정방향이면 앞에서 제거
                    }
                }
            }
            
            if (isError) sb.append("error\n");
            else {
            	sb.append("[");
            	while (!deque.isEmpty()) {
            		sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
            		if (!deque.isEmpty()) sb.append(",");
            	}
            	sb.append("]\n");
            }
		}
		System.out.print(sb);
	}
	
}
