package aula02;

public class Exercicio3 {

	public static void main(String[] args) {
		
		int number = 5;
		System.out.println("The factorial of " + number + " is: ");
		System.out.println(factorial(number));
		
	}
	
	public static int factorial(int value) {
		
		if (value == 0 || value == 1)
            return 1;
 
        return value * factorial(value - 1);
    }
		
}

