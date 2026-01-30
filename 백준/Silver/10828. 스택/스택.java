import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static Stack<Integer> stack = new Stack<>();
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=0; i<N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String cmd = st.nextToken();
    		
    		switch (cmd) {
    		case "push":
    			int val = Integer.parseInt(st.nextToken());
    			push(val);
    			break;
    		
    		case "pop":
    			sb.append(pop()).append("\n");
    			break;
    			
    		case "size":
    			sb.append(size()).append("\n");
    			break;
    			
    		case "empty":
    			sb.append(empty()).append("\n");
    			break;
    			
    		case "top":
    			sb.append(top()).append("\n");
    			break;
    		}
    			
    	}
    	System.out.print(sb);
    	
    }
    
    public static void push(int x) {
    	stack.add(x);
    }
    
    public static int pop() {
    	if (!stack.isEmpty()) {
    		return stack.pop();
    	}
    	return -1;
    }
    
    public static int size() {
    	return stack.size();
    }
    
    public static int empty() {
    	if (stack.isEmpty()) return 1;
    	else return 0;
    }
    
    public static int top() {
    	if (!stack.isEmpty()) {
    		return stack.peek();
    	}
    	return -1;
    }
}
