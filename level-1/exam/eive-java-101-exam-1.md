1. Qual comando possibilita a visualização de forma resumida dos commits realizados em um repositório?
   1. `git log --short`
   2. `git log --oneline`
   3. `git show --all`
   4. `git commits --summary`
   5. `git log --summary`

2. Quais os comandos para configurar sua identidade no Git? (desconsidere o uso de flags)
   1. `git config username "John Doe"`, `git config email "john.doe@db1.com.br"`
   2. `git config user.name "John Doe"`, `git config email "john.doe@db1.com.br"`
   3. `git config user.name "John Doe"`, `git config user.mail "john.doe@db1.com.br"`
   4. `git config user.name "John Doe"`, `git config user.email "john.doe@db1.com.br"`
   5. `git config user.username "John Doe"`, `git config user.email "john.doe@db1.com.br"`

3. Qual(is) a(s) diferença(s) entre os comandos `git merge` e `git rebase`?

4. No Git, é possível salvar o estado atual de seu trabalho e voltar ao estado do último commit da branch. Nesse caso, qual comando devemos utilizar? E para recuperar o trabalho posteriormente, qual é o comando?

5. No contexto do Git, o que são, para que servem e em quais casos devemos criar `issues`?

6. O que é e para que serve o `cherry-pick`?

7. No cotidiano de um desenvolvedor, é comum que conflitos apareçam, e é de responsabilidade do mesmo resolvê-los. Qual o processo mostrado em curso para a resolução de um conflito?

8. Existe uma estratégia de branching chamada Git Flow, muito comumente aplicada no desenvolvimento de software. Qual das opções abaixo representam as branches presentes nessa estratégia, de acordo com o conteúdo?

   1. `master`, `develop`, `feat`, `hotfix` e `release`
   2. `master`, `develop`, `feature`, `fix` e `release`
   3. `master`, `develop`, `feature`, `hotfix` e `release`
   4. `master`, `develop`, `feat`, `fix` e `release`
   6. `master`, `develop`, `feat`, `fix` e `rc`

9. Qual(is) a(s) diferença(s) entre JRE e JDK?

10. O que é um workspace, no contexto do Eclipse?

11. Em Java, o operador `+` possui duas funções básicas. Quais são elas? Dê um exemplo em código de cada uma delas.

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
    5. `2.0`

13. Por que o type casting "implícito" do Java não é possível no caso abaixo?

    ```java
    class App {
        public static void main(String... args) {
            float pi = 3.14;
        }
    }
    ```

14. Observe o código abaixo. Ele compilará? Qual a diferença entre as variáveis `firstValue` e `secondValue`?

    ```java
    class App {
        public static void main(String... args) {
            char firstValue = 'a';
            char secondValue = 97;
        }
    }
    ```

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

    ```java
    // código 2
    class App {
        public static void main(String... args) {
            boolean hasValue;
            System.out.println(hasValue);
        }
    }
    ```

16. Para que serve e quando utilizar o comando `break`?

17. Quais as diferenças entre classe, objeto e referência?

18. O que é exibido no terminal ao executar o código abaixo, considerando que ClasseExemplo não sobreescreveu o método `toString()`? Explique cada parte da estrutura do que é mostrado.

    ```java
    class App {
        public static void main(String... args) {
            ClasseExemplo exemplo = new ClasseExemplo();
            System.out.println(exemplo);
        }
    }
    ```

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

20. Em Java, existem atributos e métodos de classe. Explique como declará-los e qual(is) a(s) diferença(s) entre eles e os atributos e métodos de instância.

21. Os códigos mostrados até agora não respeitam os pilares da Programação Orientada a Objetos. Descreva cada um deles e explique seus benefícios e aplicações.

22. Em Java, conseguimos aplicar a herança entre classes com a _keyword_ `extends`. Explique quais os benefícios de utilizar esse conceito no código.

24. Explique a(s) diferença(s) entre as *keywords* `this` e `super`. No caso da `super`, ela pode ser utilizada tanto no formato `super.` quanto `super()`, porém com aplicações diferentes - explique essas duas aplicações e dê exemplos de quando utilizar cada uma.

25. No exemplo abaixo, a classe `Ornitorrinco` é herdada de `Mamifero`. Por que o código não compila, como seria possível ajustá-lo para que compilasse e, após ajustado, o que ele exibirá quando for executado?

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

26. Sobre construtores, qual(is) das alternativas abaixo está(ão) correta(s)?

    1. O construtor `default` do Java deixa de existir assim que algum outro é declarado;
    2. O construtor `default` do Java possui como parâmetros todos os atributos da classe;
    3. É obrigatória a criação de construtores explícitos quando a classe é herdada em algum local;
    4. Os construtores sempre precisam ter o modificador de acesso `public`. Caso contrário, o código não compila;
    5. O construtor `super()` precisa sempre ser chamado de forma explícita, em todos os casos de herança.

27. Qual a utilidade de classes abstratas em Java? E de métodos abstratos?

28. Qual a utilidade de interfaces em Java?

29. Como funciona a composição em Java?

30. Quando devemos utilizar classes abstratas (herança) e quando devemos utilizar interfaces? Qual o principal problema que o uso da segunda opção pode gerar, se não for feito da forma correta?