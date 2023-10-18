package aula07;

public class Banho extends Servico {
	
	@Override
	public String getNome() {
        return "Banho";
    }
	
	
    @Override
    public String descricao() {
        return "Banho para o animal.";
    }

    @Override
    public double preco() {
        return 25.0;
    }
}
