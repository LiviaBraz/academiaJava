<h2> Aula 23 - Servidores de Aplicação </h2>

Um servidor de aplicação é um software que fornece um ambiente para executar aplicativos Java, geralmente aplicativos empresariais.

São responsáveis por gerenciar a execução de aplicativos Java, rotear solicitações HTTP, gerenciar transações, fornecer serviços de segurança e muito mais. Os desenvolvedores implantam seus aplicativos nesses servidores para que eles possam ser acessados por meio da web.

<h3> Apache Tomcat </h3>

É um servidor de código aberto que implementa as especificações Java Servlet e JavaServer Pages(JSP). Atua como um contêiner que hospeda aplicativos web baseados em Java.

- Características Principais:

> Leve
	É conhecido por ser leve e de fácil configuração, tornando-o uma escolha popular para aplicativos web simples.

> Open Source
	É uma solução de código aberto mantida pela Apache Software Foundation.

> Conformidade com Padrões
	Ele adere rigorosamente às especificações Servlet e JSP, garantindo a portabilidade dos aplicativos Java Web.

> Modularidade
	É possível estender suas funcionalidades por meio da inclusão de módulos e plugins.

> Suporte a SSL
	Oferece suporte à criptografia SSL, permitindo a configuração de conexões seguras para aplicativos web.

<h3> Wlidfly (JBoss) </h3>

Anteriormente conhecido como JBoss Application Server, é um servidor de aplicação Java de código aberto desenvolvido pela Red Hat. 
Oferece um ambiente de execução robusto e escalável para aplicativos Java EE (Enterprise Edition). 
Ele implementa as especificações Java EE, tornando-o adequado para aplicativos empresariais que exigem recursos avançados.

- Principais características

> Suporte Java EE
	Oferece suporte completo às especificações Java EE, como Servlet, JSP, EJB (Enterprise JavaBeans), JMS (Java Message Service), CDI (Contexts and Dependency Injection).
	Sendo mais adequado para aplicativos corporativos mais complexos que fazem uso extensivo dessas tecnologias.

> Clustering
	Oferece recursos avançados de clustering e balanceamento de carga, o que o torna adequado para implantações de disponibilidade.

> Gerenciamento avançado
	Possui uma interface de administração avançada que permite configurar e gerenciar servidores de aplicação de maneira mais conveniente e eficiente.

> Microperfil
	Além da versão completa do Wildfly, existe o Wildfly Swarm, que permite criar servidores de aplicação altamente otimizados para cargas de trabalho específicas.

<h3> Comparação de recursos e Capacitades </h3>

- Tomcat: 
	É mais leve e adequado para aplicativos web simples.

- Wildfly:
	Oferece suporte a um conjunto mais amplo de tecnologias Java EE, mais adequado para aplicativos empresariais complexos.

	Oferece recustos avançados, como clustering e balanceamento de carga, que podem ser fundamentais para aplicações de alta disponibilidade.
