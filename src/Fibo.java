import java.util.Scanner;

public class Fibo implements Command {

	@Override
	public String name() {
		return "fibo";
	}

	@Override
	public boolean run(Scanner scanner) {
		
		String line = scanner.nextLine();
		try {
			int x = Integer.parseInt(line);
			System.out.println("Fib(" + x + ") = " + fibo(x));
		}
		catch (NumberFormatException e) {
			System.err.println("You must enter a number.");
		}
		return false;
	}
	
	private long fibo(long n)
	{
		long x = 0;
		long y = 1;
		boolean xt = true;
		
		for (long i = 2; i < n; ++i) {
			if (xt)
				x += y;
			else
				y += x;
			xt = !xt;
		}
		
		return x + y;
	}
}
