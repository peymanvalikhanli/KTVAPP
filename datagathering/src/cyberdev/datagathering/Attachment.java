package cyberdev.datagathering;

import java.io.File;
import java.io.IOException;

import control.GlobalAccess;
import control.Register_file;
import control.Vars;
import control.ui;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Attachment extends Activity {

	
	protected static final int PICK_IMAGE = 0;
	
	TextView lbl_attachment ; 
	TextView lst_attachments; 
	
	Button btn_Attachment ; 
	Button btn_Clear;
	Button btn_return;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_attachment);

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

		lbl_attachment = (TextView) findViewById(R.id.lbl_Attachment);
		lbl_attachment = ui.textview(lbl_attachment, 400, 10, 60);
		lbl_attachment.setTypeface(Bnazanin);
		
		lst_attachments = (TextView) findViewById(R.id.lst_Attachments);
		lst_attachments = ui.textview(lst_attachments , col1 , row5 , 45);
		lst_attachments.setTypeface(Bnazanin);
		if(Vars.Attachment == null){Vars.Attachment="";}
		lst_attachments.setText(Vars.Attachment);
		
		
		btn_Attachment = (Button) findViewById(R.id.btn_Attachment);
		btn_Attachment = ui.button(btn_Attachment , w_btn, h_btn , col3 , row2);
		btn_Attachment.setOnClickListener(btn_attach);		
		
		btn_Clear = (Button) findViewById(R.id.btn_clear);
		btn_Clear = ui.button(btn_Clear , w_btn , h_btn , col2 , row2);
		btn_Clear.setOnClickListener(btn_clear);	
		
		btn_return = (Button) findViewById(R.id.btn_return);
		btn_return = ui.button(btn_return, w_btn, h_btn, col1, row2);
		btn_return.setOnClickListener(btn_return_onclick);

	}
	
	OnClickListener btn_attach = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			Intent intent = new Intent();
			intent.setType("image/*");
			intent.setAction(Intent.ACTION_GET_CONTENT);
			
			startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
			
		}
	};
	
	OnClickListener btn_return_onclick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Attachment.this.finish();
		}
	};
	
	private void attachment_clr(){
		
		new AlertDialog.Builder(this)
	    .setTitle(R.string.save_info)
	    .setMessage(R.string.Do_you_clear)
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 

	        	lst_attachments.setText("");
				Vars.Attachment="";
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
			
	
	OnClickListener btn_clear = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			attachment_clr();
		}
	};

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	 
	    if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
	 
	        Uri uri = data.getData();
	 
	        try {
	        	File f =  new File(getRealPathFromURI(uri));

	            String imageName = f.getPath();
	        	lst_attachments.setText(lst_attachments.getText() + "\n" + imageName);
	        	Vars.Attachment += imageName + " , "; 
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private String getRealPathFromURI(Uri contentURI) {
	    String result;
	    Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
	    if (cursor == null) { // Source is Dropbox or other similar local file path
	        result = contentURI.getPath();
	    } else { 
	        cursor.moveToFirst(); 
	        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
	        result = cursor.getString(idx);
	        cursor.close();
	    }
	    return result;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.attachment, menu);
		return true;
	}

}
