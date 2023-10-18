package aula07;

import java.util.List;

public class Produto {

	private String nome;
	private String categoria;
	private double preco;
	private int qntdEstoque;
	
	public Produto(String nome, String categoria, double preco, int qntdEstoque) {
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.qntdEstoque = qntdEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQntdEstoque() {
		return qntdEstoque;
	}

	public void setQntdEstoque(int qntdEstoque) {
		this.qntdEstoque = qntdEstoque;
	}
	
	public void comprar(int quantidadeCompra) {
	    qntdEstoque -= quantidadeCompra;
	    
	}
	
	public static String obterProdutosDisponiveis(List<Produto> produtos) {
        StringBuilder produtosText = new StringBuilder("Produtos Disponíveis:\n");
        
        for (Produto produto : produtos) {
            produtosText.append("Nome: ").append(produto.getNome()).append("\n");
            produtosText.append("Categoria: ").append(produto.getCategoria()).append("\n");
            produtosText.append("Preço: ").append(produto.getPreco()).append("\n");
            produtosText.append("Quantidade Disponível: ").append(produto.getQntdEstoque()).append("\n\n");
        }
        
        return produtosText.toString();
    }
	
}
