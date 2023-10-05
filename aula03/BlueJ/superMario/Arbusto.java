public class Arbusto
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String corPrimaria = "Verde Claro";
    private String corSecundaria = "Verde Escuro";
    private int coordX;
    private int coordY;
    private String tamanho;
    
    /**
     * Construtor para objetos da classe Arbusto
     */
    public Arbusto(int x, int y, String t)
    {
        // inicializa variáveis de instância
        coordX = x;
        coordY = y;
        tamanho = t;
    }
}
