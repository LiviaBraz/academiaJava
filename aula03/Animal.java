package aula03;



public class Animal {
	    
		private String especie;
	    private String raca;
	    private String nome;

	public static void main(String[] args) {
			
			Animal animal = new Animal ("Cachorro", "Pastor Alemão", "Frida");
		
			System.out.println(animal.especie);
			System.out.println(animal.raca);
			System.out.println(animal.nome);
			
	}    
	    
	public Animal(String especie, String raca, String nome) {
	    // inicializa variáveis de instância
	    this.especie = especie;
	    this.raca = raca;
	    this.nome = nome;
	}
	
}
