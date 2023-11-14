package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		JOptionPane.showMessageDialog(null, " Bem-vindo ao nosso Banco de Talentos :] ");

		while (true) {

			String[] opcoes = { "Cadastrar", "Ver tudo", "Encontrar", "Atualizar", "Deletar", "Sair" };

			String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o que você deseja:",
					"Banco de Talentos - UFN", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			if (escolha.equals("Sair")) {
				JOptionPane.showMessageDialog(null, "Volte sempre! :)");
				System.out.println("Pronto!");
				em.close();
				emf.close();
				break;
			}

			switch (escolha) {

			case "Cadastrar":

				String nome = JOptionPane.showInputDialog("Digite seu nome:");
				String email = JOptionPane.showInputDialog("Digite seu email:");
				String telefone = JOptionPane.showInputDialog("Digite seu telefone:");
				String cargo = JOptionPane.showInputDialog("Digite o cargo desejado:");
				Pessoa novaPessoa = new Pessoa(null, nome, email, telefone, cargo);

				em.getTransaction().begin();
				em.persist(novaPessoa);
				em.getTransaction().commit();

				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				break;

			case "Ver tudo":
				listarPessoas(em);
				break;

			case "Encontrar":
				int termoBusca = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código da pessoa que deseja encontrar"
								+ "\n(Se não sabe o código, consulte-o nos dados do nosso banco)"));
				Pessoa p = em.find(Pessoa.class, termoBusca);

				JOptionPane.showMessageDialog(null, p);
				break;

			case "Atualizar":
				int idAtualizar = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código único da pessoa que deseja atualizar:"));
				Pessoa pessoaAtualizar = em.find(Pessoa.class, idAtualizar);

				if (pessoaAtualizar != null) {
					
					String[] atualizar = { "Nome", "Email", "Telefone", "Cargo Desejado" };

					String escolhaAt = (String) JOptionPane.showInputDialog(null, "O que você deseja atualizar?",
							"Atualizando...", JOptionPane.PLAIN_MESSAGE, null, atualizar, atualizar[0]);

					switch (escolhaAt) {

						case "Nome":
								String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
								em.getTransaction().begin();
								pessoaAtualizar.setNome(novoNome);
								em.getTransaction().commit();
								break;
								
						case "Email":
								String novoEmail = JOptionPane.showInputDialog("Digite o novo email:");
								em.getTransaction().begin();
								pessoaAtualizar.setEmail(novoEmail);
								em.getTransaction().commit();
								break;
							
						case "Telefone":
								String novoTelefone = JOptionPane.showInputDialog("Digite o novo telefone:");
								em.getTransaction().begin();
								pessoaAtualizar.setTelefone(novoTelefone);
								em.getTransaction().commit();
								break;
						
						case "Cargo Desejado":
								String novoCargo = JOptionPane.showInputDialog("Digite o novo cargo:");
								em.getTransaction().begin();
								pessoaAtualizar.setCargo(novoCargo);
								em.getTransaction().commit();
								break;
				}
					JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
				}
				break;

			case "Deletar":

				int idDeletar = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código único da pessoa que deseja deletar:"));
				Pessoa pessoaDeletar = em.find(Pessoa.class, idDeletar);

				if (pessoaDeletar != null) {

					em.getTransaction().begin();
					em.remove(pessoaDeletar);
					em.getTransaction().commit();

					JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
				}
				break;
			}

		}
	}

	private static void listarPessoas(EntityManager em) {
		List<Pessoa> pessoas = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
		StringBuilder listaPessoas = new StringBuilder("Lista de Pessoas:\n");

		for (Pessoa pessoa : pessoas) {
			listaPessoas.append("Código Único: ").append(pessoa.getId())
					.append(", Nome: ").append(pessoa.getNome())
					.append(", Email: ").append(pessoa.getEmail())
					.append(", Telefone: ").append(pessoa.getTelefone())
					.append(", Cargo Desejado: ").append(pessoa.getCargo()).append("\n");
		}

		JOptionPane.showMessageDialog(null, listaPessoas.toString());
	}
}
