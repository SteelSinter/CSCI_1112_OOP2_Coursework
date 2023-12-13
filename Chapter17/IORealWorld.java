import java.io.*;
public class IORealWorld {

	public static void main(String[] args) {
		if (appendToFile()) {
			System.out.println("Sum of file: " + sumOfFile());
		}

	}
	
	public static boolean appendToFile() {
		try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("Exercise17_03.dat")))
		) {
			for (int i = 0; i < 100; i++) {
				int rand = (int)(Math.random() * 10);
				output.writeInt(rand);
			}
			return true;
		}
		catch (FileNotFoundException ex) {
			new File("Exercise17_03.dat");
			System.out.println("File created.");
			return false;
		}
		catch (IOException ex) {return false;}
	}
	
	public static int sumOfFile() {
		int sum = 0;
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(
				new FileInputStream("Exercise17_03.dat")))
		) {
			int v;
			while ((v = input.read()) != -1) {
				sum += v;
			}
			return sum;
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
			return -1;
		}
		catch (IOException ex) {
			System.out.println(ex.toString());
			return -1;
		}
	}

}
