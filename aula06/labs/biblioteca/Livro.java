package aula06;

import javax.swing.JOptionPane;

public class Livro implements Imprimivel {

	private String titulo;
	private String autor;
	private String isbn;
	private boolean emprestado;

	public Livro(String titulo, String autor, String isbn) {

		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.emprestado = false;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public boolean reservar() {
		if (!emprestado) {
			emprestado = true;
			return true;
		} else {
			return false;
		}
	}

	public void devolver() {
		emprestado = false;
	}

	public String exibirInfo() {

		String informacoes = ("Título: " + titulo + "\nAutor: " + autor + "\nISBN: " + isbn + "\nEmprestado: "
				+ (emprestado ? "Sim" : "Não"));
		return informacoes;

	}

	@Override
    public void imprimir() {
		
		if (isEmprestado()) {
	        JOptionPane.showMessageDialog(null, "O livro " + getTitulo() + " está emprestado e não pode ser impresso.", "Erro", JOptionPane.ERROR_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "Impressão do livro " + getTitulo() + " realizada com sucesso.");
	    }
    }
}