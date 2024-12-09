package br.com.delogic.ticketExchange;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.delogic.ticketExchange.migration.flyway.FlywayMigration;

@SpringBootTest
public class FlywayTestSetup {
	
	@Autowired
	DataSource dataSource;

    @BeforeAll
    void setupDatabase() {
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

    // Your tests here
}
