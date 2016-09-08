package cyberdev.datagathering;




import control.GlobalAccess;
import control.Vars;
import control.ui;
import model.Access;
import model.DataEntry;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity{

	
	TextView lbl_register;
	TextView lbl_Inlet_pressure;
	TextView lbl_Inlet_temprature;
	TextView lbl_Outlet_pressure;
	TextView lbl_Application;
	TextView lbl_Type;
	TextView lbl_Position;
	TextView lbl_Connection;
	TextView lbl_Size;
	TextView lbl_Ancillary_Equipment;
	TextView lbl_Company;
	TextView lbl_Other;
	TextView lbl_Attachment;
	TextView txt_attachment_files ; 

	EditText txt_Inlet_pressure;
	EditText txt_Inlet_temprature;
	EditText txt_Outlet_pressure;
	EditText txt_Other;

	Spinner spi_Inlet_pressure;
	Spinner spi_Inlet_temprature;
	Spinner spi_Outlet_pressure;
	Spinner spi_Application;
	Spinner spi_Application1;
	Spinner spi_Type;
	Spinner spi_Position;
	Spinner spi_Connection;
	Spinner spi_Size;
	Spinner spi_Size1;
	Spinner spi_Ancillary_Equipment;
	Spinner spi_Company;

	Button btn_save;
	Button btn_return;
	Button btn_clear;
	Button btn_Attachment;
	
	List<String> items_inlet_presure;
	List<String> items_inlet_temprature ;
	List<String> items_outlet_pressure ;
	List<String[]> items_application ;
	List<String[]> items_application1 ;
	List<String[]> items_type ;
	List<String> items_position ;
	List<String> items_connection ;
	List<String[]> items_size ;
	List<String[]> items_size1 ;
	List<String> items_ancillary_equipment;
	List<String> items_company;
	 
	Access access = new Access(this);
	DataEntry data_reg = new DataEntry(this);
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_register);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		GlobalAccess.ui = new ui(width, height);

		// ___________________init cols GUI
		int col1 = 42;
		int col2 = 370;
		int col3 = 692;
		// ___________________init rows GUI
		int row1 = 98;
		int row2 = 198;
		int row3 = 298;
		int row4 = 398;
		int row5 = 498;
		int row6 = 598;
		int row7 = 698;
		int row8 = 798;
		int row9 = 898;
		int row10 = 998;
		int row11 = 1098;
		//int row12 = 1198;
		int row13 = 1298;
		int row14 = 1398;

		// ___________________
		int w_txt = 324;
		int h_txt = 72;
		// ___________________
		int w_spi_col3 = 252;
		int h_spi_col3 = 72;
		int w_spi_col2 = 324;
		int h_spi_col2 = 72;

		// ______________________
		int w_btn = 252;
		int h_btn = 144;
		// ____________________init font_face
		Typeface Bnazanin = Typeface.createFromAsset(getAssets(),
				"font/BNazanin.ttf");
		// ____________________init GUI

		lbl_register = (TextView) findViewById(R.id.lbl_register);
		lbl_register = ui.textview(lbl_register, 400, 10, 60);
		lbl_register.setTypeface(Bnazanin);

		lbl_Inlet_pressure = (TextView) findViewById(R.id.lbl_Inlet_pressure);
		lbl_Inlet_pressure = ui.textview(lbl_Inlet_pressure, col1, row1, 45);
		lbl_Inlet_pressure.setTypeface(Bnazanin);

		lbl_Inlet_temprature = (TextView) findViewById(R.id.lbl_Inlet_temprature);
		lbl_Inlet_temprature = ui
				.textview(lbl_Inlet_temprature, col1, row2, 45);
		lbl_Inlet_temprature.setTypeface(Bnazanin);

		lbl_Outlet_pressure = (TextView) findViewById(R.id.lbl_Outlet_pressure);
		lbl_Outlet_pressure = ui.textview(lbl_Outlet_pressure, col1, row3, 45);
		lbl_Outlet_pressure.setTypeface(Bnazanin);

		lbl_Application = (TextView) findViewById(R.id.lbl_Application);
		lbl_Application = ui.textview(lbl_Application, col1, row4, 45);
		lbl_Application.setTypeface(Bnazanin);

		lbl_Type = (TextView) findViewById(R.id.lbl_Type);
		lbl_Type = ui.textview(lbl_Type, col1, row5, 45);
		lbl_Type.setTypeface(Bnazanin);

		lbl_Position = (TextView) findViewById(R.id.lbl_Position);
		lbl_Position = ui.textview(lbl_Position, col1, row6, 45);
		lbl_Position.setTypeface(Bnazanin);

		lbl_Connection = (TextView) findViewById(R.id.lbl_Connection);
		lbl_Connection = ui.textview(lbl_Connection, col1, row7, 45);
		lbl_Connection.setTypeface(Bnazanin);

		lbl_Size = (TextView) findViewById(R.id.lbl_Size);
		lbl_Size = ui.textview(lbl_Size, col1, row8, 45);
		lbl_Size.setTypeface(Bnazanin);

		lbl_Ancillary_Equipment = (TextView) findViewById(R.id.lbl_Ancillary_Equipment);
		lbl_Ancillary_Equipment = ui.textview(lbl_Ancillary_Equipment, col1,
				row9, 45);
		lbl_Ancillary_Equipment.setTypeface(Bnazanin);

		lbl_Company = (TextView) findViewById(R.id.lbl_Company);
		lbl_Company = ui.textview(lbl_Company, col1, row10, 45);
		lbl_Company.setTypeface(Bnazanin);

		lbl_Other = (TextView) findViewById(R.id.lbl_Other);
		lbl_Other = ui.textview(lbl_Other, col1, row11, 45);
		lbl_Other.setTypeface(Bnazanin);

		lbl_Attachment = (TextView) findViewById(R.id.lbl_Attachment);
		lbl_Attachment = ui.textview(lbl_Attachment, col1, row13, 45);
		lbl_Attachment.setTypeface(Bnazanin);
		
		txt_attachment_files = (TextView) findViewById(R.id.txt_attachment_files);
		txt_attachment_files = ui.textview(txt_attachment_files, col3, row13, 50);
		//txt_attachment_files.setTypeface(Bnazanin);

		txt_Inlet_pressure = (EditText) findViewById(R.id.txt_Inlet_pressure);
		txt_Inlet_pressure = ui.edittext(txt_Inlet_pressure, w_txt, h_txt,
				col2, row1);

		txt_Inlet_temprature = (EditText) findViewById(R.id.txt_Inlet_temprature);
		txt_Inlet_temprature = ui.edittext(txt_Inlet_temprature, w_txt, h_txt,
				col2, row2);

		txt_Outlet_pressure = (EditText) findViewById(R.id.txt_Outlet_pressure);
		txt_Outlet_pressure = ui.edittext(txt_Outlet_pressure, w_txt, h_txt,
				col2, row3);

		txt_Other = (EditText) findViewById(R.id.txt_Other);
		txt_Other = ui.edittext(txt_Other, 584, 136, col2, row11);

		spi_Inlet_pressure = (Spinner) findViewById(R.id.spi_Inlet_pressure);
		spi_Inlet_pressure = ui.spinner(spi_Inlet_pressure, w_spi_col3,
				h_spi_col3, col3, row1);
		//text_spi_Inlet_pressure.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		spi_Inlet_temprature = (Spinner) findViewById(R.id.spi_Inlet_temprature);
		spi_Inlet_temprature = ui.spinner(spi_Inlet_temprature, w_spi_col3,
				h_spi_col3, col3, row2);

		spi_Outlet_pressure = (Spinner) findViewById(R.id.spi_Outlet_pressure);
		spi_Outlet_pressure = ui.spinner(spi_Outlet_pressure, w_spi_col3,
				h_spi_col3, col3, row3);

		spi_Application = (Spinner) findViewById(R.id.spi_Application);
		spi_Application = ui.spinner(spi_Application, w_spi_col2, h_spi_col2,
				col2, row4);

		spi_Application1 = (Spinner) findViewById(R.id.spi_Application1);
		spi_Application1 = ui.spinner(spi_Application1, w_spi_col3, h_spi_col2,
				col3, row4);

		spi_Type = (Spinner) findViewById(R.id.spi_Type);
		spi_Type = ui.spinner(spi_Type, w_spi_col2, h_spi_col2, col2, row5);
		//spi_Type.setOnTouchListener(type_select);
		spi_Type.setOnItemSelectedListener(onselected_type);
		
		spi_Position = (Spinner) findViewById(R.id.spi_Position);
		spi_Position = ui.spinner(spi_Position, w_spi_col2, h_spi_col2, col2,
				row6);

		spi_Connection = (Spinner) findViewById(R.id.spi_Connection);
		spi_Connection = ui.spinner(spi_Connection, w_spi_col2, h_spi_col2,
				col2, row7);

		spi_Size = (Spinner) findViewById(R.id.spi_Size);
		spi_Size = ui.spinner(spi_Size, w_spi_col2, h_spi_col2, col2, row8);

		spi_Size1 = (Spinner) findViewById(R.id.spi_Size1);
		spi_Size1 = ui.spinner(spi_Size1, w_spi_col3, h_spi_col2,
				col3, row8);

		
		spi_Ancillary_Equipment = (Spinner) findViewById(R.id.spi_Ancillary_Equipment);
		spi_Ancillary_Equipment = ui.spinner(spi_Ancillary_Equipment,
				w_spi_col2, h_spi_col2, col2, row9);
		 spi_Ancillary_Equipment.setOnTouchListener(select_ancillary);

		spi_Company = (Spinner) findViewById(R.id.spi_Company);
		spi_Company = ui.spinner(spi_Company, w_spi_col2, h_spi_col2, col2,
				row10);

		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_clear = ui.button(btn_clear, w_btn, h_btn, col2, row14);
		btn_clear.setOnClickListener(btn_clr);

		btn_return = (Button) findViewById(R.id.btn_return);
		btn_return = ui.button(btn_return, w_btn, h_btn, col1, row14);
		btn_return.setOnClickListener(btn_return_onclick);

		btn_save = (Button) findViewById(R.id.btn_save);
		btn_save = ui.button(btn_save, w_btn, h_btn, col3, row14);
		btn_save.setOnClickListener(btn_save_onclick);

		btn_Attachment = (Button) findViewById(R.id.btn_Attachment);
		btn_Attachment = ui.button(btn_Attachment, 100, 100, col2, row13);
		btn_Attachment.setOnClickListener(btn_attach);

		// btn_select = (Button) findViewById(R.id.btn_select);
		// btn_select = ui.button(btn_select, 100, 100, col2, row9);
		// btn_select.setOnClickListener(select);
		
		items_inlet_presure = new ArrayList<String>(); 
		items_inlet_temprature = new ArrayList<String>(); 
		items_outlet_pressure = new ArrayList<String>(); 
		items_application = new ArrayList<String[]>(); 
		items_application1 = new ArrayList<String[]>(); 
		items_type = new ArrayList<String[]>();
		items_position = new ArrayList<String>(); 
		items_connection = new ArrayList<String>(); 
		items_size = new ArrayList<String[]>(); 
		items_size1 = new ArrayList<String[]>();
		items_ancillary_equipment = new ArrayList<String>(); 
		items_company = access.get_Company();
		
		
		items_inlet_presure = access.get_Pressure_unit();
		items_inlet_temprature = access.get_Temprature_unit();
		items_outlet_pressure = access.get_Pressure_unit();
		items_application = access.get_Application();
		items_type = access.get_Type();
		items_position = access.get_Position();
		items_connection = access.get_Connection();
		items_size = access.get_Size();
		items_ancillary_equipment = access.get_Ancillary();
		items_company = access.get_Company();
		
		
		//________fill____spinner
		ArrayAdapter<String> adapter_inlet_presure = new ArrayAdapter<String>(this,
				        android.R.layout.simple_spinner_item, items_inlet_presure);
				
		adapter_inlet_presure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spi_Inlet_pressure.setAdapter(adapter_inlet_presure);
		
		ArrayAdapter<String> adapter_inlet_temprature = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_inlet_temprature);
		
		adapter_inlet_temprature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Inlet_temprature.setAdapter(adapter_inlet_temprature);
        
        ArrayAdapter<String> adapter_outlet_pressure = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_outlet_pressure);
		
        adapter_outlet_pressure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Outlet_pressure.setAdapter(adapter_outlet_pressure);
        
        List<String> aplication_tem = new ArrayList<String>(); 
        for(int i=0 ; i<items_application.size(); i++){
        	aplication_tem.add(items_application.get(i)[1]); 
        }
        
        ArrayAdapter<String> adapter_application = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, aplication_tem);
		
        adapter_application.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Application.setAdapter(adapter_application);
        spi_Application.setOnItemSelectedListener(onselected_application);
        
        List<String> type_tem = new ArrayList<String>(); 
        for(int i=0 ; i<items_type.size(); i++){
        	type_tem.add(items_type.get(i)[1]); 
        }
        
        ArrayAdapter<String> adapter_type = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, type_tem);
		
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Type.setAdapter(adapter_type);
        
        ArrayAdapter<String> adapter_position = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_position);
		
        adapter_position.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Position.setAdapter(adapter_position);
        
        ArrayAdapter<String> adapter_connection = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_connection);
		
        adapter_connection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Connection.setAdapter(adapter_connection);
        
        List<String> size_tem = new ArrayList<String>(); 
        for(int i=0 ; i<items_size.size(); i++){
        	size_tem.add(items_size.get(i)[1]); 
        }
        
        ArrayAdapter<String> adapter_size = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, size_tem);
		
        adapter_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Size.setAdapter(adapter_size);
        spi_Size.setOnItemSelectedListener(onselected_size);
        
      /*  ArrayAdapter<String> adapter_ancillary_equipment = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_ancillary_equipment);
		
        adapter_ancillary_equipment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Ancillary_Equipment.setAdapter(adapter_ancillary_equipment);
        */
        ArrayAdapter<String> adapter_company = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, items_company);
		
        adapter_company.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_Company.setAdapter(adapter_company);
		
		
        clr_form();

	}
	
	@Override
	protected void onResume() {
		
		super.onResume();

		if(Vars.Attachment == "" || Vars.Attachment == null){
			txt_attachment_files.setText("");
		}else{
			txt_attachment_files.setText("\ud83d\udcce");
		}
		return;
	}
	
	public void set_application_item(int parent){
	
		parent++; 
		items_application1 = access.get_Application(parent);
		
		List<String> aplication_tem = new ArrayList<String>(); 
	        for(int i=0 ; i<items_application1.size(); i++){
	        	aplication_tem.add(items_application1.get(i)[1]); 
	        }
	        
	        
	        
	        ArrayAdapter<String> adapter_application = new ArrayAdapter<String>(this,
			        android.R.layout.simple_spinner_item, aplication_tem);
			
	        adapter_application.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spi_Application1.setAdapter(adapter_application);
	        

	}
		
	public void set_size_item(int parent){
		
		parent++; 
		items_size1 = access.get_Size(parent);
		
		List<String> size_tem = new ArrayList<String>(); 
	        for(int i=0 ; i<items_size1.size(); i++){
	        	size_tem.add(items_size1.get(i)[1]); 
	        }
	        
	        ArrayAdapter<String> adapter_size1 = new ArrayAdapter<String>(this,
			        android.R.layout.simple_spinner_item, size_tem);
			
	        adapter_size1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spi_Size1.setAdapter(adapter_size1);
	        

	}
	
	AdapterView.OnItemSelectedListener onselected_size = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			set_size_item(position);			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
	
	};
	
	AdapterView.OnItemSelectedListener onselected_application = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			set_application_item(position);			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
	};
	
	AdapterView.OnItemSelectedListener onselected_type = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			if(GlobalAccess.type_parent_id==-1){
				GlobalAccess.type_parent_id=position+1;
			}else {
				
				Vars.Type = spi_Type.getSelectedItem().toString()+" , ";
				
				Intent intent = new Intent(Register.this, Slector.class);
				intent.putExtra("selector", 1);
				intent.putExtra("type_id", position+1);
				startActivity(intent);
				
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
			
		}
	
	};
	
	OnClickListener btn_attach = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(Register.this, Attachment.class);
			startActivity(intent);
			//--------------------------
			/*
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			
			startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
			*/
		}
	};
	
	OnClickListener select = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(Register.this, Slector.class);
			startActivity(intent);

		}
	};

	OnClickListener btn_return_onclick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Register.this.finish();
		}
	};
	
	OnClickListener btn_save_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			try {
				register_to_db();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	};
	
	OnTouchListener select_ancillary = new OnTouchListener() {

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
		 
			if (arg1.getAction() == (MotionEvent.ACTION_UP)
					&& arg1.getAction() != (MotionEvent.ACTION_OUTSIDE)) {
				Vars.Ancillary_Equipment=""; 
				Intent intent = new Intent(Register.this, Slector.class);
				intent.putExtra("selector", 2);
				intent.putExtra("type_id", 0);
				startActivity(intent);
			
			}
			return false;
		}
	};
	
	private void clr_form () {
		
		txt_Inlet_pressure.setText("");
		 txt_Inlet_temprature.setText("");
		 txt_Outlet_pressure.setText("");
		 txt_Other.setText("");
		 spi_Inlet_pressure.setSelected(false);
		 spi_Inlet_temprature.setSelected(false);
		 spi_Outlet_pressure.setSelected(false);
		 spi_Application.setSelected(false);
		 spi_Application1.setSelected(false);
		 spi_Type.setSelected(false);
		 spi_Position.setSelected(false);
		 spi_Connection.setSelected(false);
		 spi_Size.setSelected(false);
		 spi_Size1.setSelected(false);
		 spi_Ancillary_Equipment.setSelected(false);
		 spi_Company.setSelected(false);
		
		
	}
	
private void btn_Form_clr(){
		
		new AlertDialog.Builder(this)
	    .setTitle(R.string.save_info)
	    .setMessage(R.string.Do_you_clear)
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	clr_form();
	        	Toast.makeText(getApplicationContext(), R.string.cleared_form, 
						   Toast.LENGTH_LONG).show();	
	        }
	     })
	    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // do nothing
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	    .show();
	}
	
	OnClickListener btn_clr = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			 btn_Form_clr();
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	public boolean get_data_form(){
		
		Calendar c = Calendar.getInstance(); 
		int sec = c.get(Calendar.SECOND);
		int min = c.get(Calendar.MINUTE); 
		int hour = c.get(Calendar.HOUR);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int mon = c.get(Calendar.MONTH); 
		int yer = c.get(Calendar.YEAR); 
 
		try{
			
			Vars.Date = yer + "-" + mon + "-" + day + "-" + hour + "-" + min + "-" + sec ; 
			 
			Vars.Inlet_pressure = txt_Inlet_pressure.getText().toString() + "," ;
			Vars.Inlet_pressure += spi_Inlet_pressure.getSelectedItem().toString() + "," ; 
			 
			Vars.Inlet_temprature = txt_Inlet_temprature.getText().toString() + "," ; 
			Vars.Inlet_temprature += spi_Inlet_temprature.getSelectedItem().toString() + "," ;
			
			Vars.Outlet_pressure = txt_Outlet_pressure.getText().toString() + ",";
			Vars.Outlet_pressure += spi_Outlet_pressure.getSelectedItem().toString() + ",";
			
			Vars.Application = spi_Application.getSelectedItem().toString() + "," ; 
			Vars.Application += spi_Application1.getSelectedItem().toString() + "," ; 
			
			//_______Type Complete in selection activity
			
			Vars.Position = spi_Position.getSelectedItem().toString() + "," ;
			
			Vars.Connection = spi_Connection.getSelectedItem().toString() + "," ; 
			
			Vars.Size = spi_Size.getSelectedItem().toString() + "," ;
			Vars.Size += spi_Size1.getSelectedItem().toString() + "," ;
			
			//_______Ancill Complete in selection activity
			//Vars.Ancillary_Equipment = spi_Ancillary_Equipment.getSelectedItem().toString() + "," ; 
			
			Vars.Company = spi_Company.getSelectedItem().toString() + "," ; 
			
			
			Vars.Nots = txt_Other.getText().toString() + "," ;
		
			if(Vars.Type==null || Vars.Ancillary_Equipment == null || Vars.Attachment == null  ){
				return false;				
			}
			
			return true;
		
		}
		catch(Exception e ){
			return false;
		}
	}
	
	public void register_to_db(){
        
		if(get_data_form()){		
			//_____________
			
			new AlertDialog.Builder(this)
		    .setTitle(R.string.save_info)
		    .setMessage(R.string.Do_you_saving)
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 

		        	//Register_file reg_file = new Register_file(); 
			       
			        int result = data_reg.insert_Register(); ///reg_file.write_to_file();
			        if (result == 1 ) {// is register file
			       	 clr_form();
			       	 Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
			       
			        }
		        }
		     })
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
		}else{
			new AlertDialog.Builder(this)
		    .setTitle(R.string.save_info)
		    .setMessage(R.string.plz_complete_frm)
		    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 

		        	
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
			
		}
	 }
	
}

