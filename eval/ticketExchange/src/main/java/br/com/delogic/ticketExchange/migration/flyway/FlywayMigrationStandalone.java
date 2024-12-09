package br.com.delogic.ticketExchange.migration.flyway;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

/*
 Helper to run a standalone migration
  
 */

public class FlywayMigrationStandalone {
	
	final static String PROPERTIES_FILE =  "src/main/resources/application.properties";  
	final static String TEST_PROPERTIES_FILE =  "src/main/resources/application-test.properties";
	
	
    public static void main(String[] args) throws IOException {
     	
        doMigration();    
    
    }
    
    public static void doMigration() throws FileNotFoundException, IOException {
    	
    	doBaseMigration(PROPERTIES_FILE);
    	
    }


	private static void doBaseMigration(String propertiesFileName) throws IOException, FileNotFoundException {
		Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(propertiesFileName)) {
            // Load the property file
            properties.load(fis);

            // Retrieve properties using their keys
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");
            String url = properties.getProperty("spring.datasource.url");
                       
 
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
}
