import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static int[][] homes;
    static int homeCnt;
    static int[] costs = new int[41];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 운영 비용 미리 계산
        for (int k = 1; k <= 40; k++) {
            costs[k] = k * k + (k - 1) * (k - 1);
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            homes = new int[n * n][2];
            homeCnt = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        homes[homeCnt][0] = i;
                        homes[homeCnt][1] = j;
                        homeCnt++;
                    }
                }
            }

            int maxHomeResult = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 각 중심점마다 거리별 집의 개수 저장
                    int[] distCount = new int[41]; 
                    int furthestDist = 0;

                    // 1. 모든 집과의 거리를 한 번만 계산해서 카운팅
                    for (int h = 0; h < homeCnt; h++) {
                        int dist = Math.abs(homes[h][0] - i) + Math.abs(homes[h][1] - j);
                        // K가 dist + 1일 때 이 집이 포함됨
                        if (dist < 40) {
                            distCount[dist + 1]++;
                            furthestDist = Math.max(furthestDist, dist + 1);
                        }
                    }

                    // 2. 누적 합을 이용해 K를 늘려가며 확인
                    int currentHomeCnt = 0;
                    for (int k = 1; k <= n + 1; k++) {
                        currentHomeCnt += distCount[k];
                        
                        if (currentHomeCnt == 0) continue;

                        if (currentHomeCnt * m >= costs[k]) {
                            maxHomeResult = Math.max(maxHomeResult, currentHomeCnt);
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(maxHomeResult).append("\n");
        }
        System.out.print(sb);
    }
}
