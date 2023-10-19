package aula07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {

		List<Produto> produtos = new ArrayList<>();
		List<Servico> servicos = new ArrayList<>();
		List<Animal> animais = new ArrayList<>();
		
		JOptionPane.showMessageDialog(null, "     🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾    "
				+ "\n Bem vindx ao PetShop Amigo Fiel!\n" + "     🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾🐾  ");

		while (true) {

			String[] opcao = { "Cadastrar um animal", 
					"Cadastrar um produto", 
					"Cadastrar um serviço",
					"Mostrar produtos disponíveis", 
					"Comprar um produto", 
					"Agendar um serviço",
					"Mostrar agenda de serviços", 
					"Sair" };

			String escolha = (String) JOptionPane.showInputDialog(null, "Como posso lhe ajudar?\n",
					"PetShop - Amigo Fiel", JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

			switch (escolha) {

			case "Cadastrar um animal":
				String escolhaAnimal = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de animal:",
						"Cadastrar um animal", JOptionPane.PLAIN_MESSAGE, null,
						new String[] { "Cachorro", 
								"Gato", 
								"Pássaro" }, "Cachorro");

				switch (escolhaAnimal) {
				case "Cachorro":
					String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do cachorro:");
					String raca = JOptionPane.showInputDialog("Digite a raça:");
					String dataNascimentoStr = JOptionPane.showInputDialog("Insira a data de nascimento:");
					LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr,
							DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					String proprietario = JOptionPane.showInputDialog("Qual o nome do proprietário?");
					Animal novoAnimal = new Cachorro(nomeAnimal, raca, dataNascimento, proprietario);
					animais.add(novoAnimal);
					JOptionPane.showMessageDialog(null, "Cachorro cadastrado com sucesso.");
					break;
				case "Gato":
					nomeAnimal = JOptionPane.showInputDialog("Digite o nome do gato:");
					raca = JOptionPane.showInputDialog("Digite a raça:");
					dataNascimentoStr = JOptionPane.showInputDialog("Insira a data de nascimento:");
					dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					proprietario = JOptionPane.showInputDialog("Qual o nome do proprietário?");
					novoAnimal = new Gato(nomeAnimal, raca, dataNascimento, proprietario);
					animais.add(novoAnimal);
					JOptionPane.showMessageDialog(null, "Gato cadastrado com sucesso.");
					break;
				case "Pássaro":
					nomeAnimal = JOptionPane.showInputDialog("Digite o nome do pássaro:");
					raca = JOptionPane.showInputDialog("Digite a raça:");
					dataNascimentoStr = JOptionPane.showInputDialog("Insira a data de nascimento:");
					dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					proprietario = JOptionPane.showInputDialog("Qual o nome do proprietário?");
					novoAnimal = new Passaro(nomeAnimal, raca, dataNascimento, proprietario);
					animais.add(novoAnimal);
					JOptionPane.showMessageDialog(null, "Pássaro cadastrado com sucesso.");
					break;

				}
				break;

			case "Cadastrar um produto":
				String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
				String categoria = JOptionPane.showInputDialog("Digite a categoria:");
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor por unidade:"));
				int qntdEstoque = Integer
						.parseInt(JOptionPane.showInputDialog("Quantas unidades serão adicionadas ao estoque?"));
				Produto novoProduto = new Produto(nomeProduto, categoria, preco, qntdEstoque);
				produtos.add(novoProduto);
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
				break;

			case "Cadastrar um serviço":
				String escolhaServico = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de serviço:",
						"Cadastrar um serviço", JOptionPane.PLAIN_MESSAGE, null,
						new String[] { "Banho", "Tosa", "Consulta Veterinária", "Hospedagem" }, "Banho");

				Servico novoServico = null;

				switch (escolhaServico) {
				case "Banho":
					novoServico = new Banho();
					servicos.add(novoServico);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
					break;
				case "Tosa":
					novoServico = new Tosa();
					servicos.add(novoServico);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
					break;
				case "Consulta Veterinária":
					novoServico = new Consulta();
					servicos.add(novoServico);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
					break;
				case "Hospedagem":
					novoServico = new Hospedagem();
					servicos.add(novoServico);
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
					break;

				}
				break;

			case "Mostrar produtos disponíveis":

				String produtosDisponiveis = Produto.obterProdutosDisponiveis(produtos);
				JOptionPane.showMessageDialog(null, produtosDisponiveis);

				break;

			case "Comprar um produto":
				String nomeProdutoCompra = JOptionPane.showInputDialog("Qual produto deseja comprar?");
				int quantidadeCompra = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades?"));

				Produto produtoEncontrado = null;

				for (Produto produto : produtos) {
					if (produto.getNome().equalsIgnoreCase(nomeProdutoCompra)) {
						produtoEncontrado = produto;
						break;
					}
				}

				if (produtoEncontrado != null) {
					if (quantidadeCompra <= produtoEncontrado.getQntdEstoque()) {
						produtoEncontrado.comprar(quantidadeCompra);
						JOptionPane.showMessageDialog(null,
								quantidadeCompra + " unidades de " + nomeProdutoCompra + " compradas com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque.");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Produto não encontrado na lista. Produtos na lista: " + produtos);
				}
				break;

			case "Agendar um serviço":

				String nomeAnimal = JOptionPane.showInputDialog("Nome do animal:");
				String nomeServico = JOptionPane.showInputDialog("Nome do serviço:");
				String dataAgendamento = JOptionPane.showInputDialog("Data do agendamento (dd/MM/yyyy):");
				String horarioAgendamento = JOptionPane.showInputDialog("Horário do agendamento:");

				boolean animalCadastrado = false;
				for (Animal animal : animais) {
					if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
						animalCadastrado = true;
						break;
					}
				}

				boolean servicoDisponivel = false;
				for (Servico servico : servicos) {
					if (servico.getNome().equalsIgnoreCase(nomeServico)) {
						servicoDisponivel = true;
						break;
					}
				}

				if (!animalCadastrado || !servicoDisponivel) {
					JOptionPane.showMessageDialog(null,
							"Animal ou serviço não encontrado. Verifique os dados e tente novamente.");
				} else {
					boolean horarioOcupado = false;
					for (Agenda agendamento : Agenda.listaAgenda) {
						if (agendamento.getData().equals(dataAgendamento)
								&& agendamento.getHorario().equals(horarioAgendamento)) {
							horarioOcupado = true;
							break;
						}
					}
					if (horarioOcupado) {
						JOptionPane.showMessageDialog(null, "Este horário já está ocupado. Escolha outro horário.");
					} else {

						Agenda novaAgenda = new Agenda(nomeAnimal, nomeServico, dataAgendamento, horarioAgendamento);
						Agenda.listaAgenda.add(novaAgenda);
						JOptionPane.showMessageDialog(null, "Serviço agendado com sucesso.");
					}
				}

				break;

			case "Mostrar agenda de serviços":

				List<Agenda> listaAgenda = Agenda.listandoAgenda();

				if (listaAgenda.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum serviço agendado.");
				} else {
					StringBuilder agendaText = new StringBuilder("Agenda de Serviços:\n");
					for (Agenda agendamentos : listaAgenda) {
						agendaText.append("Animal: ").append(agendamentos.getAnimal()).append("\n");
						agendaText.append("Serviço: ").append(agendamentos.getServico()).append("\n");
						agendaText.append("Data: ").append(agendamentos.getData()).append("\n");
						agendaText.append("Horário: ").append(agendamentos.getHorario()).append("\n");
						agendaText.append("\n");
					}
					JOptionPane.showMessageDialog(null, agendaText.toString());
				}
				break;
			}

			if (escolha == null || escolha.equals("Sair")) {
				JOptionPane.showMessageDialog(null, "Obrigada por nos escolher. Volte sempre :)");
				break;
			}
		}

	}
}