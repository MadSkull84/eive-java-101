1. Qual comando possibilita a visualização de forma resumida dos commits realizados em um repositório?
   1. `git log --short`
   2. ***`git log --oneline`***
   3. `git show --all`
   4. `git commits --summary`
   5. `git log --summary`

2. Quais os comandos para configurar sua identidade no Git? (desconsidere o uso de flags)
   1. `git config username "John Doe"`, `git config email "john.doe@db1.com.br"`
   2. `git config user.name "John Doe"`, `git config email "john.doe@db1.com.br"`
   3. `git config user.name "John Doe"`, `git config user.mail "john.doe@db1.com.br"`
   4. ***`git config user.name "John Doe"`, `git config user.email "john.doe@db1.com.br"`***
   5. `git config user.username "John Doe"`, `git config user.email "john.doe@db1.com.br"`

3. Qual(is) a(s) diferença(s) entre os comandos `git merge` e `git rebase`?
***Merge - faz a mesclagem dos branchs utilizados gerando um novo commit***
***Rebase - reescreve o histórico do branch com os commits do branch de origem e aplica as alterações do branch ao final***

4. No Git, é possível salvar o estado atual de seu trabalho e voltar ao estado do último commit da branch. Nesse caso, qual comando devemos utilizar? E para recuperar o trabalho posteriormente, qual é o comando?
***Para salvar `git stash`***
***Para recuperar temos duas opções `git stash pop`(aplica e remove o stash) ou então `git stash apply`(aplica e mantem o stash)***

5. No contexto do Git, o que são, para que servem e em quais casos devemos criar `issues`?
***É uma forma de mapear e controlar bgus encontrados, melhorias a serem feitas, novas funcionalidades, etc.***

6. O que é e para que serve o `cherry-pick`?
***É o comando que permite aplicar commits especificos ao branch no qual estamos trabalhando, sem a necessidade de trazer todas as alterações do branch onde se encontra.***

7. No cotidiano de um desenvolvedor, é comum que conflitos apareçam, e é de responsabilidade do mesmo resolvê-los. Qual o processo mostrado em curso para a resolução de um conflito?
***Foi através de um merge.***
***Para solucionar o conflito o arquivo foi editado e mantido a alteração correta e removendo as tags que indicam o conflito. Após a alteração gerar um commit, fazer um pull e merge do branch, caso tenha conflitos resolver e gerar novo commit e por fim um push para o servidor.***
```
<<<<<<< HEAD ... (linha a ser removida)
... (codigo mantido)
======= (linha a ser removida)
... (codigo removido)
>>>>>>> branch (linha a ser removida)
```

8. Existe uma estratégia de branching chamada Git Flow, muito comumente aplicada no desenvolvimento de software. Qual das opções abaixo representam as branches presentes nessa estratégia, de acordo com o conteúdo?

   1. `master`, `develop`, `feat`, `hotfix` e `release`
   2. `master`, `develop`, `feature`, `fix` e `release`
   3. ***`master`, `develop`, `feature`, `hotfix` e `release`***
   4. `master`, `develop`, `feat`, `fix` e `release`
   6. `master`, `develop`, `feat`, `fix` e `rc`

9. Qual(is) a(s) diferença(s) entre JRE e JDK?
***JRE - Ambiente onde a aplicação java é executada.***
***JDK - Abiente para o desenvolvimento e a execução de aplicações java.***

10. O que é um workspace, no contexto do Eclipse?
***É o espaço fisico da maquina onde você trabalha, porém o eclipse permite gerenciar e trabalhar com multiplos workspaces.***

11. Em Java, o operador `+` possui duas funções básicas. Quais são elas? Dê um exemplo em código de cada uma delas.
***Como operador aritmético de adição. Vide exemplo 1.***
***Para concatenar mensagens, campos do tipo string com outros tipos, como por exemplo inteiro. Vide exemplo 2.***
    ```java
    /*exemplo 1*/
    class App {
        public static void main(String... args) {
            int soma = 5 + 2;
            System.out.println(soma);
        }
    }
    ```
    ```java
    /*exemplo 2*/
    class App {
        public static void main(String... args) {
            int soma = 5 + 2;
            System.out.println("Resultado da soma = " + soma);
        }
    }
    ```  

12. Ao realizar a operação abaixo, qual será o resultado mostrado no console?

    ```java
    class App {
        public static void main(String... args) {
            double divisionResult = 5 / 2;
            System.out.println(divisionResult);
        }
    }
    ```

    1. `2`
    2. `3.0`
    3. `3`
    4. `2.5`
    5. ***`2.0`***

13. Por que o type casting "implícito" do Java não é possível no caso abaixo?

    ```java
    class App {
        public static void main(String... args) {
            float pi = 3.14;
        }
    }
    ```
    ***Porque o java considera o valor que será atribuido como do tipo double que é 64 bits e o float é apenas 32 bits.***

14. Observe o código abaixo. Ele compilará? Qual a diferença entre as variáveis `firstValue` e `secondValue`?

    ```java
    class App {
        public static void main(String... args) {
            char firstValue = 'a';
            char secondValue = 97;
        }
    }
    ```
    ***Sim irá compilar. Não existe diferança entre as duas, elas armazenam o mesmo tipo de dado, o que muda é a forma de atribuir os valores.***

15. Observe os códigos abaixo. Ao serem compilados e executados, o que é exibido no terminal?

    ```java
    // código 1
    class App {
        boolean hasValue;
        public static void main(String... args) {
            System.out.println(hasValue);
        }
    }
    ```
    ***Exception in thread "main" java.lang.Error: Unresolved compilation problem:***
	***Cannot make a static reference to the non-static field hasValue***
	***at programa.main(programa.java:5)***

    ```java
    // código 2
    class App {
        public static void main(String... args) {
            boolean hasValue;
            System.out.println(hasValue);
        }
    }
    ```
    ***Exception in thread "main" java.lang.Error: Unresolved compilation problem:***
	***The local variable hasValue may not have been initialized***
	***at programa.main(programa.java:5)***

16. Para que serve e quando utilizar o comando `break`?
***Interrompe a execução do laço de repetição, utilizado quando se quer sair forçadamente de um laço de repetição.***

17. Quais as diferenças entre classe, objeto e referência?
***Classe - definição dos dados que compoem um objeto, incluindo seus atributos e metodos.***
***Objeto - instacia criada a partir de uma classe e que pode ser manipulado pela aplicação.***
***Referência - é o endereço de memoria onde se encontra o objeto criado.***

18. O que é exibido no terminal ao executar o código abaixo, considerando que ClasseExemplo não sobreescreveu o método `toString()`? Explique cada parte da estrutura do que é mostrado.

    ```java
    class App {
        public static void main(String... args) {
            ClasseExemplo exemplo = new ClasseExemplo();
            System.out.println(exemplo);
        }
    }
    ```
    ***ClasseExemplo@4517d9a3***
    ***Primeira parte `ClasseExemplo` se refere ao nome da classe instanciada.***
    ***Segunda parte `@4517d9a3` referencia o endereço de memoria onde o objeto foi instanciado.***

19. O que é exibido no terminal ao executar o código abaixo?

    ```java
    class Pessoa {
        Endereco endereco;
    }

    class Endereco {
        String cep;
    }

    class App {
        public static void main(String... args) {
            Pessoa aluno = new Pessoa();
            System.out.println(aluno.endereco.cep);
        }
    }
    ```
    ***Exception in thread "main" java.lang.NullPointerException*** 
    ***at programa.main(programa.java:5)***
    ***Isso ocorre porque o atributo endereco da classe Pessoa não foi instanciado.***

20. Em Java, existem atributos e métodos de classe. Explique como declará-los e qual(is) a(s) diferença(s) entre eles e os atributos e métodos de instância.
***É utilizada a palavra chave `static` na declaração dos atributos e métodos.***
***A diferença entre os dois está no fato de que os atributos e métodos de classe podem ser utilizados sem a necessidade de instanciar um objeto a partir da mesma.***

21. Os códigos mostrados até agora não respeitam os pilares da Programação Orientada a Objetos. Descreva cada um deles e explique seus benefícios e aplicações.
`Abstração` 
***Identificar de forma unica o objeto, definir seu atributos de acordo com as suas caracteristicas e definir seu metodos a partir da identificação das ações que objeto possui.***
***Beneficios: Reduzir complexidade e impacto de alterações.***
***Aplicação: Definir de forma funcional um objeto com seus atributos e metodos, definindo o mesmo de forma unica.***
`Encapsulamento `
***Atribuir como privado atributos e metodos que devem ser acessados apenas internamente pela casse/objeto.***
***Beneficios: oferece segurança, garantindo que apenas a classe altere suas informações.***
***Aplicação: Quando se quer que um atributo não possa ser alterado por outras classes, então o mesmo é colocado como privado e caso haja a intenção de alterar é utilizado um metodo publico da classe onde havera as tratativas para essa alteração.***
`Herança`
***Definir superclasses, para evitar a repetição de atributos e metodos que classes possam possuir em comum.***
***Beneficios: Evitar a repetição de codigo, atributos e metodos em comum a classes.***
***Aplicação: Exemplo duas classes semelhantes, tipo Cachorro e Gato, ambas possuem em comum atributos como Cor da Pelagem, Altura, Peso, etc. assim como metodos Andar, Correr, etc.. Para evitar essa repetição podemos criar uma superclasse Mamifero onde esses atributos e metodos serão definidos.***
`Polimorfismo`
***Permiti que possamos instanciar um objeto a partir da sua classe base usando herança e assim acessar metodos que possuem implementações distintas.***
***Beneficios: Redução de codigo desnecessário.***
***Aplicação: Quando um metodo possue implementações distintas para os objetos que herdam a superclasse.***

22. Em Java, conseguimos aplicar a herança entre classes com a _keyword_ `extends`. Explique quais os benefícios de utilizar esse conceito no código.
***Ao utlizar a herança nos evitamos a repetição de código, mas especifico nos temos a vantagem de não repetir atributos em comum as classes assim como métodos que serão utilizados em comum por todas.***
***Também nos permite utilizar o polimorfismo.***

24. Explique a(s) diferença(s) entre as *keywords* `this` e `super`. No caso da `super`, ela pode ser utilizada tanto no formato `super.` quanto `super()`, porém com aplicações diferentes - explique essas duas aplicações e dê exemplos de quando utilizar cada uma.
***O `super` é utilizado quando se precisa referir a um atributo ou método presente na classe mãe.***
***Já o `super()` é utilizado para chamar o construtor da classe mãe.***

25. No exemplo abaixo, a classe `Cachorro` é herdada de `Mamifero`. Por que o código não compila, como seria possível ajustá-lo para que compilasse e, após ajustado, o que ele exibirá quando for executado?

    ```java
    class Mamifero {
    	public void fazerSom() {
    		System.out.println("...");
    	}
    }

    class Cachorro extends Mamifero {
    	public void fazerSom() {
    		this.latir();
    	}

    	private void latir() {
    		System.out.println("Woof woof");
    	}
    }

    class App {
        public static void main(String... args) {
            Cachorro beethoven = new Mamifero();
            beethoven.fazerSom();
        }
    }
    ```
    ***Não compila porque `Mamifero` não herda de `Cachorro` e sim ao contrário disso, para ajustar o código é necessário alterar a declaração da variavel `beethoven` para que ela seja do tipo `Mamifero` e instancie uma classe do tipo `Cachorro`, após esse ajuste o código irá compilar e exibira o resultado `Woof woof`.***

26. Sobre construtores, qual(is) das alternativas abaixo está(ão) correta(s)?

    1. O construtor `default` do Java deixa de existir assim que algum outro é declarado;
    2. O construtor `default` do Java possui como parâmetros todos os atributos da classe;
    3. É obrigatória a criação de construtores explícitos quando a classe é herdada em algum local;
    4. ***Os construtores sempre precisam ter o modificador de acesso `public`. Caso contrário, o código não compila;***
    5. ***O construtor `super()` precisa sempre ser chamado de forma explícita, em todos os casos de herança.***

27. Qual a utilidade de classes abstratas em Java? E de métodos abstratos?
***Permite a declaração de um classe que possue apenas a definições de atributos e métodos sem que haja a implementação dos mesmo, deixando essa responsabilidade para as classes que herdam dela.***

28. Qual a utilidade de interfaces em Java?
***Utilizada para estabelecer um `contrato` delegando a obrigatoridade da implementação dos métodos definidos na interface.***

29. Como funciona a composição em Java?
***Declarando um atributo de uma classe como sendo um tipo de outra classe.***

30. Quando devemos utilizar classes abstratas (herança) e quando devemos utilizar interfaces? Qual o principal problema que o uso da segunda opção pode gerar, se não for feito da forma correta?
`Classes Abstratas`
***Quando as classes que herdam precisam implementar metodos especificos, porem compartilham outros metodos e atributos.***
`Interfaces`
***Quando existe a obrigatoriedade da implementação de métodos nas classes que a implementam.***
***O principal problema que a utilização de interfaces pode gerar é a repetição de codigo.***