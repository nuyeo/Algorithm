import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static final int[] dx = {0, 0, 1, 0, -1};
    static final int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] moveA = new int[M + 1];
            int[] moveB = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveB[i] = Integer.parseInt(st.nextToken());

            int[][] bc = new int[N][4]; // x, y, c, p
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                bc[n][0] = Integer.parseInt(st.nextToken()) - 1;
                bc[n][1] = Integer.parseInt(st.nextToken()) - 1;
                bc[n][2] = Integer.parseInt(st.nextToken());
                bc[n][3] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(solve(M, N, moveA, moveB, bc)).append("\n");
        }
        System.out.print(sb);
    }

    static int solve(int M, int N, int[] moveA, int[] moveB, int[][] bc) {
        int total = 0;
        int ax = 0, ay = 0, bx = 9, by = 9;

        for (int time = 0; time <= M; time++) {
            ax += dx[moveA[time]];
            ay += dy[moveA[time]];
            bx += dx[moveB[time]];
            by += dy[moveB[time]];

            // 접근 가능한 BC 필터링
            List<int[]> accA = new ArrayList<>(); // {index, power}
            List<int[]> accB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (dist(ax, ay, bc[i]) <= bc[i][2]) accA.add(new int[]{i, bc[i][3]});
                if (dist(bx, by, bc[i]) <= bc[i][2]) accB.add(new int[]{i, bc[i][3]});
            }

            // 아무 BC에도 못 닿는 경우 처리
            if (accA.isEmpty() && accB.isEmpty()) continue;
            if (accA.isEmpty()) { total += maxPower(accB); continue; }
            if (accB.isEmpty()) { total += maxPower(accA); continue; }

            // 접근 가능한 BC 조합만 탐색
            int best = 0;
            for (int[] a : accA) {
                for (int[] b : accB) {
                    int sum = (a[0] == b[0]) ? Math.max(a[1], b[1]) : a[1] + b[1];
                    best = Math.max(best, sum);
                }
            }
            total += best;
        }
        return total;
    }

    static int dist(int x, int y, int[] bc) {
        return Math.abs(bc[0] - x) + Math.abs(bc[1] - y);
    }

    static int maxPower(List<int[]> acc) {
        int max = 0;
        for (int[] a : acc) max = Math.max(max, a[1]);
        return max;
    }
}
