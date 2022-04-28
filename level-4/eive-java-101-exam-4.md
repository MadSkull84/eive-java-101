# Prova Modulo 4

## Docker / Postgres

  - Faça o clone do projeto `https://github.com/spring-projects/spring-petclinic.git`.
  - Crie o `dockerfile` necessário para a construção e execução do projeto, considere que o projeto utilizará o `spring.profiles.active` de postgres.
  ***docker/Dockerfile***
  - Configure o projeto para que a pasta `target` seja ignorada pelo docker ao construir a imagem.
  ***docker/.dockerignore***
  - Construa o projeto utilizando a seguinte tag: `eive-java-exam-4:prod`.
  - Suba a imagem para o docker hub e vincule a URL da imagem na atividade.
  ***https://hub.docker.com/r/madskull84/eive-java-exam-4***
  - Vincule o comando necessário para rodar o container da imagem criada considerando que ela será baixada do docker hub e conectará no postgres.
  ***docker pull madskull84/eive-java-exam-4:prod***
  ***docker run --name petclinic -d -p 8080:8080 -e POSTGRES_URL=jdbc:postgresql://192.168.0.158:5432/petclinic -e POSTGRES_USER=petclinic -e POSTGRES_PASS=petclinic eive-java-exam-4:prod***
    - Atenção: as credenciais de acesso ao banco devem ser informadas através de variáveis de ambiente.

## MongoDB

  - Faça o clone do respositório `https://github.com/mcampo2/mongodb-sample-databases.git`.
  - Importe o `dataset` localizado em `sample_airbnb` (mongoimport - MongoDB Database Tools).
  - Realize as seguintes operações (utilizar `mongosh` e vincular as _queries_ executadas):
    - Inserir um novo registro de imóvel para aluguel conforme estrutura já existente.
    ***[mongodb/insert_command.txt](./mongodb/insert_command.txt)***
    - Alterar o valor do preço diário (`price`) para `500` do registro incluído.
    ***[mongodb/update_command.txt](./mongodb/update_command.txt)***
    - Informar apenas o valor do apartamento com diária (`price`)  mais cara disponível no Brasil (`BR`) sem retornar o campo `_id`.
    ***[mongodb/find_command.txt](.mongodb/find_command.txt)***
