import java.io.*;
import java.util.*;
 
public class Solution {
     
    static int n, m;
    static int maxHomeCnt;
    static LinkedList<int[]> homes;
    static final int maxK = 22; // n이 최대일 때 가능한 k의 최댓값
    static int[] costs = new int[maxK];
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        calcCosts();
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 도시 크기
            m = Integer.parseInt(st.nextToken()); // 지불 비용
            maxHomeCnt = 0;
            homes = new LinkedList<>();
             
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(st.nextToken()); // 1: 집, 0: 나머지
                    if (val == 1) homes.add(new int[] {i, j});
                }
            }
             
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 1; k <= n+1; k++) {
                        int cnt = 0;
                        for (int[] home : homes) {
                            if ((Math.abs(home[0] - i) + Math.abs(home[1] - j)) < k) cnt++;
                        }
                         
                        if (cnt * m >= costs[k]) {
                            maxHomeCnt = Math.max(cnt, maxHomeCnt);
                        }
                    }
                }
            }
             
            sb.append("#").append(t).append(" ").append(maxHomeCnt).append("\n");
             
        }
         
        System.out.println(sb);
    }
     
    static void calcCosts() {
         
        for (int i = 1; i < maxK; i++) {
            costs[i] = i * i + (i - 1) * (i - 1);
        }
    }
     
 
}
