package control;

import java.io.IOException;

import model.Access;
import android.content.Context;
import android.util.Log;


public class Set_setting extends File_IO  {
	
	public Set_setting(){}

	
	public int read_type_file(Context cotx) {
			String []  csv_row = new String[100];
			
			Access access = new Access(cotx);
			access.del_type();
			int id_counter = 1 ; 
		    try {
				csv_row = this.readFromFile(Vars.Type_path);
				int i = 0;
		        while ( csv_row[i] != null ) {
		        	String[] column = csv_row[i].split(",");
		    		int parent_id = id_counter ;
		        	access.insert_type(column[0], "0" , String.valueOf(id_counter));
		        	id_counter++; 
		        	for(int j = 1 ; j< column.length ; j++ ){
		        		access.insert_type(column[j], String.valueOf(parent_id) , String.valueOf(id_counter));
		        		id_counter++; 
		        	}
		        	i++;
		        }
		        
		        return 1 ; 
			} catch (IOException e) {
				String error_log = "SetupParams_IO; read_from_file; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
				Log.e("error", error_log);
				e.printStackTrace();
				return 12; // unable to open file
			}
		    
		}	
		        	
	public int read_company_file(Context cotx) {
		String []  csv_row = new String[100];
		
		Access access = new Access(cotx);
		access.del_Company(); 
	    try {
			csv_row = this.readFromFile(Vars.Company_path);
			int i = 0;
	        while ( csv_row[i] != null ) {
	        	String[] column = csv_row[i].split(",");
	        	access.insert_company(column[i]);
	          	i++;
	        }
	        
	        return 1 ; 
		} catch (IOException e) {
			String error_log = "SetupParams_IO; read_from_file; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
			Log.e("error", error_log);
			e.printStackTrace();
			return 12; // unable to open file
		}
	    
	}	
	
	public int read_application_file(Context cotx) {
		String []  csv_row = new String[100];
		
		Access access = new Access(cotx);
		access.del_application();
		int id_counter = 1 ; 
	    try {
			csv_row = this.readFromFile(Vars.Application_path);
			int i = 0;
	        while ( csv_row[i] != null ) {
	        	String[] column = csv_row[i].split(",");
	    		int parent_id = id_counter ;
	        	access.insert_Application(column[0], "0" , String.valueOf(id_counter));
	        	id_counter++; 
	        	for(int j = 1 ; j< column.length ; j++ ){
	        		access.insert_Application(column[j], String.valueOf(parent_id) , String.valueOf(id_counter));
	        		id_counter++; 
	        	}
	        	i++;
	        }
	        
	        return 1 ; 
		} catch (IOException e) {
			String error_log = "SetupParams_IO; read_from_file; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
			Log.e("error", error_log);
			//SensorInterfaceEngine.updateLogFile(error_log);
			e.printStackTrace();
			return 12; // unable to open file
		}
	    
	}	
	
	public int read_ancill_file(Context cotx) {
		String []  csv_row = new String[100];
		
		Access access = new Access(cotx);
		access.del_type();
		int id_counter = 1 ; 
	    try {
			csv_row = this.readFromFile(Vars.Ancill_path);
			int i = 0;
	        while ( csv_row[i] != null ) {
	        	String[] column = csv_row[i].split(",");
	    		int parent_id = id_counter ;
	        	access.insert_type(column[0], "0" , String.valueOf(id_counter));
	        	id_counter++; 
	        	for(int j = 1 ; j< column.length ; j++ ){
	        		access.insert_type(column[j], String.valueOf(parent_id) , String.valueOf(id_counter));
	        		id_counter++; 
	        	}
	        	i++;
	        }
	        
	        return 1 ; 
		} catch (IOException e) {
			String error_log = "SetupParams_IO; read_from_file; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
			Log.e("error", error_log);
			//SensorInterfaceEngine.updateLogFile(error_log);
			e.printStackTrace();
			return 12; // unable to open file
		}
	    
	}	



	
}
