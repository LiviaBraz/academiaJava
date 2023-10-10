package aula06;

import java.util.*;
import javax.swing.JOptionPane;

public class Sistema {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		
		while(true) {
			String[] opcoes = {
	                "Adicionar um livro",
	                "Remover um livro",
	                "Buscar por título",
	                "Listar livros",
	                "Listar livros emprestados",
	                "Pegar um livro emprestado",
	                "Devolver um livro",
	                "Sair"
	            };

	            String escolha = (String) JOptionPane.showInputDialog(
	                null,
	                "        Bem vindx a Biblioteca da Lívia!\n           Sua leitura nossa alegria :]\n\nComo posso te ajudar hoje?",
	                "Sistema de Biblioteca",
	                JOptionPane.PLAIN_MESSAGE,
	                null,
	                opcoes,
	                opcoes[0]
	            );

	            if (escolha == null || escolha.equals("Sair")) {
	            	JOptionPane.showMessageDialog(null, "Obrigada por nos escolher. Volte sempre :)");
	                break;
	            }

	            switch (escolha) {
	            
                	case "Adicionar um livro":
                    String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                    String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
                    String isbn = JOptionPane.showInputDialog("Digite o ISBN do livro:");
                    Livro novoLivro = new Livro(titulo, autor, isbn);
                    biblioteca.adicionarLivro(novoLivro);
                    break;
                    
                	case "Remover um livro":
                    String isbnRemover = JOptionPane.showInputDialog("Digite o ISBN do livro a ser removido:");
                    biblioteca.removerLivro(isbnRemover);
                    break;
                    
                	case "Buscar por título":
                    String termoBusca = JOptionPane.showInputDialog("Digite o título ou parte do título:");
                    List<Livro> livrosEncontrados = biblioteca.buscarPorTitulo(termoBusca);
                    StringBuilder resultadoBusca = new StringBuilder("Livros encontrados:\n");
                    for (Livro livro : livrosEncontrados) {
                        resultadoBusca.append(livro.exibirInfo()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, resultadoBusca.toString());
                    break;
                    
                	case "Listar livros":
                    List<Livro> todosLivros = biblioteca.listarLivros();
                    StringBuilder listaLivros = new StringBuilder("Lista de Livros:\n");
                    for (Livro livro : todosLivros) {
                        listaLivros.append(livro.exibirInfo()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, listaLivros.toString());
                    break;
                    
                	case "Listar livros emprestados":
                    List<Livro> livrosEmprestados = biblioteca.listarLivrosEmprestados();
                    StringBuilder listaEmprestados = new StringBuilder("Livros Emprestados:\n");
                    for (Livro livro : livrosEmprestados) {
                        listaEmprestados.append(livro.exibirInfo()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, listaEmprestados.toString());
                    break;
                    
                	case "Pegar um livro emprestado":
                    String isbnEmprestar = JOptionPane.showInputDialog("Digite o ISBN do livro a ser emprestado:");
                    boolean emprestado = biblioteca.emprestarLivro(isbnEmprestar);
                    if (emprestado) {
                        JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso.");
                    } else {
                    	JOptionPane.showMessageDialog(null, "Não foi possível pegar o livro.","", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                	case "Devolver um livro":
                	String isbnDevolver = JOptionPane.showInputDialog("Digite o ISBN do livro a ser devolvido:");
                	
                	Livro livroParaDevolver = null;
                	    for (Livro livro : biblioteca.listarLivros()) {
                	        if (livro.getIsbn().equals(isbnDevolver)) {
                	            livroParaDevolver = livro;
                	            break;
                	        }
                	    }
                	    
                	    if (livroParaDevolver != null && livroParaDevolver.isEmprestado()) {
                	        biblioteca.devolverLivro(isbnDevolver);
                	        JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso.");
                	    } else {
            	        JOptionPane.showMessageDialog(null, "Este livro não foi emprestado ou não existe.", "", JOptionPane.ERROR_MESSAGE);
                	    }
                    break;
	            }
	    }
	}
		
}

