import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("Je s'appelle Groot.");
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
	
		while (!line.equals("quit"))
		{
			System.out.println("Unknown command");	
			line = scanner.nextLine();
		}
		System.exit(0);
	}
	
}
