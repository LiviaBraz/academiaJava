package aula06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.swing.JOptionPane;

public class Sistema {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();

		JOptionPane.showMessageDialog(null,
				"     📚📚📚📚📚📚📚📚📚📚📚📚📚📚    " + "\n Bem vindx a Biblioteca da Lívia!\n"
						+ "     📚📚📚📚📚📚📚📚📚📚📚📚📚📚  " + "\n\n    Sua leitura nossa alegria :]");

		while (true) {

			String[] opcoes = { "Livro", 
					"Revista", 
					"Sair" };

			String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o que você procura:",
					"Sistema de Biblioteca", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			if (escolha.equals("Sair")) {
				JOptionPane.showMessageDialog(null, "Obrigada por nos escolher. Volte sempre :)");
				break;
			}
			switch (escolha) {

			case "Livro":

				String[] opcoesLivro = { "Adicionar um livro", 
						"Remover um livro", 
						"Buscar por título", 
						"Listar livros",
						"Listar livros emprestados", 
						"Pegar um livro emprestado", 
						"Devolver um livro",
						"Imprimir um livro", 
						"Voltar" };

				String escolhaLivro = (String) JOptionPane.showInputDialog(null, "Como posso te ajudar hoje?",
						"Sistema de Biblioteca", JOptionPane.PLAIN_MESSAGE, null, opcoesLivro, opcoesLivro[0]);

				switch (escolhaLivro) {

				case "Adicionar um livro":
					String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
					String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
					String isbn = JOptionPane.showInputDialog("Digite o ISBN do livro:");
					Livro novoLivro = new Livro(titulo, autor, isbn);
					biblioteca.adicionarLivro(novoLivro);
					JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso.");
					break;

				case "Remover um livro":
					String isbnRemover = JOptionPane.showInputDialog("Digite o ISBN do livro a ser removido:");
					biblioteca.removerLivro(isbnRemover);
					JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");
					break;

				case "Buscar por título":
					String termoBusca = JOptionPane.showInputDialog("Digite o título ou parte do título:");
					List<Livro> livrosEncontrados = biblioteca.buscarLivro(termoBusca);
					StringBuilder buscaLivro = new StringBuilder("Livros encontrados:\n");
					for (Livro livro : livrosEncontrados) {
						buscaLivro.append(livro.exibirInfo()).append("\n\n");
					}
					JOptionPane.showMessageDialog(null, buscaLivro.toString());
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
						JOptionPane.showMessageDialog(null, "Não foi possível pegar o livro.", "",
								JOptionPane.ERROR_MESSAGE);
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
						String dataDevolucaoStr = JOptionPane
								.showInputDialog("Insira o dia da devolução (dd-MM-yyyy):");
						LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr,
								DateTimeFormatter.ofPattern("dd-MM-yyyy"));
						LocalDate dataEntrada = LocalDate.now();
						;
						LocalDate dataPrevista = ChronoUnit.DAYS.addTo(dataEntrada, 10);

						if (dataDevolucao.isBefore(dataPrevista) || dataEntrada.equals(dataPrevista)) {
							biblioteca.devolverLivro(isbnDevolver);
							JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso.");
						} else if (dataDevolucao.isAfter(dataPrevista)) {
							biblioteca.devolverLivro(isbnDevolver);
							JOptionPane.showMessageDialog(null, "Livro devolvido com atraso.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Este livro não foi emprestado ou não existe.", "",
								JOptionPane.ERROR_MESSAGE);
					}
					break;

				case "Imprimir um livro":

					String tituloLivroImprimir = JOptionPane
							.showInputDialog("Digite o título do livro a ser impresso:");

					Livro livroParaImprimir = null;
					for (Livro livro : biblioteca.listarLivros()) {
						if (livro.getTitulo().equals(tituloLivroImprimir)) {
							livroParaImprimir = livro;
							break;
						}
					}
					if (livroParaImprimir != null) {
						livroParaImprimir.imprimir();
					} else {
						JOptionPane.showMessageDialog(null, "Este livro não está em nossa biblioteca.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
					break;

				}
				break;
				
			case "Revista":

				String[] opcoesRevista = { "Adicionar uma revista", 
						"Remover uma revista", 
						"Buscar por título",
						"Listar revistas", 
						"Listar revistas emprestadas", 
						"Pegar uma revista emprestada",
						"Devolver uma revista",
						"Imprimir uma revista",
						"Voltar" };

				String escolhaRevista = (String) JOptionPane.showInputDialog(null, "Como posso te ajudar hoje?",
						"Sistema de Biblioteca", JOptionPane.PLAIN_MESSAGE, null, opcoesRevista, opcoesRevista[0]);

				switch (escolhaRevista) {

				case "Adicionar uma revista":
					String tituloRevista = JOptionPane.showInputDialog("Digite o título da revista:");
					String empresa = JOptionPane.showInputDialog("Digite a empresa da revista:");
					int edicao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da edição da revista:"));
					int nroCopias = 1;
					Revista novaRevista = new Revista(tituloRevista, empresa, edicao, nroCopias);
					biblioteca.adicionarRevista(novaRevista);
					JOptionPane.showMessageDialog(null, "Revista adicionada com sucesso.");
					break;

				case "Remover uma revista":
					String isbnRemover = JOptionPane.showInputDialog("Digite o ISBN do livro a ser removido:");
					biblioteca.removerLivro(isbnRemover);
					JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");
					break;

				case "Buscar por título":
					String termoBusca = JOptionPane.showInputDialog("Digite o título ou parte do título:");
					List<Revista> revistasEncontradas = biblioteca.buscarRevista(termoBusca);

					StringBuilder buscaRevista = new StringBuilder("\n\nRevistas encontradas:\n");
					for (Revista revista : revistasEncontradas) {
						buscaRevista.append(revista.exibirInfo()).append("\n\n");
					}
					JOptionPane.showMessageDialog(null, buscaRevista.toString());
					break;

				case "Listar revistas":
					List<Revista> todasRevistas = biblioteca.listarRevistas();
					StringBuilder listaRevistas = new StringBuilder("Lista de Revistas:\n");
					for (Revista revista : todasRevistas) {
						listaRevistas.append(revista.exibirInfo()).append("\n\n");
					}
					JOptionPane.showMessageDialog(null, listaRevistas.toString());
					break;

				case "Listar revistas emprestadas":
					List<Revista> revistasEmprestadas = biblioteca.listarRevistasEmprestadas();
					StringBuilder listaEmprestadas = new StringBuilder("Revistas Emprestadas:\n");
					for (Revista revista : revistasEmprestadas) {
						listaEmprestadas.append(revista.exibirInfo()).append("\n\n");
					}
					JOptionPane.showMessageDialog(null, listaEmprestadas.toString());
					break;

				case "Pegar uma revista emprestada":
					String tituloEmprestar = JOptionPane.showInputDialog("Digite o título da revista a ser emprestada:");
					boolean emprestado = biblioteca.emprestarRevista(tituloEmprestar);
					if (emprestado) {
						JOptionPane.showMessageDialog(null, "Revista emprestata com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível pegar a revista.", "",
								JOptionPane.ERROR_MESSAGE);
					}
					break;

				case "Devolver uma revista":
					String tituloDevolver = JOptionPane.showInputDialog("Digite o titulo da revista a ser devolvida:");

					Revista revistaParaDevolver = null;
					for (Revista revista : biblioteca.listarRevistas()) {
						if (revista.getTitulo().equals(tituloDevolver)) {
							revistaParaDevolver = revista;
							break;
						}
					}

					if (revistaParaDevolver != null && revistaParaDevolver.isEmprestado()) {
						String dataDevolucaoStr = JOptionPane
								.showInputDialog("Insira o dia da devolução (dd-MM-yyyy):");
						LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr,
								DateTimeFormatter.ofPattern("dd-MM-yyyy"));
						LocalDate dataEntrada = LocalDate.now();
						;
						LocalDate dataPrevista = ChronoUnit.DAYS.addTo(dataEntrada, 10);

						if (dataDevolucao.isBefore(dataPrevista) || dataEntrada.equals(dataPrevista)) {
							biblioteca.devolverRevista(tituloDevolver);
							JOptionPane.showMessageDialog(null, "Revista devolvida com sucesso.");
						} else if (dataDevolucao.isAfter(dataPrevista)) {
							biblioteca.devolverRevista(tituloDevolver);
							JOptionPane.showMessageDialog(null, "Revista devolvida com atraso.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Esta revista não foi emprestada ou não existe.", "",
								JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case "Imprimir uma revista":

					String tituloRevistaImprimir = JOptionPane.showInputDialog("Digite o título da revista a ser impressa:");

					Revista revistaParaImprimir = null;
					for (Revista revista : biblioteca.listarRevistas()) {
						if (revista.getTitulo().equals(tituloRevistaImprimir)) {
							revistaParaImprimir = revista;
							break;
						}
					}
					if (revistaParaImprimir != null) {
						revistaParaImprimir.imprimir();
					} else {
						JOptionPane.showMessageDialog(null, "Esta revista não está em nossa biblioteca.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
					break;

				}

			}

		}

	}

}