# Parte 1 Schema e Migração

### Notas 

Foi utilizada uma classe java para a leitura dos arquivos texto e posterior gravação no Banco de Dados. 

Há duas formas de executá-la: 

1) Uma classe java isolada que executa o Flyway (FlywayMigrationStandalone). 

2) Componente dentro da arquitetura Spring (FliwayMigration) que utiliza o Datasource definido no Build.Gradle  

Obs: Essa implementação dispensa o comando específico LOAD DATA INFILE que no MYSQL possui algumas questões de permissão 


# Parte 2 POJOS e Junit

### Notas 

Implementandos os POJOS assim como os Repositories porem devido a problemas no ambiente foi perdido muito tempo para execução dos testes em Junit/Mockito.  

Foram criadas as entidades User, Category, Date , Venue, Event , Listing e Sale

# Parte 3 Endpoints  
  
Implementados os Endpoints porem devido aos problemas no Junit/Mockito não foram implementados os casos de teste para os Controllers. 

Os endpoints utilizam como mapping o nome das entidades definidas no passo 2 em caixa baixa com a seguinte regra: 
  
##### Endpoint Exemplo Listagem:     /rest/v1/<entidade>?page=0&size=20&sort=id,asc
##### Endpoint Exemplo Dados (id):   /rest/v1/<entidade>/1

##### Exemplo: /rest/v1/user?page=0&size=20&sort=id,asc    

###### Obs1: Entidades: User, Category, Date , Venue, Event , Listing e Sale

###### Obs2: Os endpoints de Listagens utilizam a paginação default do Spring. 


# Parte 4 Endpoint Promocional 

Implementado o Endpoint promocional utilizando controlador específico para esse fim. Utilizada query HQL no Repositório de Listagens.  Porém devido aos problemas no Junit/Mockito não foram implementados os casos de teste para o Controller. 

##### Endpoint Exemplo (Metodo GET):   /rest/v1/promotional?contextualDate=2008-12-01%2000:00:00&cityName=New%20York%20City&categoryId=7


 




   