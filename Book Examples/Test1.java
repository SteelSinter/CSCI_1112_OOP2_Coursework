
public class Test1 {

	public static void main(String[] args) {
		xMethod(5);

	}
	
	public static void xMethod(int length) {
		if (length > 1) {
			System.out.print((length - 1) + " ");
			xMethod(length - 1);
		}
	}

}
