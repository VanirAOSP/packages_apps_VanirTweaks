//Nuclearmistake 2012
//originally based on DPIChanger (http://code.innodroid.com/dpichanger)

package com.vanir.tweaksettings;

import java.io.IOException;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.RootToolsException;

import java.util.ArrayList;
import java.util.LinkedList;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

@SuppressLint("ParserError")
public abstract class BaseTask extends AsyncTask<Void, Void, LinkedList<IndividualSetting>> {
	private Context mContext;
	private ProgressDialog mProgressDialog;
	protected static LinkedList<IndividualSetting> values;	
	
	public BaseTask(Context context) {
		mContext = context;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		
		mProgressDialog = ProgressDialog.show(mContext, null, "Please Wait", true, false);
	}
	
	@Override
	protected void onPostExecute(LinkedList<IndividualSetting> result) {		
		super.onPostExecute(result);		
	}
	
	@Override
	protected void onCancelled() {
		super.onCancelled();

		mProgressDialog.dismiss();
	}
	
    protected void copyFileAsRoot(String src, String dest) throws IOException, InterruptedException, RootToolsException {
	    RootTools.sendShell("cp -f " + src + " " + dest + "\n");
	    RootTools.sendShell("chmod 777 " + dest + "\n");
    }    	
}

