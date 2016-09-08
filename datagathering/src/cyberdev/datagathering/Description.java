package cyberdev.datagathering;

import control.GlobalAccess;
import control.Vars;
import control.ui;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Description extends Activity {


	TextView lbl_title ; 
	TextView txt_dec; 
	
	Button btn_return;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_description);

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
		int row2 = 198;
		int row5 = 498;
		// ______________________
		int w_btn = 252;
		int h_btn = 144;

		// ____________________init font_face
		Typeface Bnazanin = Typeface.createFromAsset(getAssets(),
				"font/BNazanin.ttf");
		// ____________________init GUI

		lbl_title = (TextView) findViewById(R.id.lbl_title);
		lbl_title = ui.textview(lbl_title, 400, 10, 60);
		lbl_title.setTypeface(Bnazanin);
		
		txt_dec = (TextView) findViewById(R.id.txt_dec);
		txt_dec = ui.textview(txt_dec , col1 , row5 , 45);
		txt_dec.setTypeface(Bnazanin);
		
		
		
		btn_return = (Button) findViewById(R.id.btn_return);
		btn_return = ui.button(btn_return, w_btn, h_btn, col1, row2);
		btn_return.setOnClickListener(btn_return_onclick);
		
		int page_type =Vars.page_type;

		switch (page_type) {
		case 1:
			txt_dec.setText(Vars.Help);
			break;
		case 2: 
			txt_dec.setText(Vars.About);
			break;
		}
		
	}
	
	OnClickListener btn_return_onclick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Description.this.finish();
		}
	}; 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.description, menu);
		return true;
	}

}
