package cyberdev.datagathering;

import model.Access;
import control.GlobalAccess;
import control.Set_setting;
import control.ui;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends Activity {

	TextView lbl_Setting;
	TextView lbl_Company;
	TextView lbl_Type;
	TextView lbl_Application;
	TextView lbl_Ancillary_Equipment;
	
	
	Button btn_Company;
	Button btn_Type;
	Button btn_Application;
	Button btn_Ancillary_Equipment;
	Button btn_return;
	
	Context contx ; 

	 Access access = new Access(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_setting);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		GlobalAccess.ui = new ui(width, height);

		
		contx = this; 
		
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
		lbl_Setting = (TextView) findViewById(R.id.lbl_setting);
		lbl_Setting = ui.textview(lbl_Setting, 400, 10, 60);
		lbl_Setting.setTypeface(Bnazanin);

		lbl_Type = (TextView) findViewById(R.id.lbl_Type);
		lbl_Type = ui.textview(lbl_Type, col1, row2, 45);
		lbl_Type.setTypeface(Bnazanin);

		lbl_Company = (TextView) findViewById(R.id.lbl_Company);
		lbl_Company = ui.textview(lbl_Company, col1, row4, 45);
		lbl_Company.setTypeface(Bnazanin);
		
		lbl_Application = (TextView) findViewById(R.id.lbl_Application);
		lbl_Application = ui.textview(lbl_Application, col1, row6, 45);
		lbl_Application.setTypeface(Bnazanin);
		
		lbl_Ancillary_Equipment = (TextView) findViewById(R.id.lbl_Ancillary_Equipment);
		lbl_Ancillary_Equipment = ui.textview(lbl_Ancillary_Equipment, col1, row8, 45);
		lbl_Ancillary_Equipment.setTypeface(Bnazanin);
		
		btn_Type = (Button) findViewById(R.id.btn_Type);
		btn_Type = ui.button(btn_Type, w_btn, h_btn, col3, row2);
		btn_Type.setOnClickListener(btn_type_save);
		
		btn_Company = (Button) findViewById(R.id.btn_Company);
		btn_Company = ui.button(btn_Company, w_btn, h_btn, col3, row4);
		btn_Company.setOnClickListener(btn_company_save);
		
		btn_Application = (Button) findViewById(R.id.btn_Application);
		btn_Application = ui.button(btn_Application, w_btn, h_btn, col3, row6);
		btn_Application.setOnClickListener(btn_application_save);
		
		btn_Ancillary_Equipment = (Button) findViewById(R.id.btn_Ancillary_Equipment);
		btn_Ancillary_Equipment = ui.button(btn_Ancillary_Equipment, w_btn, h_btn, col3, row8);
		btn_Ancillary_Equipment.setOnClickListener(btn_ancill_save);

		btn_return = (Button) findViewById(R.id.btn_return);
		btn_return = ui.button(btn_return, w_btn, h_btn, col1, row14);
		btn_return.setOnClickListener(btn_return_onclick);

		
	}

	OnClickListener btn_return_onclick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Setting.this.finish();
		}
	};

	OnClickListener btn_type_save = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			try{
				/*
				String name = txt_Type.getText().toString();
				access.insert_type(name);
				Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
				txt_Type.setText("");
				*/
				Set_setting set = new Set_setting(); 
				int result =set.read_type_file(contx); 
				if(result == 1){
					
					Toast.makeText(getApplicationContext(), R.string.done, Toast.LENGTH_LONG).show();
				}else{
					
					Toast.makeText(getApplicationContext(), R.string.not_find_file, Toast.LENGTH_LONG).show();
				}
				
			
			}
			catch(Exception e){
				
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		}
	};
	
OnClickListener btn_company_save = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			try{
				/*
				String name = txt_Company.getText().toString();
				access.insert_company(name);
				Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
				txt_Company.setText("");
				*/
				Set_setting set = new Set_setting(); 
				int result =set.read_company_file(contx); 
				if(result == 1){
					
					Toast.makeText(getApplicationContext(), R.string.done, Toast.LENGTH_LONG).show();
				}else{
					
					Toast.makeText(getApplicationContext(), R.string.not_find_file, Toast.LENGTH_LONG).show();
				}
				
				
			}
			catch(Exception e){
				
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		}
	};
OnClickListener btn_application_save = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			try{
				/*
				String name = txt_Company.getText().toString();
				access.insert_company(name);
				Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
				txt_Company.setText("");
				*/
				Set_setting set = new Set_setting(); 
				int result =set.read_application_file(contx); 
				if(result == 1){
					
					Toast.makeText(getApplicationContext(), R.string.done, Toast.LENGTH_LONG).show();
				}else{
					
					Toast.makeText(getApplicationContext(), R.string.not_find_file, Toast.LENGTH_LONG).show();
				}
			}
			catch(Exception e){
				
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		}
	};
OnClickListener btn_ancill_save = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			try{
				/*
				String name = txt_Company.getText().toString();
				access.insert_company(name);
				Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
				txt_Company.setText("");
				*/
				Set_setting set = new Set_setting(); 
				int result =set.read_ancill_file(contx); 
				if(result == 1){
					
					Toast.makeText(getApplicationContext(), R.string.done, Toast.LENGTH_LONG).show();
				}else{
					
					Toast.makeText(getApplicationContext(), R.string.not_find_file, Toast.LENGTH_LONG).show();
				}
			}
			catch(Exception e){
				
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

}
