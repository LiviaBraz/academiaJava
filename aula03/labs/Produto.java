package aula03;

public class Produto {
    
    private String nome;
    private double preco;
    private int qtd;

    public Produto(String nome, double preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double calcularValorTotal(int qtdDesejada) {
    	
        if (qtdDesejada <= qtd) {
            return preco * qtdDesejada;
        } else {
            System.out.println("Não há estoque suficiente deste produto.");
            return -1;
        }
    }

    public void atualizarEstoque(int quantidadeVendida) {
        if (quantidadeVendida <= qtd) {
            qtd -= quantidadeVendida;
        } else {
            System.out.println("Não há estoque suficiente para atender a esta compra.");
        }
    }

    public static void main(String[] args) {
        
        Produto produto1 = new Produto("Coca-Cola", 6.82, 100);

        System.out.println("Nome do Produto: " + produto1.getNome());
        System.out.println("Preço do Produto: R$" + produto1.getPreco());
        System.out.println("Quantidade em Estoque: " + produto1.getQtd());

        double valorTotal = produto1.calcularValorTotal(8);
        
        if (valorTotal >= 0) {
            System.out.println("\nValor Total da Compra: R$" + valorTotal);
            produto1.atualizarEstoque(8);
            System.out.println("\nNova Quantidade em Estoque: " + produto1.getQtd());
        }
    }
}
