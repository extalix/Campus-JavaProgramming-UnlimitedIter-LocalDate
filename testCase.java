import java.time.LocalDate;

public class testCase {
	public static void main(String []args) {
		LocalDate target = LocalDate.of(2019, 07, 10);
		
		if (target.plusDays(1).equals(LocalDate.of(2019,07,11))) 
			System.out.println("YES");
		
		System.out.println(target.toString());
		
		System.out.println();
		target = target.plusDays(1);
		System.out.println(target.toString());
		
	}
	
}