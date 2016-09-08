package model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Database {
	
	private SQLiteDatabase mydatabase ;
	private Context ctx;
	private String DB_name; 
	public String data ;
	final public List<String[]> data_list;
	
	public Database(String db_name, Context cotx){
		ctx=cotx; 
		DB_name=db_name;
		data_list=new ArrayList<String[]>(); 
	}
	
	private void open(){
		mydatabase =ctx.openOrCreateDatabase(DB_name, Context.MODE_PRIVATE ,null);
	}
	private void close(){
		mydatabase.close();
	}
		
	private void NonQuery(String TSQL){
		try{
			open();
			mydatabase.execSQL(TSQL);
			this.close(); 
		}
		catch(SQLException e){
			Log.w("KTV_SQL", e.getMessage());
		}
	}
	
	private Cursor CursorQuery(String TSQL  ){
		
		Cursor result;
		try{
			open();
			data_list.clear(); 
			result= mydatabase.rawQuery(TSQL,null);
			if (result.moveToFirst()) {
	            do {
	               // get  the  data into array,or class variable
	            	String[] str_tem=new String[result.getColumnCount()];  
	            	for(int i=0;i<result.getColumnCount();i++){
	            		str_tem[i]=result.getString(i);    		
	            	}
	            	data_list.add(str_tem);         	
	            } while (result.moveToNext());
	        }
			//data= "this data1 : "+username; //+" data2 : "+password;
			this.close(); 
		}
		catch(Exception e){
			result=null; 
		}
		return result;
	}
	
	public void create_table(String name , String cols){
		
		this.NonQuery("CREATE TABLE IF NOT EXISTS "+name+"("+cols+");");
	}
	
	public void insert(String table ,String cols ,String values){
		
		this.NonQuery("INSERT INTO "+table+"("+cols+") VALUES("+values+");"); 
	}
	
	public void update(String table ,String values , String where){
		
		this.NonQuery("UPDATE "+table+" SET "+values+" WHERE "+where+";"); 
	}
	
	public void delete(String table , String where){
		
		this.NonQuery("DELETE FROM "+table+" WHERE "+where+";"); 
	}
	
	public Cursor select(String table , String where){
		
		String sql="";
		
		if (where==""){
			sql="Select * from "+table+";"; 
		}
		else
		{
			sql="Select * from "+table+" WHERE "+where+";" ;
		}
		return this.CursorQuery(sql); 
		
	}
	
	
	
}
