import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			
			String line = br.readLine();
			if (line.equals(".")) break;
			
			sb.append(solve(line)).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static String solve(String str) {
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(' || c == '[') {
				stack.push(c);
			}
			else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return "no";
				}
				stack.pop();
			}
			else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return "no";
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty() ? "yes" : "no";
	}

}
