package br.com.delogic.ticketExchange.migration.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import jakarta.annotation.PostConstruct;

/*
 Helper to run a standalone migration
  
 */ 
@Component
public class FlywayMigration {
	
   @Autowired
   private DataSource dataSource;	
	
   @PostConstruct
   public void migrate() {
        // Configurar Flyway
        Flyway flyway = Flyway.configure()
        		.dataSource(dataSource)
                .locations("classpath:db/migration")                
                .load();

        // exec migrations
        flyway.migrate();

        //TODO:Usar logger   
        System.out.println("All Migrations executed.");
    }
}
