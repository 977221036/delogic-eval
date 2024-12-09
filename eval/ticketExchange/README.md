# Parte 1 Schema e Migração

### Notas 

Foi utilizada uma classe java para a leitura dos arquivos texto e posterior gravação no Banco de Dados. 

Há duas formas de executá-la: 

1) Uma classe java isolada que executa o Flyway (FlywayMigrationStandalone). 

2) Componente dentro da arquitetura Spring (FliwayMigration) que utiliza o Datasource definido no Build.Gradle  

Obs: Essa implementação dispensa o comando específico LOAD DATA INFILE que no MYSQL possui algumas questões de permissão 


# Parte 2 POJOS e Junit

### Notas 

Implementandos os POJOS assim como os Repositories porem devido a problemas no ambiente foi perdido muito tempo para execução dos testes o que levou a não finalização das Partes 3 e 4 no tempo proposto. 





   