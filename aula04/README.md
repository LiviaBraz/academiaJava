<h2> Aula 02 - Orientação a Objetos </h2>

<h6> Construtor </h6>

	Um construtor é um tipo especial de método que é chamado automaticamente quando um objeto de uma classe é criado.

	Sua principal função é inicializar o novo objeto. Isso pode incluir a alocação de memória, a definição de valores padrão para os atributos do objeto ou a execução de qualquer outra configuração ou operação inicial necessária.

	Em Java, tem o mesmo nome da classe e não possui um tipo de retorno.

	Pode ter parâmetros, o que permite configurar o objeto recém-criado de maneiras específicas no momento da criação.

<h6> Encapsulamento </h6> 

	É um dos pilares de POO e refere-se à prática de ocultar os detalhes nternos de implementação de uma classe e fornecer uma interface clara e bem definida para os objetos dessa classe.

	Isso é feito para proteger a integridade dos dados e garantis que os objetos se comportem de maneira previsível.
	
	É realizado usando modificadores de acesso (como private, protec ted e public) para restringir o acesso direto aos atributos ou métodos de uma classe.

	Em vez de acessar diretamente os atributos, usamos métodos 	"getter" e 	"setter" para obter ou definir seus valores. Isso oferce um controle granular sobre como os atributos são acessados e modificados.


- Public:

	Pode ser acessado de qualquer lugar: seja d edentro da mesma classe, classes derivadas ou de qualquer código externo.
	É o nível de acesso menos restritivo.

- Private:

	Só pode ser acessado de dentro da mesma classe onde foi definido.
	É usado para esconder a implementação interna da classe e para evitar que o código externo modifique o estado interno da classe de maneiras não intencionais ou inseguras.
	É o nível de acesso mais restritivo.

- Protected:

	Semelhante ao private, no sentido de que não pode ser acessado diretamente de fora da classe onde foi definido.
	Pode ser acessado por classes derivadas (subclasses) dessa classe.

<h6> Tarefa: Definir public ou private </h6>

- Atributos:

private id 
private numero 
private saldo

- Metodos:

public getid()
public getnumero()
public get saldo()
private efetuartransacao()
public depositar()
public retirar()
