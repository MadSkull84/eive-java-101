1. Por que a execução do Java é realizada em pilha?

   ***Para que o mesmo possa se orientar sobre o caminho seguido, de onde vim, pra onde vou e para onde devo voltar.***

2. Em programação, qual(is) a(s) utilidade(s) de *debugar* um código?

   ***Para poder validar o que está ocorrendo com o fonte, verificar o caminho que está seguindo os valores dos dados que estão sendo processados e com isso identificar os erros que estão ocorrendo.***

3. Em Java, qual efeito as exceções possuem sobre o fluxo de execução da pilha? Por que, em muitos casos, o próprio desenvolvedor escreve códigos que intencionalmente lançam essas exceções?

   ***As exceções interropem a execução fazendo que o fluxo seja interrompido e que se retorne ao inicio da pilha de execução. Para poder controlar o fluxo, tratando corretamente a exceção e evitando que a pilha de execução seja interrompida.***

4. O que são e qual(is) a(s) diferença(s) entre as classes `Throwable`, `Exception` e `RuntimeException`?

   `Throwable` - ***É classe pai de todas as execeções no Java.***
   
   `Exception` - ***Quando temos uma classe que gera uma exceção controlada que será tratada dentro da aplicação.***
   
   `RuntimeException` - ***Quando temos uma classe que gera uma exceção não controlada e que não será necessariamente tratada dentro da aplicação.***
   
5. O que são e qual(is) a(s) diferença(s) entre exceções _checked_ e _unchecked_?

   `checked` - ***Herdam de Exception, são as exceções esperadas pela rotina desenvolvida e que serão tratadas.***
   
   `unchecked` - ***Herdam de RuntimeException, são exceções não esperadas pela rotina e que nem sempre receberão algum tratamento.***

6. Qual(is) a(s) diferença(s) entre uma exceção e um erro em Java?

   `erro` - ***É gerado quando algum recurso falta onde o sistema está sendo executado, sendo irrecuperável e podendo encerrar a execução da aplicação.***
   
   `execeção` - ***Gerado por falha de codificação, podendo ser tratada e recuperada evitando o encerramento da aplicação.***

7. Explique as *keywords* `try`, `catch`, `finally`, `throw` e `throws`.

   `try` - ***Bloco onde haverá uma codificação que o sistema tentára executar.***
   
   `catch` - ***Bloco que captura e trata a execeção gerada dentro do bloco "try"***
   
   `finally` - ***Bloco que sempre será executado após o sucesso da execução do bloco "try" ou então após o tratamento da exceção efetuado no bloco "catch"***
   
   `throw` - ***É usado para lançar um objeto de exceção.***
   
   `throws` - ***Declarado no método para indicar o tipo de exceção que será gerado quando houver erro na excução do mesmo.***

8. O que é e para que serve a interface `AutoCloseable`? Como funciona o *try with resources*?

   `AutoCloseable` - ***É usado quando se faz necessário o encerramento da utilização de recursos ao final de um bloco de "try-finally" ao implementar essa interface podemos usar o "try with resources" que ficara responsável por executar o código necessário ao concluir o uso do recurso. Exemplo fazer a leitura de um arquivo, ao concluir a leitura ou caso ocorra algum erro o arquivo sempre será fechado.***

9. Sobre pacotes, é correto afirmar que:

   1. ***É boa prática nomear os pacotes na estrutura `{site_ao_contrário}.{nome_do_projeto}`;***
   2. Não devemos criar muitos pacotes, pois prejudica a navegação e legibilidade dentro do projeto;
   3. O uso de pacotes corretamente está diretamente relacionado à qualidade arquitetural de um projeto, já que eles servem para organizá-lo;

10. Explique a(s) diferença(s) entre os modificadores de acesso `private`, `default` `protected` e `public` em Java.

   `private` - ***Acessível apenas dentro da classe***
   
   `default` - ***Acessível a todos que estão dentro do mesmo pacote.***
   
   `protected` - ***Acessível para a classe e para seus filhos que estão dentro do mesmo pacote.***
   
   `public` - ***Acessível para todos.***

11. Qual a ordem correta dos itens abaixo, considerando a estrutura de um arquivo Java onde há somente uma importação e uma classe vazia? (considere * como _wildcard_)

   ```java
   // 1

   // 2

   // 3
   ```

   1. `package *;`, `imports *;` e `class * {}`;
   2. ***`package *;`, `import *;` e `class * {}`;***
   3. `pack *;`, `imports *;` e `class * {}`;
   4. `pack *;`, `import *;` e `class * {}`;

12. Explique o que é FQN (Fully Qualified Name), sua estrutura e como evitamos ter de utilizá-lo sempre que referenciamos uma classe.

   ***É o nome completo por exemplo da classe e é composta pelo pacote + nome da classe, exemplo: "br.com.eive.Pessoa", para evitar ter que utiliza-lo é necessário realizar o "import" do pacote.***

13. O que é, para que serve, como adquirir e como utilizar um arquivo JAR?

   ***É um arquivo compactado com todos os arquivos que compoem a bliblioteca ou então a aplicação java desenvolvida. Quando bliblioteca basta adiciona-la ao projeto, quando aplicação ao executar via comando passando o nome do JAR como argumento antes do nome da aplicação.***

14. O que é o pacote `java.lang` e por que ele é tão essencial para qualquer código Java?

   ***É o pacote que possue os recursos basicos para o desenvolvimento de qualquer aplicação em Java. Nele se econtra as classes "Object", "Class", "System", etc.***

15. O que é uma `CharSequence` e qual(is) a(s) diferença(s) entre ela e uma `String`?

   `CharSequence` - ***É uma interface***
   
   `String` - ***Implementa "CharSequence" e é imutável.***

16. Descreva os métodos da classe String citados abaixo:

    1. `.replace(char oldChar, char newChar);`
       ***Troca o caractere informado no "oldChar" pelo que foi informado no "newChar".***
    2. `.replaceAll(String regex, String replacement)`;
       ***Troca os caracteres que atendem a expressão regular contida em "regex" pela string contida em "replacement".***
    3. `.toLowerCase()`;
       ***Retorna a string em minusculo.***
    4. `.concat(String str)`;
       ***Concatena a string com o valor passado em "str".***
    5. `.contains(CharSequence s)`;
       ***Retorna "true" caso o conteúdo repassado em "s" exista na string.***
    6. `.equals(Object anObject)`;
       ***Retorna "true" caso os objetos sejam os mesmos.***
    7. `.equalsIgnoreCase(String anotherString)`;
       ***Retorna true caso o conteúdo da string seja identico desconsiderando maiusculas e minusculas.***
    8. `.isBlank()`;
       ***Retorna "true" caso a string seja vazia.***
    9. `.matches(String regex)`;
       ***Retorna "true" caso a expressão regular seja atentida.***

17. Qual(is) a(s) diferença(s) entre `overriding` e `overloading` de métodos? Explique-os dando exemplos úteis da aplicação de ambos.

   `overriding` - ***Quando a implementação do método é reescrita para atender a necessidade da classe.***
   ```java
      public abstract class Mamifero {
	     public abstract void fazerSom();
      }
      
      public class Cachorro extends Mamifero {
	     @Override
	     public void fazerSom() {
	        System.out.println("Woof woof");
	     }
      }
   ```
   
   `overloading` - ***Quando existe a necessidade de haver metodos com o mesmo nome porém com implementação distintas, tendo diferença na declaração dos paramentros que compoem a chamada.***
   ```java
   public class Cachorro {
      public void buscar(String brinquedo) {
      }
   	
      public void buscar(Object jornal) {
      }
   }   
   ```

18. Todas as classes Java herdam a classe `Object`, que possui três métodos comumente sobrescritos: `.equals(Object obj)`, `.hashCode()` e `.toString()`. Explique a utilidade de cada um deles.

   `.equals(Object obj)` - ***Valida se os objetos são iguais.***

   `.hashCode()` - ***Implementa um código que define a unicidade do objeto.***

   `.toString()` - ***Retorna o objeto como uma string.***

19. Qual(is) das opções expressa(m) uma sintaxe correta para criar um *array* de inteiros?

    1. `int[] inteiros = []`;
    2. `int[] inteiros = new int[]`;
    3. `int[] inteiros = new int[]{999}`;
    4. ***`int[] inteiros = new int[1]`;***
    5. `int[] inteiros = {999}`;
    6. `int... inteiros = {999}`;

20. Por que o primeiro código abaixo exibe o valor `0` no terminal, mas o segundo produz uma exceção?

    ```java
    // código 1
    class App {
        public static void main(String... args) {
            int[] inteiros = new int[1];
            System.out.println(inteiros[0]);
        }
    }
    ```

    ```java
    // código 2
    class Pessoa {
        Endereco endereco;
    }

    class Endereco {
        String cep;
    }

    class App {
        public static void main(String... args) {
            Pessoa[] pessoas = new Pessoa[1];
            System.out.println(pessoas[0].endereco.cep);
        }
    }
    ```

   ***Retorna um "NullPointerException" porque a classe "Endereco" não foi instanciada. Não criaram o objeto endereço para que o mesmo fosse acessado.***

21. Sobre *type casting*, explique:

    1. *Cast* implícito;
      ***Quando o casting é feito de forma automática pelo Java.***
    2. *Cast* explícito;
      ***Quando é necessário informar o tipo de conversão que o Java deverá executar.***
    3. `ClassCastException`;
       ***Quando ocorre erro ao realizar o casting de uma classe para outra.***

22. Explique o que é e como utilizar o `autoboxing` e o `unboxing`.

   `autoboxing` - ***Converte o tipo primitivo em seu objeto.***
   
   `unboxing` - ***Converte o objeto em seu tipo primitivo.***

23. É possível, no momento em que é executada uma aplicação em Java, passar argumentos para a mesma. Como isso pode ser feito e como podemos acessar esses argumentos dentro do código (no método `main()`)?

   ***Ao efetuar a chamado da aplicação é necessário informar os argumentos logo após o nome da mesma. Ex.: "C:>java programa Mentoria Java" onde "Mentoria" é o primeiro argumento e "Java" é o segundo argumento.***
   
   ***Para acessar esses argumentos é só utilizar o parâmetro "args" da declaração do método "main".***

24. Ao utilizar um `array`, o tamanho máximo do mesmo deve ser declarado. Por que isso não acontece quando utilizamos `ArrayList`? E qual é o limite do que essa estrutura pode armazenar?

   ***O "ArrayList" vai alocando de forma dinamica espaço na memoria para armazenar os dados, sendo o limite o ambiente onde a aplicação está rodando.***

25. Por que, no geral, o `ArrayList` costuma ser mais utilizado que `arrays` em Java?

   ***Porque o "ArrayList" possui implementações nativas que facilitam o seu manuseio e não possui uma limitação de tamanho.***

26. Por que sempre devemos optar pelo uso de `Generics` ao declarar um `ArrayList` (declaração no formato `ArrayList<{tipo}>`)?

   ***Para evitar atribuições de tipos indevidos de dados que serão controlados dentro do "ArrayList", evitando problemas de casting.***

27. Explique os métodos `.add(E e)` e `.contains(Object o)`, da interface `Collection`?

   `.add(E e)` - ***Adiciona um novo objeto a coleção.***

   `.contains(Object o)` - ***Valida se o objeto já está presente dentro da coleção.***

28. Explique as interfaces `Comparator<{tipo}>` e `Comparable<{tipo}>`.

   `Comparable<{tipo}>` - ***A classe implementa a interface para que ela possa se comparar a outro objeto.***
   
   `Comparator<{tipo}>` - ***A classe implementa a interface para que ela possa comparar dois objetos.***

29. Qual(is) a(s) diferença(s) entre as interfaces `List` e `Set`?

   `List` - ***Implementa uma lista de objetos que podem repetir e armazenam a ordem da sua posição.***
   
   `Set` - ***Implementa um conjunto de objetos que não podem ser repetidos e não guardam a ordem de sua posição.***

30. Como funciona a implementação `HashSet`? Qual a relação dela com o método `.hashCode()`?

   ***O "HashSet é implementado como uma tabela hash usando uma instância de "HashMap" como apoio.***
   
   ***O ".hashCode" é quem define a unicidade dos itens que compoem o set.***

31. Por que é recomendado que o *overriding* dos métodos `.equals(Object obj)` e `.hashCode()` seja realizado sempre em pares (ao sobreescrever um, o outro também deve ser sobreescrito)?

   ***Para que seja possivel manter a unicidade do objeto, o metodo "equals" utiliza o metodo "hashCode" para validar se o objeto passado via parametro é o mesmo que está efetuando a validação.***

32. Qual é a estrutura de uma expressão *lambda*, em Java? Explique e dê um exemplo, em código.

   ***Segue a seguinte estrutura "(argumento) -> (corpo)", onde o argumento é os parametros de entrado do método e o corpo a implementação do método que será executado.***
   ```java
      import java.util.ArrayList;
      import java.util.List;
 
      public class programa {
         public static void main(String... args) {
	        List<Integer> lista = new ArrayList<Integer>();
            lista.add(1);
            lista.add(2);
            lista.add(3);
            lista.add(4);
            lista.forEach(n -> System.out.println(n));
         }
      }   
   ```

33. Qual é a estrutura de uma expressão *lambda* utilizando *method reference*, em Java? Explique e dê um exemplo, em código.

   ***"Classe::metodo" onde "Classe" é o nome da classe e "metodo" o nome do metodo que será utilizado.***
   ```java
      import java.util.ArrayList;
      import java.util.List;      
      
      public class programa {
         public static void main(String... args) {
            List<Integer> lista = new ArrayList<Integer>();
            lista.add(1);
            lista.add(2);
            lista.add(3);
            lista.add(4);
            lista.forEach(System.out::println);
         }
      }   
   ```

34. Qual é a estrutura de uma `stream`, em Java? Explique e dê um exemplo, em código.

   ***É uma forma de trabalhar de forma mais facil com coleções no java.***
   
   ***No exemplo abaixo a lista é transformada em uma stream, aplicado um filtro para trazer apenas números pares e no final o resultado é impresso em tela.***
   ```java
   import java.util.ArrayList;
   import java.util.List;

   public class programa {
	    public static void main(String... args) {
         List<Integer> lista = new ArrayList<Integer>();
         lista.add(1);
         lista.add(2);
         lista.add(3);
         lista.add(4);
         lista.stream()
	         .filter(e -> e % 2 == 0) // filtra numeros pares
	         .forEach(System.out::println);
      }
   }   
   ```

35. O que falta no código abaixo para ser considerado um teste útil?

    ```java
    // package & imports
    class CalculadoraTest {

    	@Test
    	public void deveSomarDoisValores() {
            Calculadora calculadora = new Calculadora();
            int resultado = calculadora.somar(2, 2);
    	}

    }
    ```

   ***Está faltando a implementação do "assertEquals" para retorna o sucesso ou não da realização do teste.***

36. Como é aplicado o TDD? Qual(is) benefício(s) ele traz e quando devemos utilizá-lo?

   ***O teste é implementado antes da funcionalidade.***
   
   ***Beneficios:***
   ***Focar em problemas especificos no desenvolvimento;***
   ***Criar codigos mais objetivos e de facil refatoração;***
   ***Facilidade em encontrar bugs no cliclo de desenvolvimento;***

37. Quais métodos podemos utilizar para validar o lançamento de exceções em testes automatizados?

   `assertThrows` - ***Para validar se o retorno é a exceção esperada pelo teste.***
