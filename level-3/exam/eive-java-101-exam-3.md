1) No Maven o arquivo `pom.xml` é o principal arquivo de configuração de dependencias. Sabendo disso leia as afirmativas abaixo.

I - A dependências podem ser adicionadas diretamente na pasta lib do projeto e este após compilar continua reconhecendo.
II - A dependências seguem um padrão de organização, sempre devem ser adicionadas na sessão `<dependencies>` do arquivo.
III - Sempre que uma nova depenência é adicionada no projeto o `Mavem` identifica e baixa de forma altomatica sem que o desenvolvedor precise se preocupar.

Assinale a alternativa que corresponte apenas as informações verdadeiras.

- [ ] III, apenas
- [ ] I e II
- [ ] I e III 
- [X] II e III
- [ ] I, II e III


2) No `Maven` existem alguns comandos que são conhecidos como `goal`, com base no seu conhecimento, leia as afirmativas abaixo e assinale a alternativa correta

I - O comando `mvn test` tem como finalidade executar os testes do projeto
II - O comando `mvn deploy production` é usado quando precisa gerar o artefado para o ambiente de produção
III - `mvn install` é o goal que realiza a instalação do projeto no diretório local

- [ ] I, apenas
- [ ] II apenas
- [ ] I e II apenas
- [X] I e III apenas
- [ ] II e III, apenas

 
3) Supondo que existe um banco de dados onde neste banco de dados existe uma tabela com o nome `Produto` e nesta tabela temos dois registros: 
 
 ID = 1
 NOME = TELEVISÃO
 DESCRICAO = TV 52"

 ID = 2
 NOME = RÁRIO
 DESCRICAO = RÁDIO AM/FM

 Dado o seguinte código, qual o resultado é impresso no console?
```java
  
  Statement stmt = connection.createStatement();
  stmt.execute("Select id, nome, descricao From Produto");
  ResultSet rst = stmt.getResultSet();

  while(rst.next()){
      System.out.print(rst.getInt("id"));
      System.out.print(rst.getString("nome"));
      System.out.print(rst.getString("descricao"));
      System.out.println("");
  }
  connection.close();
  
```

```
1TELEVISÃOTV 52"
2RÁRIORÁDIO AM/FM
```

4) Veja o comando abaixo, como ele poderia ser adaptado para imprimir o código gerado na inclusão do registro?
```java
  Statement stmt = connection.createStatement();
  stmt.execute("INSERT INTO Produto VALUES ('Cadeira', 'Cadeira 4 pernas')");  
```

```java
		Statement stmt = connection.createStatement();
		stmt.execute("INSERT INTO produto (nome, descricao) VALUES ('Cadeira', 'Cadeira 4 pernas')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rstg = stmt.getGeneratedKeys();
		while(rstg.next()) {
			Integer id = rstg.getInt(1);
			System.out.println("Id do produto criado = " + id);
		}
```

5) Oque é um pool de conexão e qual sua vantagem? Explique.

***É uma camada intermediaria responsavel com criar, fechar e alocar as conexões para a aplicação, controlando também um número maximo de conexões ativas.***
***Vantagens: Evita o tempo gasto para abrir e fechar conexões, já que aproveita conexões abertas e que não estão sendo utilizadas. E permite controlar a quantidade de conexões reais que existiram entre a aplicação e o servidor de banco de dados.***

6) De um exemplo de uso de pool de conexão usando a biblioteca c3p0

```java
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestaPoolC3P0 {

	public static void main(String[] args) throws SQLException {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");

		comboPooledDataSource.setMaxPoolSize(15);

		DataSource dataSource = comboPooledDataSource;		
		
		for (int i = 0; i < 20; i++) {
			dataSource.getConnection();
			System.out.println("Conexão de número : " +i);
		}		
	}

}
```

7) Quais as desvantagens de usar o JDBC em uma aplicação?

***Código muito verboso e de difícil manutenção.***
***Alto acoplamento com o banco de dados.***

8) Explique de forma suscinta como funciona o cliclo de vida de uma aplicação JPA

***Quando instanciada uma entidade a mesma se encontra no estado de "transient" um estado que ainda não é gerenciado pela JPA, nada do que for alterado será pesistido no banco.***
***Ao chamar "persist" a entidade passa a ser gerenciada pela JPA, ficando em "managed".***
***Ao chamar "commit"\"flush" a entidade é sincronizada com o banco de dados. Fazendo as inserções, alterações e exclusões das entidades que estão em "managed".***
***Ao chamar "close"\"clear" a entidade fica em "detached", situação na qual a JPA não aplicará as alterações da entidade no banco de dados.***

9) Sobre JPA explique a diferença entre o uso da importação de `javax.persistence.Entity` e `org.hibernate.annotations.Entity`

***`javax.persistence.Entity` - é a anotação da expecificação da JPA.***
***`org.hibernate.annotations.Entity` - é a anotação do Hibernate.***
***Usando a expecificação da JPA ficamos livres para usar outras implementações que não seja a do Hibernate***

10) Dado a estrutura de uma tabela `Carros`, escreva como seria o mapeamento em JAVA usando o JPA 

```SQL
   Create Table Cores(
      ID_COR INT auto_increment,
      NOME VARCHAR(50),
      PRIMARY KEY(ID_COR)
   );

   Create Table Carros(
      ID_CARRO INT auto_increment,
      MARCA VARCHAR(50),      
      MODELO VARCHAR(50),
      PLACA VARCHAR(10),
      ID_COR INT,
      PRIMARY KEY(ID_CARRO)
   );

   ALTER TABLE Carros ADD FOREIGN KEY(ID_COR) REFERENCES Cores (ID_COR);
```

```java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cores")
public class Cor {
	
	@Column(name = "id_cor")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer id;
    private String nome;
    
    public Cor() {
    }
}
```
```java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carros")
public class Carro {

	@Column(name = "id_carro")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	private String placa;
	
	@ManyToOne
	private Cor cor;
	
	public Carro() {
	}
}
```

11) Sobre o ciclo de vida de uma Entidade, Explique cada um dos estados `TRANSIENT`, `MANAGED` e `DETACHED`.

***`TRANSIENT` - Estado onde a entidade instanciada ainda não é gerenciada pela JPA.***
***`MANAGED` - Estado onde a entidade está sendo gerenciada pela JPA.***
***`DETACHED` - Estado onde a entidade que foi sincronizada com o banco de dados não está mais sendo gerenciada pela JPA e caso sofra novas alterações as mesmas não serão sincronizadas com o banco de dados.***

12) Qual a finalidade do método `merge()` no JPA. Escreva um exemplo simples para mostrar seu uso.

***Devolve uma nova referencia da entidade no estado de "managed".***
```java
import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Cor;
import br.com.alura.loja.util.JPAUtil;

public class TestaMerge {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Cor preto = new Cor("preto");
		
        em.persist(preto);
        preto.setNome("Azul");    

        em.flush();
        em.clear();

        preto = em.merge(preto);
        preto.setNome("Vermelho");
        em.flush();
	}
}
```

13) Usando a sintaxe JPQL como poderia ser adaptado o código abaixo para listar todos os dados da tabela `Carros`

```java

  public Lista<Carro> findAll(){
    return null;
  }
```

```java
	public List<Carro> buscarCarros() {
		String jpql = "SELECT c FROM carro c";
		return em.createQuery(jpql, Carro.class).getResultList();
	}
```
   
14) Usando a sintaxe JPQL avalie o código abaixo e sinalize quais pontos estão errados no código

```java
  public Lista<Pessoa> findById(Long id) {
      String consulta = "Select * from Pessoas P Where P.ID_PESSOA = ?";
      entityManager.createStatement(consulta);
      return entityManager.createQuery(consulta, Pessoa.class)
         .setParameter(1, 1)
         .getResultList(); 
  } 
```

***No SQL, deve respeitar o nome da classe e seus atributos e a passagem de parametros devem possuir os indices "?1".***
***Não existe o "createStatement" no "entityManager", a linha deve ser removida.***

15) Qual a função do `mappedBy` e onde ele deve ser usado?

***Serve para indicar que o relacionamento entre as entidades é bidirecional.***

16) Escreva um exemplo de como fazer um `JOIN` no JPQL?

```java
	public List<Carro> buscarPorNomeCor(String nomeCor) {
	      String consulta = "Select c from Carro c Where c.cor.nome = :nome";	      
	      return em.createQuery(consulta, Carro.class)
	         .setParameter("nome", nomeCor)
	         .getResultList(); 		
	}
```

17) Qual a função do `select new` no JPA?

***Retorna o objeto ou lista de objetos de acordo com a classe repassada junto ao comando "new".***

18) Considerando que no seu projeto tem a seguinte estrutura de pacotes:
```java
  br.com.curso.modelo
         Carro.java
         Cores.java
  br.com.curso.dao
         CarroDao.java
         CoresDao.java
```

  Escreva um método que exemplifique uma consulta usando `select new` do JPA, descreva se precisa de novas classes e se for preciso onde cada uma delas deve ser organizada no projeto seguindo as boas praticas.

```java
	public List<RelatorioQtdCarrosPorCorVo> relatorioQtdCarrosPorCorVo() {
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioQtdCarrosPorCorVo("
				+ "cc.nome, "
				+ "COUNT(c)) "
				+ "FROM Carro c "
				+ "JOIN c.cor cc "
				+ "GROUP BY cc.nome ";
		return em.createQuery(jpql, RelatorioQtdCarrosPorCorVo.class)
				.getResultList();
	}
```

***Sim é necessário criar uma nova classe "RelatorioQtdCarrosPorCorVo" e a mesma foi adicionada no pacote "br.com.alura.loja.vo".***

19) Sobre a configuração de conexão com banco de dados no Spring leia as afirmativas abaixo:

I. Para conexão com o banco de dados é necessário apenas adicionar as dependências no arquivo `pom.xml`
II. As configurações de acesso ao banco de dados devem ficar no arquivo `application.propriedades`
III. A definição em `spring.jpa.hibernate.ddl-auto=update` é usada para dar atualizar as informações do banco de dados

Assinale apenas as alternativas que correspondem a afirmações verdadeiras

- [ ] I, apenas
- [ ] I e II, apenas
- [ ] II e III, apenas
- [ ] I, II e III
- [X] nenhuma das afirmativas

***Considerando que não há erro de ortografia a resposta é "nenhuma das afirmativas"***

20) Escreva um exemplo de implementação e uso de um `CrudRepository` para a classe da entidade `Cores.java`.

```java
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.alura.spring.data.orm.Cores;

@Repository
public interface CoresRepository extends CrudRepository<Cores, Integer> {
}
```

```java
import org.springframework.stereotype.Service;
import br.com.alura.spring.data.orm.Cores;
import br.com.alura.spring.data.repository.CoresRepository;

@Service
public class CrudCoresService {
	private final CoresRepository coresRepository;
	
	public CrudCoresService(CoresRepository coresRepository) {
		this.coresRepository = coresRepository;
	}
	
	private void salvar(Cores cores) {
		coresRepository.save(cores);
	}	
}
```

21) Explique como funciona as `Derived Query` e de exemplos de métodos com o uso das opções: `E` , `OU` e `MAIOR QUE`.

***`Derived Query` - O Spring consegue gerar a partir do nome do metodo a consulta SQL.***
```java
List<Cores> findByNome(String nome);
List<Carro> findByModelAndMarca(String modelo, String marca); 
List<Pedido> findByTotalPedidoGreaterThan(BigDecimal totalPedido);
```

22) Explique qual a aplicabilidade ideal para os Repository `CrudRepository`, `PaginAndSortingRepository` e `JpaRepository`. Escreva a forma de como declarar a assinatura de cada um deles.

***`CrudRepository` - Serve para implementar o CRUD de entidades simples que não sofrem com problemas de performance.***
```java
@Repository
public interface CoresRepository extends CrudRepository<Cores, Integer> {
}
```
***`PaginAndSortingRepository` - Server para implementar consultas paginadas e ordenadas, oferecendo um melhor controle de performance.***
```java
@Repository
public interface CarroRepository extends PagingAndSortingRepository<Carro, Integer> {
}
```
***`JpaRepository` - Serve para implementar instruções de alta performance, utilizando por exemplo inserções em lote.***
```java
@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
```

23) Dado o código abaixo:
```SQL
   Create Table Cores(
      ID_COR INT auto_increment,
      NOME VARCHAR(50),
      PRIMARY KEY(ID_COR)
   );

   Create Table Carros(
      ID_CARRO INT auto_increment,
      MARCA VARCHAR(50),      
      MODELO VARCHAR(50),
      PLACA VARCHAR(10),
      ID_COR INT,
      PRIMARY KEY(ID_CARRO)
   );

   ALTER TABLE Carros ADD FOREIGN KEY(ID_COR) REFERENCES Cores (ID_COR);
```
  Escreva um exemplo de método que use uma `projeção` que exiba os dados dos carros com cor azul, os campos exibidos devem ser:
     Marca, Modelo, Placa e nome da cor

```java
	@Query(value = "SELECT c.marca, c.modelo, c.placa, cr.nome as cor FROM carros c JOIN cores cr ON c.id_cor = cr.id_cor WHERE c.id_cor = :cor", nativeQuery = true)
	List<CarrosProjecao> findCarroPorCor(Integer cor);
```
```java
public interface CarrosProjecao {
	String getMarca();
	String getModelo();
	String getPlaca();
	String getCor();
}
```

24) Explique para que servem as anotações `@Repository`, `@Service`, `@Controller`, `@SpringBootApplication`

***`@Repository` - O uso da anotação garante que o DAO ou repositórios sejam descobertos e configurados pelo ComponetScan, sem a necessidade de fornecer a configuração XML para eles.***
***`@Service` - Geralmente usado para decorar componentes da camada de serviço***
***`@Controller` - Usado para definir a classe do controlador.***
***`@SpringBootApplication` - O Spring Boot irá configurar automaticamente o programa conforme necessário.***

25) Escreva uma classe que contenha um método REST que retorna uma lista fixa de Carros, utilize o padrão DTO.

```java
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.CarroDto;

@RestController
@RequestMapping("/carros")
public class CarrosController {

	@GetMapping
	public List<CarroDto> listar() {
		
		List<CarroDto> carros = new ArrayList<CarroDto>();
		carros.add(new CarroDto("Agile", "GM", "1900"));
		carros.add(new CarroDto("Corsa", "GM", "1901"));
		carros.add(new CarroDto("Uno", "Fiat", "1902"));
		carros.add(new CarroDto("Gol", "VW", "1903"));
		
		return carros;
	}
}
```

26) Adapte seu código da atividade anterior para um modelo que usa o padrão `Repository` e retorne uma lista de Carros. 

```java
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.CarroDto;
import br.com.alura.forum.modelo.Carro;
import br.com.alura.forum.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarroRepository carroRepository;

	@GetMapping
	public List<CarroDto> listar() {
		
		List<Carro> carros = carroRepository.findAll();
		
		return CarroDto.converter(carros);
	}
}
```

27) Qual a finalidade do `Bean Validation`, Explique e de um exemplo do seu uso em código com a annotation `@Valid`  

***O `Bean Validation` é uma especificação que permite validar objetos e atributos através de anotações.***
```
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CarroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCarroForm form) {
		Optional<Carro> optional = carroRepository.findById(id);
		if (optional.isPresent()) {
			Carro carro = form.atualizar(id, carroRepository);
			return ResponseEntity.ok(new CarroDto(carro));
		}

		return ResponseEntity.notFound().build();
	}
```

```java
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Carro;
import br.com.alura.forum.repository.CarroRepository;

public class AtualizacaoCarroForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String marca;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String modelo;

	public String getTitulo() {
		return marca;
	}

	public void setTitulo(String titulo) {
		this.marca = titulo;
	}

	public String getMensagem() {
		return modelo;
	}

	public void setMensagem(String mensagem) {
		this.modelo = mensagem;
	}

	public Carro atualizar(Long id, CarroRepository carroRepository) {
		Carro carro = carroRepository.getOne(id);
		
		carro.setMarca(this.marca);
		carro.setModelo(this.modelo);
		
		return carro;
	}
	
}
```

28) Explique para que é usado a annotation `@ExceotionHandler` e de um exemplo de método que utiliza ela.

***`ExceptionHandler` - Através dessa anotação podemos interceptar o erro e trata-lo, gerando por exemplo uma resposta mais amigavel para o usuario.***

```java
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}

}
```
