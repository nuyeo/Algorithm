import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            String[] cards = new String[N];
            for (int i=0; i<N; i++) {
                cards[i] = st.nextToken();
            }
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
 
            int mid = (N + 1) / 2;
             
            for (int j=0; j<mid; j++) {
                sb.append(cards[j]).append(" ");
                 
                if (mid + j < N) {
                    sb.append(cards[mid + j]).append(" ");
                }
            }
            
            System.out.println(sb.toString().trim());
             
        }
    }
}