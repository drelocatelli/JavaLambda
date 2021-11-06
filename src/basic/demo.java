package basic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class demo {

	public static void main(String[] args) {
		
		String[] words = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
		
		System.out.printf("original Strings: %s \n", Arrays.asList(words));
		
		System.out.printf("strings in uppercase: %s \n",
				Arrays.stream(words)
					.map(String::toUpperCase)
					.collect(Collectors.toList())
				);
		
		System.out.printf("strings greater than m sorted ascending: %s \n", 
				Arrays.stream(words)
					.filter(s -> s.compareToIgnoreCase("n") < 0)
					.sorted(String.CASE_INSENSITIVE_ORDER)
					.collect(Collectors.toList())
				);
		
		System.out.printf("strings greater than m sorted descending: %s \n ",
					Arrays.stream(words)
						.filter(s -> s.compareToIgnoreCase("n") < 0)
						.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
						.collect(Collectors.toList())
				);
		
	}
	
}
