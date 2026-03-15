import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 1000001;
        int max = -1000001;

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if (val > max) max = val;
            if (val < min) min = val;
        }

        System.out.println(min + " " + max);
    }
}
