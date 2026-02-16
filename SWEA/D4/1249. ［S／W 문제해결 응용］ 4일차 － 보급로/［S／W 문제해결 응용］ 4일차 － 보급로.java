import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] matrix;
    static int[][] dist; // 최소 비용 저장
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = str.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE; // 큰 값으로 초기화
                }
            }

            int result = solve();
            System.out.println("#" + t + " " + result);
        }
    }

    static int solve() {
        // time 기준으로 오름차순 정렬하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // 시작점: x, y, current_time
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];

            // 이미 더 적은 비용으로 방문한 적이 있다면 패스 (가지치기)
            if (time > dist[x][y]) continue;

            // 목적지 도착하면 현재 time 반환
            if (x == N - 1 && y == N - 1) return time;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    // 다음 칸으로 이동했을 때의 누적 비용
                    int nextTime = time + matrix[nx][ny];
                    
                    // 기존에 알고 있던 비용보다 새로 찾은 경로가 더 저렴하다면 갱신
                    if (nextTime < dist[nx][ny]) {
                        dist[nx][ny] = nextTime;
                        pq.offer(new int[]{nx, ny, nextTime});
                    }
                }
            }
        }
        return -1;
    }
}
