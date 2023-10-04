package aula02;

public class Introdução {

	public static void main(String[] args) {
		
		// Identificadores (letra, '_', 's')
		// Palavras reservadas (int, double, char)

		//String nome = "Lívia";
		int numeroInteiro = 1; //inteiro
		double numDecimal= 99.98; //números decimais
		float valorPi= 3.14f;
		char unicaLetra = 'L';
		boolean vOuF = true; //ou false
		
		// Declaração
		String nome;
		
		// Inicialização
		String nome1 = "Lívia";
		
		// Atribuição
		nome = "Lívia";
		System.out.println("Nome : " + nome);
		
		//Reatribuição
		nome = "Luan";
		System.out.println("Nome : " + nome);
		
		// Operadores
		
		numeroInteiro = 1;
		int num2 = 2;
		
		System.out.println(numeroInteiro + num2); // soma
		System.out.println(numeroInteiro - num2); // subtração
		System.out.println(numeroInteiro * num2); // multiplicação
		System.out.println(numeroInteiro / num2); // divisão
		System.out.println(numeroInteiro % num2); // resto da divisão
		
		// Operadores Relacionais
		
		int a = 1; 
		int b = 2;
		
		System.out.println(a == b); // Igual - false
		System.out.println(a != b); // Diferente - true
		System.out.println(a < b); // A menor ou igual ao B - true
		System.out.println(a > b); // A maior ou igual ao B - false
		
		// Operadores Lógicos
		
		boolean x = true;
		boolean y = false;
		
		System.out.println(x && y); // E - false
		System.out.println(x || y); // OU - true
		System.out.println(!x); // Negação - false
		
		int numeroX = 10;
		
		// Incremento		
		numeroX++; // 11
		numeroX = numeroX + 1; // 12
		
		// Decremento		
		numeroX--; // 11
		numeroX = numeroX - 1; // 10
		
		// Operadores de atribuição
		
		numeroX += 5; // 15 // numeroX = numeroX + 5
		numeroX -=10; // 5 // numeroX = numeroX - 10;
		numeroX *= 2; // 10 // numeroX = numeroX * 2;
		numeroX /= 2; // 5 // numeroX = numeroX / 2;
		
		// Vetores
		
		int[] number = new int[5]; // 0,1,2,3,4 (sempre começa com 0)
     	// criando uma variável chamada number de 5 posições vazias
		int[] inicializaVetor = {1,2,3,4,5};
		
		// Acessar
		int primeiroNumero = inicializaVetor[0]; // 1
		// inicializaVetor[0]; 1
		// inicializaVetor[1]; 2
		// inicializaVetor[2]; 3
		// inicializaVetor[3]; 4
		// inicializaVetor[4]; 5
										
		// Modificar
		inicializaVetor[3] = 10; // {1,2,3,10,5}
		
		
		
		// Matriz
		
		int[][] matriz = new int[3][3];
		// [ , , ]
		// [ , , ]
		// [ , , ]
		
		int[][] inicializaMatrizFor = {
				{1,2,3},
				{4,5,6},
				{7,8,9}	
		};
		
		for (int i=0; i < inicializaMatrizFor.length; i++) {
			for (int j=0; j < inicializaMatrizFor[i].length; j++) {
					System.out.println(inicializaMatrizFor[i][j]);
					//inicializaMatrizFor[0][0]
					//inicializaMatrizFor[0][1]
					//inicializaMatrizFor[0][2]
					//inicializaMatrizFor[1][0]
					//inicializaMatrizFor[1][1]
					//inicializaMatrizFor[1][2]
					//inicializaMatrizFor[2][0]
					//inicializaMatrizFor[2][1]
					//inicializaMatrizFor[2][2]
					
				}

			}
		
		// Acessar
		
		int value = inicializaMatrizFor[1][2]; // 6
		inicializaMatrizFor[0][0] = 10; // {10,2,3},{4,5,6},{7,8,9}
		
		
		int[] inicializaVetorFor = {10,20,30,40,50}; 
	
		for (int i=0; i < 5; i++) {
			// i = 0 vetor = 5
			System.out.println(inicializaVetorFor[i]); // 1,2,3,4,5
			// i = 5
		}
		
		int i = 0;
		while (i < inicializaVetorFor.length) {
			System.out.println(inicializaVetor[i]);
			i++;
		}
		
		// Condicionais
		
		// If - Else
		
		int idade = 18;
		
		if (idade >= 18) {
			System.out.println("Você é um adulto.");
		} else {
			System.out.println("Você não é um adulto.");
		}
		
		// Switch - Case
		
		char nota = 'A';
		
		switch (nota) {
			case 'A':
				System.out.println("Você passou com a nota máxima :] ");
			break;
			case 'B':
				System.out.println("Você passou.");
			break;
			default: 
				System.out.println("Você reprovou :c");
		}
		
		int resultado = soma(7,8);
		System.out.println(resultado);
		
		System.out.println(soma(5, 3));
		System.out.println(soma(15, 23));
		System.out.println(soma(35, 34));
	}

	public static int soma(int n1, int n2) {
		return n1 + n2;
	}
}
