# Parte 1 Schema e Migração

### Notas 

Foi utilizada uma Java Based Migration para a leitura dos arquivos texto e posterior gravação no Banco de Dados. 

Há duas formas de executá-la: 

1) Uma classe Java isolada que executa o Flyway (*FlywayMigrationStandalone*) utilizando-se as configurações de variáveis de ambiente para conexão com a base de dados. 

2) Componente dentro da arquitetura Spring (*FlywayMigration*) que utiliza o Datasource definido no Build.Gradle  (que também utiliza as configurações de variáveis de ambiente para conexão com a base de dados )

> **Obs1**: Essa implementação dispensa o comando específico LOAD DATA INFILE  do MYSQL , que em determinados casos possui algumas questões de permissão de arquivo. 

> **Obs2**: Instruções de como executar a migração estão em MIGRATION_STEPS.md


# Parte 2 POJOS e Junit

### Notas 

Foram implementados os POJOS assim como os Repositories porém devido a problemas no ambiente foi perdido muito tempo para confecção e execução dos testes em Junit/Mockito.  

Foram criadas as entidades *User*, *Category*, *Date* , *Venue*, *Event* , *Listing* e *Sale* assim como seus respectivos testes de repositório. 

# Parte 3 Endpoints  
  
Implementados os *Endpoints* porem devido aos problemas no *Junit*/*Mockito* mencionados no item anterior foram implementados só os testes básicos para os *Controllers*.  No mapeamento de *DTO* para *entidade* utilizou-se o framework *ModelMapper* (*org.modelmapper.ModelMapper*). 

Os endpoints utilizam o nome das entidades definidas no passo 2 em caixa baixa em seus respectivos *RequestMappings* com a seguinte regra de formação: 
  
##### Endpoint Exemplo Listagem:     /rest/v1/<entidade>?page=0&size=20&sort=id,asc
##### Endpoint Exemplo Dados (id):   /rest/v1/<entidade>/1

##### Exemplo: /rest/v1/user?page=0&size=20&sort=id,asc    
###### Obs: Entidades: User, Category, Date , Venue, Event , Listing e Sale

Os endpoints utilizam a paginação default do Spring (*page, size e sort*). 


# Parte 4 Endpoint Promocional 

Implementado o *Endpoint* promocional utilizando um controlador específico para esse fim (*PromotionalControler*).  Utilizada uma query HQL no Repositório de Listagens.  Porém devido aos problemas no Junit/Mockito somente foi implementado um caso de teste básico para o *Controller*. 

Os parâmetros de chamada são:
>*contextualDate*: data no formato  "yyyy-MM-dd  HH:mm:ss"  (obrigatório)
*cityName*:  nome da cidade  (opcional)
*categoryId*: id da categoria  (opcional)

##### Endpoint Exemplo (Metodo GET):   /rest/v1/promotional?contextualDate=2008-12-01%2000:00:00&cityName=New%20York%20City&categoryId=7

>*Obs*: Espaços devem ser convertidos para entidade HTML -> *%20*)


