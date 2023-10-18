package aula07;

public class Consulta extends Servico{
	
	@Override
	public String getNome() {
        return "Consulta Veterinária";
    }
	
	@Override
    public String descricao() {
        return "Consulta veterinária.";
    }

    @Override
    public double preco() {
        return 80.0;
    }
}
