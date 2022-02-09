import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Launcher {
	
	public static void main(String[] args) {
		
		System.out.println("Je s'appelle Groot.");
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
	
		while (!line.equals("quit"))
		{
			if (line.equals("fibo"))
			{
				line = scanner.nextLine();
				try {
					int x = Integer.parseInt(line);
					System.out.println("Fib(" + x + ") = " + fibo(x));
				}
				catch (NumberFormatException e) {
					System.err.println("You must enter a number.");
				}
			}
			
			else if (line.equals("freq"))
			{
				line = scanner.nextLine();
				try {
					Path path = Paths.get(line);
					String msg = Files.readString(path);
					System.out.println(msg);
					
				} catch (Exception e) {
					System.err.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());					
				}
			}
			
			else
				System.out.println("Unknown command");	
			line = scanner.nextLine();
		}
		System.exit(0);
	}
	
	private static int fibo(int n)
	{
		int x = 0;
		int y = 1;
		boolean xt = true;
		
		for (int i = 2; i < n; ++i) {
			if (xt)
				x += y;
			else
				y += x;
			xt = !xt;
		}
		
		return x + y;
	}
	
}
