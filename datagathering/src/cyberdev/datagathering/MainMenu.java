package cyberdev.datagathering;

import java.util.List;

import model.Access;
import model.DataEntry;
import control.GlobalAccess;
import control.Register_file;
import control.Vars;
import control.ui;
import android.os.Bundle;
import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {

	private TextView txt_main_mneu ; 
	private TextView txt_app_name ; 
	private ImageView img_logo; 
	private Button btn_register ; 
	private Button btn_help; 
	private Button btn_about ; 
	private Button btn_trasfer_server; 
	private Button btn_excel_export; 
	private Button btn_setting;
	private Button btn_exit; 

	Access access = new Access(this);
	DataEntry data_reg = new DataEntry(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main_menu);
		
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
	    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	    int height =displaymetrics.heightPixels;
	    int width =displaymetrics.widthPixels;
	    GlobalAccess.ui = new ui(width, height); 
		
		
	    //____________________
	    Typeface Bnazanin = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf"); 
	    
		//_____________init GUI
		int w_btn = 316; 
		int h_btn = 144; 
		int x_btn_1 = 504 ; 
		int x_btn_2 = 128; 
	    
		//________________txt app name 
		txt_app_name = (TextView) findViewById(R.id.txt_app_name);
		txt_app_name = ui.textview(txt_app_name, 321, 80, 80); 
		txt_app_name.setTypeface(Bnazanin);
		
		txt_main_mneu = (TextView) findViewById(R.id.txt_main_menu);
		txt_main_mneu = ui.textview(txt_main_mneu, 375, 584, 60);
		txt_main_mneu.setTypeface(Bnazanin);
		
		img_logo = (ImageView) findViewById(R.id.img_logo);
		img_logo = ui.image_view(img_logo, 320, 296, 327, 212); 
		
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_register = ui.button(btn_register, w_btn, h_btn, x_btn_1, 718); 
		btn_register.setOnClickListener(btn_register_onclick);
		
		btn_help = (Button) findViewById(R.id.btn_help);
		btn_help = ui.button(btn_help, w_btn, h_btn, x_btn_2, 718);
		btn_help.setOnClickListener(btn_help_onclick);

		btn_excel_export = (Button) findViewById(R.id.btn_excel_export);
		btn_excel_export = ui.button(btn_excel_export, w_btn, h_btn, x_btn_1, 934);
		btn_excel_export.setOnClickListener(btn_excel_export_onclick);

		btn_trasfer_server = (Button) findViewById(R.id.btn_transfer_server);
		btn_trasfer_server= ui.button(btn_trasfer_server, w_btn, h_btn, x_btn_2, 934); 
		
		btn_setting = (Button) findViewById(R.id.btn_setting);
		btn_setting=ui.button(btn_setting, w_btn, h_btn, x_btn_1, 1129); 
		btn_setting.setOnClickListener(btn_setting_onclick);
		
		btn_about = (Button) findViewById(R.id.btn_about);
		btn_about= ui.button(btn_about, w_btn, h_btn, x_btn_2, 1129); 
		btn_about.setOnClickListener(btn_abut_onclick);
		
		btn_exit = (Button) findViewById(R.id.btn_exit);
		btn_exit= ui.button(btn_exit, w_btn, h_btn, 317, 1364); 
		btn_exit.setOnClickListener(btn_exit_onclick);
		

	}
	
	OnClickListener btn_setting_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent( MainMenu.this , Setting.class);
	    	startActivity(intent);
		}
	};
	
	OnClickListener btn_register_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			 Intent intent = new Intent( MainMenu.this , Register.class);
		    	startActivity(intent);
		}
	};

	OnClickListener btn_exit_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			finish(); 
		}
	};
	
	
	OnClickListener btn_excel_export_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			try{
				Register_file reg_file = new Register_file(); 
			    
				List<String[]> Register_records = data_reg.get_Registers();
				
		        int result = reg_file.write_to_file(Register_records);
		        if (result == 0 ) {// is register file
			       	
			       	 Toast.makeText(getApplicationContext(),R.string.is_saved, Toast.LENGTH_LONG).show();
			       	 access.update_v_export(Integer.parseInt(Vars.V_Export)+1);
			    }
			}catch(Exception e){}
			
		}
	};
	
	OnClickListener btn_abut_onclick= new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(MainMenu.this, Description.class);
			Vars.page_type=2; 
			startActivity(intent);
		}
	};
	
	OnClickListener btn_help_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(MainMenu.this, Description.class);
			Vars.page_type=1;
			startActivity(intent);
		}
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
