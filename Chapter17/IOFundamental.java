import java.io.*;
public class IOFundamental {

	public static void main(String[] args) throws IOException {
		File file = new File("Exercise17_01.txt");
		if (file.createNewFile()) {
			System.out.println("File created.");
		}
		else {
			try (PrintWriter output = new PrintWriter(file)) {
				for (int i = 0; i < 100; i++) {
					output.append(new String((String.valueOf((int)(Math.random() * 10)))));
				}
				output.append(" ");
				System.out.println("Numbers appended.");
			}
			catch (IOException ex) {
				System.out.println(ex.toString());
			}
		}
	}

}
