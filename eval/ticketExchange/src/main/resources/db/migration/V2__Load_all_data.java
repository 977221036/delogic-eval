package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import br.com.delogic.ticketExchange.migration.flyway.BaseFileMigrationUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;




public class V2__Load_all_data extends BaseJavaMigration {
	
	String USERS_FILE = "/data/users.txt";
	String CATEGORIES_FILE = "/data/categories.txt";
	String VENUES_FILE = "/data/venues.txt";
	String EVENTS_FILE = "/data/events.txt";
	String LISTINGS_FILE = "/data/listings.txt";
	String SALES_FILE = "/data/sales.txt";
	String DATES_FILE = "/data/dates_2008.txt";
	
	
	
	
	String SEPARATOR_PIPE = "\\|";
	String SEPARATOR_TAB  = "\t";
	
	
		@Override
	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		 
		loadUsers(context);		
		loadCategories(context);	
		loadVenues(context);
		loadDates(context);
		loadEvents(context);
		loadListings(context);
		loadSales(context);
		
		
	}


		private void loadSales(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(SALES_FILE,this);
			System.out.println("**** MIGRATE Load Sales ******");
			
			
				    	
			String firstPartSQL = "INSERT INTO sales "+ 
				       "(id,listing_id,seller_id,buyer_id,event_id,"
				       + "date_id,quantity_sold,price_paid,commission_amount,sale_time)"+
				       " VALUES "+
				        "(?,?,?,?,?,?,?,?,?,?);";
			String[] types = {"K","K","K","K","K","I","I","N","N","T"};  
			
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_TAB, types);
			}
		}


		private void loadListings(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(LISTINGS_FILE,this);
			System.out.println("**** MIGRATE Load Listings ******");
			
			

				    	
			String firstPartSQL = "INSERT INTO listings "+ 
				       "(id,seller_id,event_id,date_id,"
				       + "number_of_tickets,price_per_ticket,total_price,listing_time)"+
				       " VALUES "+
				        "(?,?,?,?,?,?,?,?);";
			String[] types = {"K","K","K","K","I","N","N","T"};  
			
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


		private void loadEvents(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(EVENTS_FILE,this);
			System.out.println("**** MIGRATE Load Events ******");
			
				    	
			String firstPartSQL = "INSERT INTO events "+ 
				       "(id,venue_id,category_id,date_id,name,event_start)"+
				       " VALUES "+
				        "(?,?,?,?,?,?);";
			String[] types = {"K","K","K","K","S","T"};  
			
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


		private void loadDates(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile( DATES_FILE,this);
			System.out.println("**** MIGRATE Load Dates ******");
			
			
				    	
			String firstPartSQL = "INSERT INTO dates "+ 
				       "(id,date,day,week, month,quarter,year,holiday)"+
				       " VALUES "+
				        "(?,?,?,?,?,?,?,?);";
			String[] types = {"K","D","S","I","S","I","I","B"}; 
			
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


		private void loadVenues(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(VENUES_FILE,this);
			System.out.println("**** MIGRATE Load Venues ******");
				    	
			String firstPartSQL = "INSERT INTO venues "+ 
				       "(id,name,city,state, seating_capacity)"+
				       " VALUES "+
				        "(?,?,?,?,?);";
			String[] types = {"K","S","S","S","I"}; 
			 
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


		private void loadCategories(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(CATEGORIES_FILE,this);
			System.out.println("**** MIGRATE Load Categories ******");
			
			
			
			String firstPartSQL = "INSERT INTO categories "+ 
				       "(id,group_name,name,description)"+
				       " VALUES "+
				        "(?,?,?,?);";
			String[] types = {"K","S","S","S"}; 
			
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


		private void loadUsers(Context context) throws SQLException {
			List<String> lines = BaseFileMigrationUtil.readFile(USERS_FILE,this);
			System.out.println("**** MIGRATE Load Users ******");
			
			
			String firstPartSQL = "INSERT INTO users "+ 
				       "(id,username,firstname,lastname,city,state,email,phone,"+
				        "sports,theatre,concerts,jazz,classical,opera,rock,vegas,broadway,musicals)"+
				       " VALUES "+
				        "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			String[] types = {"K","S","S","S","S","S","S","S","B","B","B","B","B","B","B","B","B","B"}; 
			 
			try (PreparedStatement insert = context.getConnection().prepareStatement(firstPartSQL)) {
				
				BaseFileMigrationUtil.executeSQLStatements(insert, lines, SEPARATOR_PIPE, types);
			}
		}


}
