package control;

import java.util.ArrayList;
import java.util.List;

import model.Access;
import android.util.Log;


public class Register_file extends File_IO  {
	
	
	
	public Register_file(){
		
	}
	
	public int write_to_file (List<String[]> Register_records) {
		String path = Vars.Register_path;
		try {
			
			String [] content = new String[29999];
			int i = 0;
			for(int j=0 ; j<Register_records.size() ; j++){
				String [] temp = Register_records.get(j); 
				content[i++] = "_________________,___________,"+temp[13]+",___________,_________________,;";
				content[i++] = "Inlet Pressure," +temp[1]+ ";";
				content[i++] = "Inlet Temprature," + temp[2] + ";";
				content[i++] = "Outlet Pressure," + temp[3] + ";";
				content[i++] = "Application," + temp[4] + ";";
				content[i++] = "Type," +temp[5] + ";";
				content[i++] = "Position," + temp[6] + ";";
				content[i++] = "Connection," + temp[7] + ";";
				content[i++] = "Size," + temp[8] + ";";
				content[i++] = "Ancillary Equipment," + temp[9] + ";";
				content[i++] = "Company," + temp[10] + ";";
				content[i++] = "Nots," + temp[11] + ";";
				content[i++] = "Attachment," + temp[12] + ";";
			}
			this.writeToFile(path, content ,i);
			return 0;
		} catch (Exception e) {
			String error_log = "SetupParams_IO; write_to_file; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
			Log.e("KTV_error", error_log);
			e.printStackTrace();
			return 1;
		} 
	}	

}
