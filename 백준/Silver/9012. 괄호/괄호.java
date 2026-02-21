import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			Stack<String> stack = new Stack<>();
			boolean isTrue = true;
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.add("(");
				} else {
					if (stack.isEmpty()) {
						isTrue = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if (!stack.isEmpty()) isTrue = false;
			if (isTrue) System.out.println("YES");
			else System.out.println("NO");
		}

	}

}
