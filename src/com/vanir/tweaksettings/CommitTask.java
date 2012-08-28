//Nuclearmistake 2012
//originally based on DPIChanger (http://code.innodroid.com/dpichanger)
package com.vanir.tweaksettings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import android.content.Context;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.RootToolsException;

public class CommitTask extends BaseTask {
	public interface CommitTaskHandler {
		void onCommitComplete(boolean result);
	}

	private CommitTaskHandler mHandler;

	public CommitTask(Context context, CommitTaskHandler handler) {
		super(context);
		mHandler = handler;
	}

	@Override
	protected LinkedList<IndividualSetting> doInBackground(Void... params) {
		if (!RootTools.remount("/system", "rw"))
			return null;
		android.util.Log.d("VanirTweaks", "SYSRW");
		copyBackToSystem();
		if (!RootTools.remount("/system", "ro"))
			return null;
		android.util.Log.d("VanirTweaks", "SYSRO");
		return values;
	}

	private void copyBackToSystem() {
		try {
			doCopyBackToSystem();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void doCopyBackToSystem() throws IOException,
		InterruptedException, RootToolsException {
		android.util.Log.d("VanirTweaks", "chmod");
		RootTools.sendShell("chmod 777 " + Constants.CONFIG_FILE_NAME + "\n");

		//FileWriter writer = new FileWriter(	new File(Constants.CONFIG_FILE_NAME), false);

		for(int i=0;i<values.size();i++)
		{
			android.util.Log.d("VanirTweaks", values.get(i).toString());
			//writer.write(values.get(i).toString()+"\n");
		}		

		//writer.flush();
		//writer.close();
		
		android.util.Log.d("VanirTweaks", "CHMODING BACK");
		RootTools.sendShell("chmod 644 " + Constants.CONFIG_FILE_NAME + "\n");
	}

	@Override
	protected void onPostExecute(LinkedList<IndividualSetting> result) {
		super.onPostExecute(result);
		mHandler.onCommitComplete(result.size() > 0);
	}
}
