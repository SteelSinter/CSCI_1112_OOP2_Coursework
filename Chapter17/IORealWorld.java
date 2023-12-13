import java.io.*;
public class IORealWorld {

	public static void main(String[] args) {
		if (appendToFile()) {
			System.out.println("Sum")
			sumOfFile();
		}

	}
	
	public static boolean appendToFile() {
		try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("Exercise17_03.dat")))
		) {
			for (int i = 0; i < 100; i++) {
				output.writeInt((int)(Math.random() * 10));
				output.writeUTF(" ");
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
				System.out.println(v);
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
