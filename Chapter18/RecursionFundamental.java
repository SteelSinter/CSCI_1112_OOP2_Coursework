
public class RecursionFundamental {

	public static void main(String[] args) {
		System.out.println(gcd(15, 6));

	}
	
	public static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		return gcd(n, m % n);
	}

}
