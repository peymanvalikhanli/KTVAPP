package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.provider.OpenableColumns;
import android.util.Log;

public abstract class File_IO {

	public String[] readFromFile(String file_name) throws IOException {
		BufferedReader reader = null;
		String[] result = new String[100];

		// File dir = getFilesDir();
		
			File myFile = new File(file_name);
			FileInputStream fIn = new FileInputStream(myFile);
			reader = new BufferedReader(new InputStreamReader(fIn));

			// do reading, usually loop until end of file reading
			String mLine;
			int index = 0;
			while ((mLine = reader.readLine()) != null) {
				result[index] = mLine;
				index++;
			}
			
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// log the exception
				}
			}
		return result;
	}

	public void writeToFile(String file_name, String[] content , int count) {
		// File file = new File(file_name);
		// file.delete();

		try {
			File myFile = new File(file_name);
			myFile.createNewFile();
			
			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			// myOutWriter.
			// myOutWriter.append(txtData.getText());
			for (int i = 0 ; i < count ; i++){
				
				myOutWriter.append(content[i]);
				myOutWriter.append("\r\n");
				// myOutWriter.w
				// myOutWriter.write(System.getProperty("line.separator"));
			}

			myOutWriter.close();
			fOut.close();

		} catch (Exception e) {
			String error_log = "File_IO; writeToFile; e.toString():" + e.toString() + "\n e.getMessage():" + e.getMessage() + "\n e.getLocalizedMessage():" + e.getLocalizedMessage();
			Log.e("hipsafe_error", error_log);
			e.printStackTrace();
		}

	}

	public String joinArray(String[] array, String spliter) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += array[i];
			if (i < (array.length - 1)) result += spliter;
		}
		return result;
	}

}
