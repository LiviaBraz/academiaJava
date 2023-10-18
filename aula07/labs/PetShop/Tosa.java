package aula07;

public class Tosa extends Servico {
	
	@Override
	public String getNome() {
        return "Tosa";
    }
	
    @Override
    public String descricao() {
        return "Tosa para o animal.";
    }

    @Override
    public double preco() {
        return 30.0;
    }
}

