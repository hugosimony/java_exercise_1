import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("Je s'appelle Groot.");
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
	
		if (line.equals("quit"))
			System.exit(0);
		
		System.out.println("Unknown command");
	}
	
}
