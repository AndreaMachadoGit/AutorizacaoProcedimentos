# Controle de Autorizações de Procedimentos 

Projeto para processo seletivo Java Back-End da Qualirede.

Você é o desenvolvedor responsável por um sistema de controle de autorizações de procedimentos médicos para um plano de saúde.  

#### Objetivo

Através de um serviço REST, crie os endpoints para registro das regras de autorização e das solicitações de autorização 

#### API  
#### Tecnologia : 

 Rest API, Spring Boot, Spring Security, Maven, Swagger, JPA

#### Premissas : 

Os critérios para permitir a execução de um procedimento são idade e sexo.
Procedimentos não listados na tabela devem ser negados.

#### Exemplos:
     
Entrada:
/autorizador/cadastro/procedimento/1234/idade/10/sexo/M/autoriza/SIM

/autorizador/cadastro/procedimento/1234/idade/10/sexo/F/autoriza/NAO

Saída:
  	HTTP 200
     
Entrada:
  	/autorizador/procedimento/1234/idade/10/sexo/M
Saída:
  	SIM
     
     
### Requisitos obrigatórios :
     - Utilizar serviços REST para o cadastro e validação dos procedimentos de autorização
     - Entregar a documentação necessária para compilar (colocar no readme do repositório)
     - Criar a estrutura de banco de dados proposta para o problema
     - Usar git para armazenar o fonte (usar um git publico e enviar a URL)
     - Usar o Maven para fazer o build
     
### Requisitos desejáveis :
     - Contruir testes unitários
     - Utilizar docker na solução
   

#### Informações para o client acessar a API :
- #### URI de acesso : https://autorizacao-procedimento.herokuapp.com/
- #### Documentção da Api:  https://autorizacao-procedimento.herokuapp.com/swagger-ui.html#
- #### Banco de Dados : h2 em memória 
