package aula02;

public class Exercicio1 {

	public static void main(String[] args) {
		
		float values[] = {2,8,5,9,6};
		float soma = 0, media;
		
		for (int i=0; i < values.length; i++) {
			soma += values[i];
		}
		
		media = soma / values.length;  
		
		System.out.println("A média é: " + media);
	
	}

}
