
public class Test {

	public static void main(String[] args) {
		//System.out.println(f1(3));
		//System.out.println(f2(3, 0));
		//System.out.println(xfunction(6));
		//System.out.println(m(5));
		//System.out.println(fib(5));
		//moveDisks(4, 'A', 'B', 'C');
		//int[] x = {1, 2, 3, 4, 5};
		//yMethod(x, 5);
		
		System.out.println(zMethod(4));

	}
	
	public static int f1(int n) {
		if (n == 0)
			return 0;
		else {
			return n + f1(n-1);
		}
	}
	
	public static int f2(int n, int result) {
		if (n == 0)
			return result;
		else
			return f2(n - 1, n + result);
	}
	
	public static int xfunction(int n) {
		if (n <= 1)
			return 1;
		else
			return n + xfunction(n - 2);
	}
	
	public static int m(int value) {
		if (value >= 0)
			return 5 * m(value - 2);
		else
			return 1;
	}
	
	public static long fib(long index) {
		System.out.println("fib");
		if (index == 0 )
			return 0;
		else if (index == 1)
			return 1;
		else
			return fib(index - 1) + fib(index - 2);
	}
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		System.out.println("moveDisks invoked");
		if (n == 1)
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
	
	public static void yMethod(int[] x, int length) {
		System.out.print(" " + x[length - 1]);
		yMethod(x, length - 1);
	}
	
	public static int zMethod(int n) {
		if (n == 1)
			return 1;
		else
			return n + zMethod(n - 1);
	}

}
