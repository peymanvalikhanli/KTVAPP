package cyberdev.datagathering;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

import model.Access;
import model.DataEntry;
import control.GlobalAccess;
import control.Vars;
import control.ui;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {


	static String consol_text = ""; 
	int width; 
	int height; 
	TextView txt;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //______________Setup General Application Window Design
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main);
        DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics( displaymetrics );
		height = displaymetrics.heightPixels;
		width = displaymetrics.widthPixels;
		
		//______________Setup Loading Page Window Design
        ProgressBar pr = (ProgressBar) findViewById( R.id.progressBar1 );
        AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) pr.getLayoutParams();
	    position.x =(width- position.width) / 2;
	    position.y =(height - position.height) / 2;
	    pr.setLayoutParams(position);
	    txt = (TextView) findViewById(R.id.txt_loading);
	    
	    //______________init ui class 
	    GlobalAccess.ui= new ui(width,height);
	    
	    //_____________create database
	    	Access access = new Access(this);
	    	DataEntry data_reg = new DataEntry(this);
	    	List<String[]> setting_list = new ArrayList<String[]>(); 
	    	try{
	    		 setting_list = access.get_setting();
	    		 data_reg.create_table();
	    	
	    	}catch(Exception e){}
	    	
	    	if(setting_list.size()>0){
	    		String[] tem = setting_list.get(0); 
	    		Vars.V_Export = tem[1];
	    	}
	    	else{ 
	    		access.create_all_tbl();
		    	access.setdefult();
	    	}
	    //_____________end create database 
	    
	 /*   	
	    	//_________________ test register
	    	
			Vars.Date = "date"; 
			 
			Vars.Inlet_pressure = "Inlet_pressure," ;
			Vars.Inlet_pressure += "Inlet_pressure," ; 
			
			Vars.Inlet_temprature = "Inlet_temprature," ; 
			Vars.Inlet_temprature += "Inlet_temprature," ;
			
			Vars.Outlet_pressure = "Outlet_pressure,"; 
			Vars.Outlet_pressure = "Outlet_pressure,"; 
			
			Vars.Application = "Application," ; 
			Vars.Application += "Application," ; 
			
			//_______Type Complete in selection activity
			
			Vars.Position = "Position," ;
			
			Vars.Connection = "Connection," ; 
			
			Vars.Size = "Size," ;
			Vars.Size += "Size," ;
			
			//_______Ancill Complete in selection activity
			Vars.Ancillary_Equipment = "Ancillary_Equipment," ; 
			
			Vars.Company = "Company," ; 
			
			
			Vars.Nots = "Nots," ;
	    	
			Vars.Type = "Type,"; 
			
			Vars.Attachment = "Attachment,";
			
			data_reg.insert_Register();
			
	   //____________ end test  */	
	    
	    Handler h = new Handler(); 
	    h.postDelayed(timer, 1000);
    }

    
    Runnable timer = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
		    Intent intent = new Intent(MainActivity.this, MainMenu.class);
	    	startActivity(intent);
	    	MainActivity.this.finish(); 

		}
	};
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
