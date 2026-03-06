import java.util.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int n;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] normalMap = new char[n][n];
        char[][] weakMap = new char[n][n];
        for (int i = 0; i < n; i++) {
          String s = br.readLine();
          for (int j = 0; j < n; j++) {
            normalMap[i][j] = s.charAt(j); // R(빨강), G(초록), B(파랑)
            weakMap[i][j] = s.charAt(j) == 'G' ? 'R' : s.charAt(j); // 적록색약은 R == G
          }
        }

        // 일반 구역 체크
        visited = new boolean[n][n];
        int normalCnt = 0;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
              visited[i][j] = true;
              normalCnt++;
              bfs(i, j, normalMap);
            }
          }
        }

        // 적록색약 구역 체크
        visited = new boolean[n][n];
        int weakCnt = 0;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (!visited[i][j]) {
              visited[i][j] = true;
              weakCnt++;
              bfs(i, j, weakMap);
            }
          }
        }

        System.out.println(normalCnt + " " + weakCnt);
    }

    static void bfs (int r, int c, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        while (!q.isEmpty()) {
          int[] cur = q.poll();
          for (int i = 0; i < 4; i++) {
            int nr = cur[0] + dr[i];
            int nc = cur[1] + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
              if (!visited[nr][nc] && map[nr][nc] == map[r][c]) {
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
              }
            }
          }
        }
    }
}
