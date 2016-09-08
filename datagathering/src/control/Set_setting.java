package control;

import java.io.IOException;

import model.Access;
import android.content.Context;
import android.util.Log;


public class Set_setting extends File_IO  {
	
	public Set_setting(){}

	
	public int read_type_file(Context cotx) {
		// reads setup parameters from hs_setup.csv file in Vars.Setup_path into GlobalAccess.Vars class
		// returns 0 if no error, otherwise error code reference
			
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
				//SensorInterfaceEngine.updateLogFile(error_log);
				e.printStackTrace();
				return 12; // unable to open file
			}
		    
		}	
		        	

	
}
