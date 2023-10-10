package aula06;

import java.util.*;

public class Biblioteca {

	private List<Livro> catalogo;
	
	public Biblioteca() {
		catalogo = new ArrayList<>();
	}
	
	public void adicionarLivro(Livro livro) {	
		catalogo.add(livro);
	}
	
	public void removerLivro(String isbn) {	
		catalogo.removeIf(livro -> livro.getIsbn().equals(isbn));
	}
	
	public List<Livro> buscarPorTitulo(String titulo) {	
		
		List<Livro> livrosEncontrados = new ArrayList<>();
		
		for(Livro livro : catalogo) {
			if(livro.exibirInfo().toLowerCase().contains(titulo.toLowerCase())) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
		
	}
	
	public boolean emprestarLivro (String isbn) {	
		for(Livro livro : catalogo) {
			if(livro.getIsbn().equals(isbn)) {
				if (!livro.reservar()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public void devolverLivro (String isbn) {	
		for(Livro livro : catalogo) {
			if(livro.getIsbn().equals(isbn)) {
				livro.devolver();
				break;
			}
		}
	}
	
	public List<Livro> listarLivros(){
		return catalogo;
	}
	
	public List<Livro> listarLivrosEmprestados(){
		List<Livro> livrosEmprestados = new ArrayList<>();
		for(Livro livro : catalogo) {
			if(livro.isEmprestado()) {
				livrosEmprestados.add(livro);
			}
		}
		return livrosEmprestados;
	}
}