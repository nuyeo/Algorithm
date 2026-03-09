import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 2^N을 계산하여 한 변의 길이를 구함
        int size = (int) Math.pow(2, N);
        solve(size, R, C);
        
        System.out.println(ans);
    }

    static void solve(int size, int r, int c) {
        // Base Case: 더 이상 쪼갤 수 없는 1x1 크기일 때
        if (size == 1) {
            return;
        }

        int half = size / 2; // 사분면의 한 변 길이
        int area = half * half; // 한 사분면의 넓이 (건너뛸 크기)

        if (r < half && c < half) {
            // [1사분면] 왼쪽 위
            solve(half, r, c);
        } else if (r < half && c >= half) {
            // [2사분면] 오른쪽 위
            ans += area;
            solve(half, r, c - half);
        } else if (r >= half && c < half) {
            // [3사분면] 왼쪽 아래
            ans += 2 * area;
            solve(half, r - half, c);
        } else {
            // [4사분면] 오른쪽 아래
            ans += 3 * area;
            solve(half, r - half, c - half);
        }
    }
}
