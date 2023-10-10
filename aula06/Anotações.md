<h2> Aula 06 - Orientação a Objetos </h2>

<h4> Polimorfismo </h4>

	Definimos Polimorfismo como um princípio a partir do qual as classes derivadas de uma única classe base são capazes de invocar os métodos que, embora apresentem a mesma assinatura, comportam-se de maneira diferente para cada uma das classes derivadas.

	O polimorfismo é um mecanismo por meio do qual selecionamos as funcionalidades utilizadas de forma dinâmica por um programa no decorrer de sua execução.

	Com o Polimorfismo, os mesmos atributos e objetos podem ser utilizados em objetos distintos, porém, com implementações lógicas diferentes.

- Exemplo: 
	
	Podemos dizer que uma classe chamada Vendedor e outra chamada Gerente podem ter como base uma classe chamada Pessoa, com um método chamado CalcularVendas. Se este método (definido na classe base) se comportar de maneira diferente para as chamadas feitas a partir de uma intância de Vendedor e para as chamadas feitas a partir de uma instância de Diretos, ele será considerado um método polimórfico, ou seja, um método de várias formas. 
	