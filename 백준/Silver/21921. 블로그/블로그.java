import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int maxSum;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        countMaxVisitors(N, X, visitors);

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }

    static void countMaxVisitors(int N, int X, int[] visitors) {
        int window = 0;
        for (int i = 0; i < X; i++) {
            window += visitors[i];
        }

        maxSum = window;
        cnt = 1;

        for (int i = X; i < N; i++) {
            window = window - visitors[i - X] + visitors[i];

            if (window > maxSum) {
                maxSum = window;
                cnt = 1;
            } else if (window == maxSum) {
                cnt++;
            }
        }
    }
}
