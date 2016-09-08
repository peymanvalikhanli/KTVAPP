package cyberdev.datagathering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import control.GlobalAccess;
import control.Vars;
import control.ui;
import android.R.string;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import model.Access;

public class Slector extends Activity{
	
	LinearLayout ll_selector;
	
	Button btn_ok;
	
	TextView lbl_selector;
	
	//CheckBox cb ;
	
	List<CheckBox> lst_check_box ;
	
	List<String> items_checkbox;
	
	List<String[]> items_type;
	
	int page_type; // is anssi or type
	
	int type_id;
	
	Access access = new Access(this);
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_slector);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		GlobalAccess.ui = new ui(width, height);
		
		// ___________________init cols GUI
				int col2 = 370;
				// ___________________init rows GUI
				int row14 = 1398;
				// ______________________
				int w_btn = 252;
				int h_btn = 144;
				// ____________________init font_face
				Typeface Bnazanin = Typeface.createFromAsset(getAssets(),
						"font/BNazanin.ttf");
				// ____________________init GUI	
				
				lbl_selector = (TextView) findViewById(R.id.lbl_selector);
				lbl_selector = ui.textview(lbl_selector, 400, 10, 60);
				lbl_selector.setTypeface(Bnazanin);
				
				
				//________________
				btn_ok = (Button) findViewById(R.id.btn_ok_selector);
				btn_ok = ui.button(btn_ok, w_btn, h_btn, col2, row14);
				btn_ok.setOnClickListener(btn_ok_onclick);
				
		
		ll_selector = (LinearLayout) findViewById(R.id.linearlayout_selector);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
	            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		page_type = getIntent().getExtras().getInt("selector");
		
		
		
		
		
		if(page_type==1){
			
			lbl_selector.setText("Type");
			type_id = getIntent().getExtras().getInt("type_id");
			items_type = access.get_Type(type_id);
			items_checkbox=new ArrayList<String>(); 
		        for(int i=0 ; i<items_type.size(); i++){
		        	items_checkbox.add(items_type.get(i)[1]); 
		        }
		    
					
		}else{
			//items_checkbox.clear();
			lbl_selector.setText("Ancillary");
			items_checkbox = access.get_Ancillary();
		}
		
			
		try{
			lst_check_box = new ArrayList<CheckBox>(); 
			for( int j=0 ; j < items_checkbox.size() ; j++){
				
				LinearLayout ll = new LinearLayout(getApplicationContext());
				ll.setOrientation(LinearLayout.VERTICAL);
				
				//-----checkbox
				CheckBox cb = new CheckBox(getApplicationContext());
				//cb.setId(id);
				cb.setText(items_checkbox.get(j));
				cb.setTextColor(getResources().getColor(R.color.white_color));
				cb.setLayoutParams(params);
				lst_check_box.add(cb);
				 
				ll.addView(cb);
				ll_selector.addView(ll);
				
			}
		}
		catch(Exception e){
			 
		}
		
		
	}
	
	private void check_checkBoxs(){
		String tem = ""; 
		try{
			for(int i=0 ; i<lst_check_box.size(); i++){
				CheckBox chk_tem =  lst_check_box.get(i); 
				if(chk_tem.isChecked()){
					tem += chk_tem.getText().toString() + " , ";
				}
			}
			
			if (page_type==1){
				Vars.Type += tem;
			}else{
				Vars.Ancillary_Equipment += tem;
			}
		}catch (Exception e) {
			
		}
		
	}
	
	OnClickListener btn_ok_onclick = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			check_checkBoxs();
	    	Slector.this.finish(); 
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.slector, menu);
		return true;
	}

}
