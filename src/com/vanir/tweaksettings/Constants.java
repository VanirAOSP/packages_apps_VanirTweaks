//Nuclearmistake 2012
//originally based on DPIChanger (http://code.innodroid.com/dpichanger)
package com.vanir.tweaksettings;

import java.io.File;
import java.util.LinkedList;

import android.os.Environment;

public class Constants {
	public static final String CONFIG_FILE_NAME = "/etc/vanir.cfg";
	
	public enum valtype
	{
		tbool,
		tint,
		ttriple,
		tstring
	}
	public enum cattype
	{
		czoom,
		ccolor,
		csound,
		ctouchwake,		
		csr,
		cmisc
	}
	
	public LinkedList<IndividualSetting> Setup()
	{		
		IndividualSetting[] settings = new IndividualSetting[]{				
				new IndividualSetting(cattype.czoom, valtype.tint, "maxFreq=1200000", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.czoom, valtype.tint, "minFreq=350000", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.czoom, valtype.tstring, "scaleGov=aggressive", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.czoom, valtype.tbool, "hotPlug=1", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.czoom, valtype.tint, "gpuOC=0", "GPU Overclock Level"),		
												
				new IndividualSetting(cattype.ccolor, valtype.tint, "OMAPgamma=6", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.ccolor, valtype.ttriple, "GammaOffset=\"-6 0 8\"", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.ccolor, valtype.tbool, "ColorSafety=1", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.ccolor, valtype.ttriple, "ColorMult=\"2000000000 2000000000 20000000\"", "DESCRIBE THIS!"),
				
				new IndividualSetting(cattype.csound, valtype.tint, "VolBoost=0", "DESCRIBE THIS!"),
				new IndividualSetting(cattype.csound, valtype.tbool, "HighPerf=0", "DESCRIBE THIS!"),
				
				new IndividualSetting(cattype.ctouchwake, valtype.tbool, "TWstatus=0", "Enable/Disable TouchWake"),
				new IndividualSetting(cattype.ctouchwake, valtype.tint, "TWdelay=4500", "TouchWake delay"),
				
				new IndividualSetting(cattype.csr, valtype.tbool, "srCORE=1", "Enables or disables core SmartReflex"),
				new IndividualSetting(cattype.csr, valtype.tbool, "srMPU=1", "Enables or disbales MPU SmartReflex"),
				new IndividualSetting(cattype.csr, valtype.tbool, "srIVA=1", "Enables or disables IVA SmartReflex"),				
				
				new IndividualSetting(cattype.cmisc, valtype.tint, "BLX=100", "Battery Life \"maximum\""),
				new IndividualSetting(cattype.cmisc, valtype.tbool, "ffc=0", "Fast USB Charing at boot"),
				new IndividualSetting(cattype.cmisc, valtype.tstring, "wll=N", "DESCRIBE THIS!"),			
				new IndividualSetting(cattype.cmisc, valtype.tbool, "force_override_leantweaks=1", "DESCRIBE THIS!")
		};
		LinkedList<IndividualSetting> list = new LinkedList<IndividualSetting>();
		for(int i=0;i<settings.length;i++)
			list.add(settings[i]);
		return list;
	}
}
