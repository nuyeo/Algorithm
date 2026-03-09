import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            String str = br.readLine();

            int lastDigit = str.charAt(str.length() - 1) - '0';
            if (lastDigit%2 == 0) {
                sb.append("S").append("\n");
            } else {
                sb.append("H").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
