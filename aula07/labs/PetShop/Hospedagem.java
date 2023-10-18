package aula07;

public class Hospedagem extends Servico{
	
	@Override
	public String getNome() {
        return "Hospedagem";
    }
	
	@Override
    public String descricao() {
        return "Hospedagem para seu bichinho. (Valor por diária)";
    }

    @Override
    public double preco() {
        return 50.0;
    }
}
