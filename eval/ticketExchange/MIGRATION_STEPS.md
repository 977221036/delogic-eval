# Migration Steps 


#1) In order to run the migration you will need a running instance of MYSQL 

In this case, a schema called 'delogic' was created  with the following parameters in both application.properties and build.gradle:  

url = 'jdbc:mysql://localhost:3307/delogic'
user = 'root'
password = 'root'  



#2) Copy the text files to the folder src/main/resources/db/data



#3) Run the Importer Class FlywayMigrationStandalone

Notes: 
V1__Initial_schema.sql contains the DDL for tables and constraints 
V2__Load_all_data.java is a Java based migration for loading all data files into the Database

 


  

