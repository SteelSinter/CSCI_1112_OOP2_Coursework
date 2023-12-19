import java.util.Scanner;

public class RecursionFundamental {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 2 integers to get the greatest common factor:");
			System.out.println(gcd(input.nextInt(), input.nextInt()));
		}

	}
	
	public static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		return gcd(n, m % n);
	}

}
