package br.com.delogic.ticketExchange.migration.flyway;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.flywaydb.core.Flyway;

/*
 Helper to run a standalone migration
  
 */

public class FlywayMigrationStandalone {
	
		
    public static void main(String[] args) throws IOException {
     	
        doMigration();    
    
    }
    
    public static void doMigration() throws FileNotFoundException, IOException {
    	
    	doBaseMigration();    	
    }


	private static void doBaseMigration(){
      
                    
        	String url = System.getenv("DATABASE_URL");
        	String username = System.getenv("DATABASE_USER");
        	String password = System.getenv("DATABASE_PASSWORD");      	
                       
 
            // Print the retrieved properties            
            System.out.println("Datasource: " + url);
            
            // Configure Flyway
            Flyway flyway = Flyway.configure()
                    .dataSource(url, username, password)   // Replace with your database URL, user, and password
                    .locations("classpath:db/migration")                
                    .load();
            
            // Run migrations
            flyway.migrate();

            System.out.println("All Migrations executed.");
            
        
	}
}
