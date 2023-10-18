package aula06;

import java.util.*;

public class Biblioteca {

	private List<Livro> catalogoLivros;
	private List<Revista> catalogoRevistas;

	public Biblioteca() {
		catalogoLivros = new ArrayList<>();
		catalogoRevistas = new ArrayList<>();
	}

	public void adicionarLivro(Livro livro) {
		catalogoLivros.add(livro);
	}

	public void adicionarRevista(Revista revista) {
		catalogoRevistas.add(revista);
	}

	public void removerLivro(String isbn) {
		catalogoLivros.removeIf(livro -> livro.getIsbn().equals(isbn));
	}

	public List<Livro> buscarLivro(String titulo) {

		List<Livro> livrosEncontrados = new ArrayList<>();

		for (Livro livro : catalogoLivros) {
			if (livro.exibirInfo().toLowerCase().contains(titulo.toLowerCase())) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;

	}

	public List<Revista> buscarRevista(String titulo) {

		List<Revista> revistasEncontradas = new ArrayList<>();

		for (Revista revista : catalogoRevistas) {
			if (revista.exibirInfo().toLowerCase().contains(titulo.toLowerCase())) {
				revistasEncontradas.add(revista);
			}
		}
		return revistasEncontradas;
	}

	public boolean emprestarLivro(String isbn) {
		for (Livro livro : catalogoLivros) {
			if (livro.getIsbn().equals(isbn)) {
				if (!livro.reservar()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean emprestarRevista(String titulo) {
		for (Revista revista : catalogoRevistas) {
			if (revista.getTitulo().equals(titulo)) {
				if (!revista.reservar()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	public void devolverLivro(String isbn) {
		for (Livro livro : catalogoLivros) {
			if (livro.getIsbn().equals(isbn)) {
				livro.devolver();
				break;
			} 
		}
	}
	
	public void devolverRevista(String titulo) {
		for (Revista revista : catalogoRevistas) {
			if (revista.getTitulo().equals(titulo)) {
				revista.devolver();
				break;
			}
		}
	}

	public List<Livro> listarLivros() {
		return catalogoLivros;
	}

	public List<Revista> listarRevistas() {
		return catalogoRevistas;
	}

	public List<Livro> listarLivrosEmprestados() {
		List<Livro> livrosEmprestados = new ArrayList<>();
		for (Livro livro : catalogoLivros) {
			if (livro.isEmprestado()) {
				livrosEmprestados.add(livro);
			}
		}
		return livrosEmprestados;
	}
	
	public List<Revista> listarRevistasEmprestadas() {
		List<Revista> revistasEmprestadas = new ArrayList<>();
		for (Revista revista : catalogoRevistas) {
			if (revista.isEmprestado()) {
				revistasEmprestadas.add(revista);
			}
		}
		return revistasEmprestadas;
	}
}