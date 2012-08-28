//Nuclearmistake 2012
//originally based on DPIChanger (http://code.innodroid.com/dpichanger)
package com.vanir.tweaksettings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import android.content.Context;

public class SetupTask extends BaseTask {

	public interface SetupTaskHandler {
		void onSetupComplete();
	}
	
	private SetupTaskHandler mHandler;
	
	public SetupTask(Context context, SetupTaskHandler handler) {
		super(context);
		mHandler = handler;
	}
	
	@Override
	protected LinkedList<IndividualSetting> doInBackground(Void... params) {
        try {
        	return parseDpiFromConfig();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void onPostExecute(LinkedList<IndividualSetting> result) {
		super.onPostExecute(result);
		mHandler.onSetupComplete();
	}
	
	private LinkedList<IndividualSetting> parseDpiFromConfig() throws IOException {
		String line;
		FileReader reader = new FileReader(new File(Constants.CONFIG_FILE_NAME));		
		BufferedReader buffer = new BufferedReader(reader);
		while ((line = buffer.readLine()) != null) {
			android.util.Log.v("VanirTweaks", "READ: "+line);
			IndividualSetting.parse(line);						
		}
		values = new LinkedList<IndividualSetting>();		
		values.addAll(IndividualSetting.getLinkedList());		
		buffer.close();
		reader.close();
		return values;
	}
}
