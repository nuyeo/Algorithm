import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if (year%400==0) {
			System.out.print(1);
			return;
		} else if (year%4==0 && year%100!=0) {
			System.out.print(1);
			return;
		}
		System.out.print(0);

	}
}
