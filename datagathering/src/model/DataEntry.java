package model;

import java.util.ArrayList;
import java.util.List;

import control.Vars;
import android.content.Context;
import android.util.Log;

public class DataEntry {
	
	
	Database db; 
	final int data_col_count = 15 ;
	
	public DataEntry(Context cotx){
		db=new Database("ktv_data_register_v1", cotx); 
	}
	
	public void create_table(){
		try{
			db.create_table("Register", "'id' INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "'Inlet_pressure' TEXT NULL,"
					+ "'Inlet_temprature' TEXT NULL,"
					+ "'Outlet_pressure' TEXT NULL,"
					+ "'Application' TEXT NULL,"
					+ "'Type' TEXT NULL,"
					+ "'Position' TEXT NULL,"
					+ "'Connection' TEXT NULL,"
					+ "'Size' TEXT NULL,"
					+ "'Ancillary_Equipment' TEXT NULL,"
					+ "'Company' TEXT NULL,"
					+ "'Nots' TEXT NULL,"
					+ "'Attachment' TEXT NULL,"
					+ "'Date' TEXT NULL,"
					+ "'V_Export' TEXT NULL");
			}catch(Exception e ){
				
				Log.w("ktv", "error:"+e.getMessage());
			}
	}
	
	public int  insert_Register(){
			
			try{
				db.insert("Register", 
					  "Inlet_pressure , "
					+ "Inlet_temprature , "
					+ "Outlet_pressure , "
					+ "Application , "
					+ "Type , "
					+ "Position , "
					+ "Connection , "
					+ "Size , "
					+ "Ancillary_Equipment , "
					+ "Company , "
					+ "Nots , "
					+ "Attachment , "
					+ "Date , "
					+ "V_Export",
					  "'"+Vars.Inlet_pressure+"' , "
					+ "'"+Vars.Inlet_temprature+"' , "
					+ "'"+Vars.Outlet_pressure+"' , "
					+ "'"+Vars.Application+"' , "
					+ "'"+Vars.Type+"' , "
					+ "'"+Vars.Position+"' , "
					+ "'"+Vars.Connection+"' , "
					+ "'"+Vars.Size+"' , "
					+ "'"+Vars.Ancillary_Equipment+"' , "
					+ "'"+Vars.Company+"' , "
					+ "'"+Vars.Nots+"' , "
					+ "'"+Vars.Attachment+"' , "
					+ "'"+Vars.Date+"' , "
					+ "'"+Vars.V_Export+"'");
				return 1; 
					
			}
			catch(Exception e){
				return 0;
			
			}
		}
		
	public List<String[]> get_Registers(){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Register","V_Export = '"+Vars.V_Export+"'"); 
		
		try{
		
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[data_col_count]; 
				for(int j=0 ; j<data_col_count ; j++){
					item[j]=db.data_list.get(i)[j];
				}
				lst.add(item);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}


}
