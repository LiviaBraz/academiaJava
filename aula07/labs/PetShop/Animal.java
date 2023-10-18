package aula07;

import java.time.LocalDate;
import java.util.ArrayList;


public class Animal {

	private String nome;
	private String especie;
	private String raca;
	private LocalDate dataNascimento;
	private String proprietario;
	
	private static ArrayList<Animal> animais = new ArrayList<>();
	
	public Animal(String nome, String especie, String raca, LocalDate dataNascimento, String proprietario) {
		
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.proprietario = proprietario;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public static void cadastrarAnimal(Animal animal) {	
		animais.add(animal);
	}

}
	

