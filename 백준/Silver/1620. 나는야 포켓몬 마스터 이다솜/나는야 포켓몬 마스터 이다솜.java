import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> nameToIdx = new HashMap<>();
        String[] idxToName = new String[n + 1];
        
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameToIdx.put(name, i);
            idxToName[i] = name;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            String s = br.readLine();
            
            if (isNumeric(s)) {
                int index = Integer.parseInt(s);
                sb.append(idxToName[index]).append("\n");
            } else {
                sb.append(nameToIdx.get(s)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    static boolean isNumeric(String str) {
        char c = str.charAt(0);
        return c >= '0' && c <= '9';
    }
}
