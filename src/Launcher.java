import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
					freq(msg);
					
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
	
	private static void freq(String text)
	{
		String[] words = text
				.replaceAll("[^a-zA-Z ]", "")
				.toLowerCase()
				.split(" ");
		Stream<Entry<String, List<String>>> stream = Arrays
				.stream(words).filter((str) -> !str.isBlank())
				.collect(Collectors.groupingBy((str) -> str))
				.entrySet()
				.stream()
				.sorted(Comparator.comparingInt((elt) -> - elt.getValue().size()))
				.limit(3);
		stream.forEach((str) -> System.out.print(str.getKey() + " "));
		System.out.println();
	}
	
}
