package br.com.delogic.ticketExchange.migration.flyway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/*
  Java based Migration helper  with file reading method and 
  loading into a database  
 
  Loading uses an array of mnemonic Strings to assign a the proper java.SQL.Types 
  into a parametric query  
     
  'K' -  Bigint (Primary Key)
  'I' -  Integer
  'S' -  String
  'D' -  Date
  'T' -  TimeStamp
  'B' -  Boolean
  'N' -  Number (BigDecimal) 
 
 
*/
public class BaseFileMigrationUtil {


	public static List<String> readFile(String pathResource, Object object) {
		  List<String> lines = null;
		  try {
			    InputStream inputStream = object.getClass().getResourceAsStream(pathResource);
			    InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			    BufferedReader reader = new BufferedReader(streamReader);
			    lines = new ArrayList<String>();
			    for (String line; (line = reader.readLine()) != null;) {
			        lines.add(line);			     	
			    }
	            
	            // Print lines
	            //lines.forEach(System.out::println);	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  return lines;
	}

	public static void executeSQLStatements(PreparedStatement insert, List<String> lines, String Separator, String[] types ) throws SQLException {
		for (String line: lines) {
			String[] columnValues = line.split(Separator);
			
			/*
			for (int i = 0; i < columnValues.length; i++) {
				System.out.print(columnValues[i]);
				if(i <columnValues.length-1) {
					System.out.print(",");
				}
			}
			System.out.println();
			*/
			
			for (int i = 0; i < types.length; i++) {
				
				if(types[i].equals("K")) {
					if(i<columnValues.length) { 
					insert.setLong(i+1, Long.parseLong(columnValues[i]));
					} else {
						insert.setNull(i+1,java.sql.Types.BIGINT);
					}
				}
				
				if(types[i].equals("I")) {
					if(i<columnValues.length) { 
					insert.setInt(i+1, Integer.parseInt(columnValues[i]));
					} else {
						insert.setNull(i+1,java.sql.Types.INTEGER);
					}
				}
				if(types[i].equals("S")) {
					if(i<columnValues.length) { 
						//System.out.println("Param"+(i+1)+": "+columnValues[i]);
					insert.setString(i+1, columnValues[i]);
					} else {
						insert.setNull(i+1,java.sql.Types.VARCHAR);
					}
				}
				if(types[i].equals("B")) {
					if(i<columnValues.length) { 
					insert.setBoolean(i+1, Boolean.valueOf(columnValues[i]) );
					} else {
						insert.setBoolean(i+1, Boolean.FALSE);
					}
				}
				
				if(types[i].equals("D")) {
					if(i<columnValues.length) { 
					insert.setDate(i+1, Date.valueOf(columnValues[i]));
					} else {
						insert.setNull(i+1, java.sql.Types.DATE);
					}
				}

				
				if(types[i].equals("T")) {
					if(i<columnValues.length) { 
					insert.setTimestamp(i+1, Timestamp.valueOf(columnValues[i]) );
					} else {
						insert.setNull(i+1, java.sql.Types.TIMESTAMP);
					}
				}
				
				if(types[i].equals("N")) {
					if(i<columnValues.length) { 
					insert.setBigDecimal(i+1, BigDecimal.valueOf(Double.parseDouble(columnValues[i])));
					} else {
						insert.setNull(i+1, java.sql.Types.DECIMAL);
					}
				}
				
				

			}
		
			insert.executeUpdate();
		}
	}

	
}
