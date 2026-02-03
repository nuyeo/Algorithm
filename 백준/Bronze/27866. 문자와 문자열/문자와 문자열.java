import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int i = sc.nextInt();
		System.out.print(s.charAt(i-1));
		
		sc.close();
	}
}
