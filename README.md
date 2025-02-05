# API Test Automation Project qa-assessment.svc.hostfully.com

## Description

This is an assessment project on automating testing of Rest APIs using Rest Assured and JUnit5 tools with Java from the URL https://qa-assessment.svc.hostfully.com  

## Required software

* [Java JDK 22+](https://www.oracle.com/pt/java/technologies/javase/jdk11-archive-downloads.html)

* [Apache Maven 3.6+](https://maven.apache.org/docs/3.6.0/release-notes.html)

* Clone the repository: ```git clone https://github.com/leonardomelgarejo/hostfully-qa.git```

## How to run the tests

* You can manually run each test in ```src/test/java/com/svc/com/hostfully/svc/qa_assessment/tests```
* You can manually run the test suite in ```src/test/java/com/svc/com/hostfully/svc/suite```
* You can run the tests via the command line with ```mvn clean test```
  * Complement: The execution of the above command is configured in the project's POM.xml to execute the test suite `src/test/java/com/svc/com/hostfully/svc/suite/AllTestsSuite.java`.

## Test report

* O relatório de testes é gerado pelo framework Allure Reports, de duas formas:
    * Localmente, executando os comando abaixo:
        * mvn allure:serve : Abrirá o relatório HTML no navegador
        * mvn allure:report : Irá gerar o HTML na pasta target/site/allure-maven-plugin
    * O local onde o arquivo referência para o relatório são definidos no src/test/resources/allure.properties
    * Remotamente, acessando :
        * https://fakestoreapi-037dc7.gitlab.io/
        * Ou no link do Gitlab Pages, ao lado direito da tela inicial do projeto

## Estrutura do projeto

```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── fakestoreapi
│   │   │           ├── client
│   │   │           │    ├── ApiClient.java
│   │   │           │    └── LoginClient.java
│   │   │           │    └── ProductClient.java
│   │   │           ├── config
│   │   │           │   ├── Configuration.java
│   │   │           │   └── ConfigurationManager.java
│   │   │           ├── factory
│   │   │           │   ├── LoginDataFactory.java
│   │   │           │   └── ProductDataFactory.java
│   │   │           ├── model
│   │   │           │   ├── Login.java
│   │   │           │   └── Product.java
│   │   │           └── specs
│   │   │               └── InitialStateSpecs.java
│   │   └── resources
│   │       └── log4j2.properties                   
│   └── test
│       ├── java
│       │   └── com
│       │       └── fakestoreapi
│       │            ├── suite
│       │            │   └── AllTestsSuite.java
│       │            ├── tests
│       │            │   ├── HealthCheckTest.java
│       │            │   ├── LoginContractTest.java
│       │            │   ├── LoginE2ETests.java
│       │            │   ├── LoginTests.java
│       │            │   ├── ProductContractTest.java
│       │            │   ├── ProductE2ETests.java
│       │            │   └── ProductTests.java
│       │            └── BaseAPI.java
│       │
│       └── resources
│           ├── schemas
│           │   ├── login.json
│           │   └── products.json
│           ├── allure.properties
│           └── api.properties
├── .gitignore
├── .gitlab-ci.yml
├── pom.xml
└── README.md
```

## Sobre a estrutura do projeto

### src/main/java

#### client

Classes que interagem com os endpoins. São chamados nos passos dos métodos de testes.

#### config

As classes de configuração são as conexões entre o arquivo de propriedades api.properties localizado em src/test/resources/.

O @Config.Sources carrega o arquivo de propriedades e combina os atributos com o @Key, para que você tenha o valor automaticamente. Você pode ver duas fontes. O primeiro irá obter os valores das propriedades do sistema (como variáveis de ambiente ou da linha de comando) caso você queira alterá-lo, por exemplo, em um pipeline. O segundo carregará o arquivo api.properties do caminho de classe.

```
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
```

A variável de ambiente é lida no ConfiguratorManager. Esta classe reduz a quantidade de código necessária para obter qualquer informação no arquivo de propriedades.

Esta estratégia usa a biblioteca Owner.

#### factory

Aplica o padrão factory para gerar instâncias genéricas, facilitando a gestão dos dados necessários nas inclusões de objetos.

#### model

Classe Model e Builder(interna no Model) para mapear objetos através de serialização e desserialização em uso com Rest-Assured.

#### specs

Especificações de solicitação e resposta utilizadas pelos clientes e testes. A classe InitialStepsSpec define basePath, baseURI e porta para as especificações personalizadas. As classes RestrictionsSpecs e SimulationsSpecs contêm a implementação de especificações de solicitação e resposta.

### src/main/java

#### suite

Ele contém uma classe com os dados relacionados aos grupos de teste.

#### tests

Contém as classes de tests dividos por HealthCheckAPITests, ProductContractTests, ProductTests e ProductE2ETests

#### BaseAPI

Classe de teste que contém as configurações iniciais para a execução de todos os testes.

## Padrões aplicados
* Test Data Factory
* Data Provider
* Builder
* Request and Response Specification
* Base Test

## Pipeline

Esse projeto usa [Gitlab CI](https://docs.gitlab.com/ee/ci/) to run the all the tests in a pipeline.

Você pode encontrar esta configuração em https://gitlab.com/leonardomelgarejo/fakestoreapi/-/blob/main/.gitlab-ci.yml

Nós temos os seguintes steps:
```
build -> test -> report -> deploy 
```

## Integrações
Este projeto está configurado para integrar notificações de ações no projeto com o Slack, no canal privado #gitlab-slack

As notificações da pipeline configurada para o CI(Continuouns Integration), são geradas apenas em caso de falha.

## Bibliotecas 
* [JUnit Jupiter API 5.11.0+](https://testng.org/)
* [REST Assured 5.5.0+](https://www.selenium.dev/)
* [Owner](https://matteobaccan.github.io/owner/)
* [Log4J2](https://logging.apache.org/log4j/2.x/)
* [Allure Report](https://docs.qameta.io/allure/)


    
