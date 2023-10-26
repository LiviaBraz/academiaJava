<h2> Aula 16 - Gerenciamento de Projetos com Maven </h2>

<h3> Maven </h3>

	Apache Maven é uma ferramenta de gerenciamento de projetos usada para gerenciar projetos desenvolvidos usando principalmente linguagens JVM, como Java.
	Ele é baseado no conceito de POM.	

- Principais tarefas e praticidades:

	> Construir o código fonte
	> Testar código fonte
	> Empacotar o código-fonte em um artefato (ZIP, JAR, WAR ou EAR)
	> Lidar com o controle de versão e releases dos artefatos
	> Gerar JavaDocs a partir do código-fonte
	> Gerenciar Dependências do Projeto

- Estrutura do Maven

	> A pasta src é a raiz do código-fonte e dos testes de nosso aplicativo. Então temos as seguintes subpastas:
		- src/main/Java contém o código-fonte java, do aplicativo
		- src/main/resources arquivos utilizados no projeto. (Ex: Arquivos de propriedade, demais XML, CSV). Caso se trate de um aplicativo, recursos estásticos também estarão nesta pasta
		- src/test/java ficam as classes de teste do projeto
		- JRE System Library implementa as APIS's Java no projeto
		- Maven Dependencies ficam os arquivos .jar utilizados nessa aplicação e sob gestão do Maven
		- target armazena os arquivos de classe java compilados
		- arquivo pom.xml contém os metadados das dependências do projeto 

- Arquivo POM

	Project Object Model (pom.xml) contém os metadados do projeto e também é responsável por gerenciar dependências e configurar plug-ins para automatizar tarefas repetitivas.

- Dependências

	Em qualquer projeto Java muitas vezes se faz necessário utilizar vários arquivos JAR de terceiros para desenvolvê-lo.
	Exemplos: Junit, Spring Framework, Selenium, etc.

- SNAPSHOT e RELEASE

	Uma dependência pode ser categorizada de duas maneiras:

	> SNAPSHOT: Quando o projeto está em desenvolvimento.
	> RELEASE: Quando o software está pronto para o lançamento.

- Escopos de Dependências

	Cada dependência Maven pode ser categorizada em 5 escopos diferentes.

	> Compile: É o escopo padrão. Dependências disponíveis no classpath do projeto.

	> Provided: Indica que o JDK ou o contêiner subjacente fornecerá a depêndencia que estará disponível no momento da compilação mas não empacotada no artefato.

	> Runtime: As dependências estarão disponíveis apenas em tempo de execução, mas não em compilação.

	> Test: Estão disponíveis apenas no momento da execução dos testes.

	> System: Semelhande ao provided, mas é preciso mencionar explicitamente onde a dependencia pode ser encontrada no sistema, usando a tag systemPath.

- Repositórios

	As dependências são armazenadas em um diretório especial chamado Repositório.
	Existem 2 tipos:

	> Local Repository: Repositório Local é um diretório na máquina onde o Maven está sendo executado.

	> Remote Repository: Um repositório remoro é um site onde podemos baixar dependências Maven.

- Ciclio de Vida

	É dividido em 3 partes, todas independentes mas que podem ser executadas juntas:

	> Default:
		Diferentes fases:
			> Validate: verifica se o arquivo pom.xml é válido ou não
			> Compile: compila o código-fonte
			> Test: executa testes de unidade
			> Package: empacota o código-fonte em um artefato (ZIP, JAR, WAR ou EAR)
			> Tintegration-test: executa testes marcados como de integração
			> Verify: verifica se o pacote criado é válido ou não
			> Install: instala o pacote criado em nosso repositório local
			> Deploy: implanta o pacote criado no repositório remoto

	> Clean: É responsável por limpar o .class e metadados gerados pelas fases de compilação.

	> Site: É responsável por gerar a documentação Java.

- Puglins

	Para executar as fases do ciclo de vida, o Maven fornece plugins para cada tarefa.
	Cada plugin tem um objetivo específico.

	> Puglin Compilação: é responsável por compilar os arquivos Java nos arquivos .class. Equivalente a javac.

	> Maven Surefire: gera relatórios de texto e XML na pasta target/surefire-reports.
	Utilizado para execução de testes.

	> Instalação: é usado paa empacotar o código-fonte em um artefato de nossa escolha como um JAR e instalá-lo no repositório local que é a pasta /.m2/repository
	A instalação inclui fases anteriores do ciclo de vida: validate, compile, test, package e install.	

	> Maven Clean: a fase da limpeza em que todo o conteúdo da pasta de destino será removido.

	> Outros plugins: existem uma diversidade de plugins que podem ser utilizados em um projeto com o Maven, os quais podem ser encontrados <a href="maven.apache.org/plugins/index.html">aqui.</a> 