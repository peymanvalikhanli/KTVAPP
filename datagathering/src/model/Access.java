package model;

import java.util.ArrayList;
import java.util.List;

import control.Vars;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

public class Access {

	
	Database db; 
	
	public Access(Context cotx){
		db=new Database("ktv_data_setting_v1", cotx); 
	}
	
	public void create_all_tbl(){
		
		db.create_table("Pressure_unit", "id INTEGER PRIMARY KEY AUTOINCREMENT, unit TEXT NOT NULL");
		db.create_table("Setting", "'id' INTEGER PRIMARY KEY AUTOINCREMENT, 'data_set' INTEGER NOT NULL, 'V_Export' INTEGER NOT NULL");
		db.create_table("Application", "'id' INTEGER PRIMARY KEY,'name' TEXT NOT NULL,'parent' INTEGER NOT NULL");
		db.create_table("Temprature_unit", "id INTEGER PRIMARY KEY AUTOINCREMENT,unit TEXT NOT NULL");
		db.create_table("Type", "'id' INTEGER PRIMARY KEY,'name' TEXT NOT NULL,'parent' INTEGER NOT NULL");
		db.create_table("Company", "id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL");
		db.create_table("Ancillary", "id INTEGER PRIMARY KEY,name TEXT NOT NULL");
		db.create_table("Position", "id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL");
		db.create_table("Connection", "id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL");
		db.create_table("Size", "'id' INTEGER PRIMARY KEY AUTOINCREMENT,'name' TEXT NOT NULL,'parent' INTEGER NOT NULL");

	}
	
	public void setdefult(){
		db.insert("Pressure_unit", "unit", "'psi'");
		db.insert("Pressure_unit", "unit", "'bar'");
		db.insert("Pressure_unit", "unit", "'pa'");
		//================Temprature_unit====================
		db.insert("Temprature_unit","unit", "'C'");
		db.insert("Temprature_unit","unit", "'F'");
		/*
		//================Application=======================
		db.insert("Application", "name , parent", "'Drip',0");
		db.insert("Application", "name , parent", "'Heating',0");
			db.insert("Application", "name , parent", "'Equipment(Heat exchenger)' , 2");
			db.insert("Application", "name , parent", "'Process equipment' , 2");
		db.insert("Application", "name , parent", "'Tracing',0");
			db.insert("Application", "name , parent", "'Non-critical' , 3");
			db.insert("Application", "name , parent", "'Critical' , 3");
		db.insert("Application", "name , parent", "'Rotating Equipment' , 0");
			db.insert("Application", "name , parent", "'Psitive pressure' , 4");
			db.insert("Application", "name , parent", "'Negative pressure' , 4");
		//================Type==============================
		db.insert("Type", "name , parent", "'Thermostatic' , 0");
			db.insert("Type", "name , parent", "'Balanced Pressure' , 1");
			db.insert("Type", "name , parent", "'Bimetallic' , 1");
			db.insert("Type", "name , parent", "'Liquid Expansion' , 1");
		db.insert("Type", "name , parent", "'Mechanical' ,0");
			db.insert("Type", "name , parent", "'Free Float' , 2");
			db.insert("Type", "name , parent", "'Ball Float' , 2");
			db.insert("Type", "name , parent", "'Inverted bucket' , 2");
			db.insert("Type", "name , parent", "'Open top bucket' , 2");
		db.insert("Type", "name , parent", "'Thermo Dynamic' , 0");
			db.insert("Type", "name , parent", "'Disk Type' , 3");
			db.insert("Type", "name , parent", "'TD' , 3");
		db.insert("Type", "name , parent", "'Orifice Type' , 0");
		//=================Company==========================
		db.insert("Company", "name", "'MIYAWAKI'");
		db.insert("Company", "name", "'TLV'");
		db.insert("Company", "name", "'YARWAY'");
		db.insert("Company", "name", "'SPIRAXSARCO'");
		db.insert("Company", "name", "'ARMSTRONG'");
		db.insert("Company", "name", "'GESTRA'");
		db.insert("Company", "name", "'NICHOLSON'");
		db.insert("Company", "name", "'VELAN'");
		db.insert("Company", "name", "'ARI'");
		db.insert("Company", "name", "'AYVA2'");
		db.insert("Company", "name", "'TERMO'");
		db.insert("Company", "name", "'ZAMKON'");
		db.insert("Company", "name", "'MEPCO'");
		db.insert("Company", "name", "'HOFFMAN'");
		db.insert("Company", "name", "'ADCA'");
		db.insert("Company", "name", "'VALSTEAM'");
		db.insert("Company", "name", "'DOGLAS'");
		db.insert("Company", "name", "'PENANT'");
		//====================Ancillary================
		db.insert("Ancillary", "name", "'IV'");
		db.insert("Ancillary", "name", "'OV'");
		db.insert("Ancillary", "name", "'S'");
		db.insert("Ancillary", "name", "'CV'");
		db.insert("Ancillary", "name", "'BP'");
		db.insert("Ancillary", "name", "'SG'");
		db.insert("Ancillary", "name", "'DV'");
		*/
		//====================Position================
		db.insert("Position", "name", "'Vertical'");
		db.insert("Position", "name", "'Horizontal'");
		//====================Connection=============
		db.insert("Connection", "name", "'NPT'");
		db.insert("Connection", "name", "'SC'");
		db.insert("Connection", "name", "'Flange'");
		//======================Size=================
		db.insert("Size", "name , parent", "'Inch',0");
			db.insert("Size", "name , parent", "'1/8' , 1");
			db.insert("Size", "name , parent", "'1/4' , 1");
			db.insert("Size", "name , parent", "'3/8' , 1");
			db.insert("Size", "name , parent", "'1/2' , 1");
			db.insert("Size", "name , parent", "'3/4' , 1");
			db.insert("Size", "name , parent", "'1' , 1");
			db.insert("Size", "name , parent", "'1-1/4' , 1");
			db.insert("Size", "name , parent", "'1-1/2' , 1");
			db.insert("Size", "name , parent", "'2' , 1");
			db.insert("Size", "name , parent", "'2-1/2' , 1");
			db.insert("Size", "name , parent", "'3' , 1");
			db.insert("Size", "name , parent", "'3-1/2' , 1");
			db.insert("Size", "name , parent", "'4' , 1");
			db.insert("Size", "name , parent", "'5' , 1");
			db.insert("Size", "name , parent", "'6' , 1");
			db.insert("Size", "name , parent", "'8' , 1");
			db.insert("Size", "name , parent", "'10' , 1");
			db.insert("Size", "name , parent", "'12' , 1");
		db.insert("Size", "name , parent", "'MM',0");
			db.insert("Size", "name , parent", "'6MM' , 2");
			db.insert("Size", "name , parent", "'8MM' , 2");
			db.insert("Size", "name , parent", "'12MM' , 2");
			db.insert("Size", "name , parent", "'15MM' , 2");
			db.insert("Size", "name , parent", "'20MM' , 2");
			db.insert("Size", "name , parent", "'25MM' , 2");
			db.insert("Size", "name , parent", "'32MM' , 2");
			db.insert("Size", "name , parent", "'40MM' , 2");
			db.insert("Size", "name , parent", "'50MM' , 2");
			db.insert("Size", "name , parent", "'65MM' , 2");
			db.insert("Size", "name , parent", "'75MM' , 2");
			db.insert("Size", "name , parent", "'90MM' , 2");
			db.insert("Size", "name , parent", "'100MM' , 2");
			db.insert("Size", "name , parent", "'125MM' , 2");
			db.insert("Size", "name , parent", "'150MM' , 2");
			db.insert("Size", "name , parent", "'200MM' , 2");
			db.insert("Size", "name , parent", "'250MM' , 2");
			db.insert("Size", "name , parent", "'300MM' , 2");
			
		db.insert("Size", "name , parent", "'DIN',0");
			db.insert("Size", "name , parent", "'DN15' , 3");
			db.insert("Size", "name , parent", "'DN25' , 3");
			db.insert("Size", "name , parent", "'DN40' , 3");
			db.insert("Size", "name , parent", "'DN50' , 3");
		//============================================
		db.insert("Setting", "data_set , V_Export", "1 , 0");
	
	}
	
	
	
	public void update_v_export(int new_v_export){
		db.update("Setting", " V_Export="+new_v_export, "1");
	}

	public void insert_type(String name , String parent , String id){
		
		db.insert("Type", "id , name , parent", id + " , '"+name+"' , "+parent);
	}
	
	public void insert_company(String name){
		
		db.insert("Company", "name", "'"+name+"'");
	}
	
	public void insert_Application(String name , String parent , String id){
		
		db.insert("Application", "id , name , parent", id + " , '"+name+"' , "+parent);
	}
	
	public void insert_Ancillary(String name , String parent , String id){
	
	db.insert("Ancillary", "id , name , parent", id + " , '"+name+"' , "+parent);
	}
	
	public List<String[]> get_setting(){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Setting", "data_set = 1"); 
		
		try{
			
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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
	
	public void del_application(){
		
		db.delete("Application", "1=1");
	}
	
	public void del_type(){
		
		db.delete("Type", "1=1");
	}
	
	public void del_Ancillary(){
		
		db.delete("Ancillary", "1=1");
	}
	public void del_Company(){
		
		db.delete("Company", "1=1");
	}
	
	public List<String> get_Pressure_unit(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Pressure_unit", ""); 
		
		try{
			
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}

	public List<String> get_Temprature_unit(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Temprature_unit", ""); 
		
		try{
			
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}

	public List<String[]> get_Application(){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Application", "parent=0"); 
		
		try{
		
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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
	
	public List<String[]> get_Application(int parent){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Application", "parent="+parent); 
		
		try{
		
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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

	public List<String[]> get_Type(int parent){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Type", "parent="+parent); 
		
		try{
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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
	
	public List<String[]> get_Type(){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Type", "parent=0"); 
		
		try{ 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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
	
	public List<String> get_Company(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Company", ""); 
		
		try{
			 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}

	public List<String> get_Ancillary(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Ancillary", ""); 
		
		try{
			 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}

	public List<String> get_Position(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Position", ""); 
		
		try{
			 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}
	
	public List<String> get_Connection(){
		
		List<String> lst = new ArrayList<String>() ; 
		
		db.select("Connection", ""); 
		
		try{
			 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				lst.add(db.data_list.get(i)[1]);
			}
			return lst;
		}
		catch(Exception e ){
			//return e.getMessage();
			lst.clear();
			return lst; 
		}
		
	}

	public List<String[]> get_Size(int parent){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Size", "parent="+parent); 
		
		try{
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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
	
	public List<String[]> get_Size(){
		
		List<String[]> lst = new ArrayList<String[]>() ; 
		
		db.select("Size", "parent=0"); 
		
		try{ 
			for(int i =0 ; i<db.data_list.size();i++)
			{
				String[] item = new String[2]; 
				item[0]=db.data_list.get(i)[0];
				item[1]=db.data_list.get(i)[1]; 
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


