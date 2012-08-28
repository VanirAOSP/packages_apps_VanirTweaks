package com.vanir.tweaksettings;
import java.util.LinkedList;
import java.util.HashMap;

public class IndividualSetting {
	public String prefix;
	public String current;
	public String defaultval;
	public String description;
	public Constants.cattype category;
	public Constants.valtype type;
	private static HashMap<String,IndividualSetting> _instances;	
	public IndividualSetting(Constants.cattype c, Constants.valtype t, String _prefix, String _description)
	{
		if (_instances == null)
			_instances = new HashMap<String, IndividualSetting>();
		int eq = _prefix.indexOf('=');
		category = c;
		type = t;
		prefix = _prefix.substring(0,eq);
		defaultval = _prefix.substring(eq+1);
		description = _description;
		_instances.put(prefix, this);
	}
	public static void parse(String line)
	{
		int eq = line.indexOf('=');
		String pf = line.substring(0,eq);
		if (_instances.containsKey(pf))
			_instances.get(pf)._parse(line);
	}
	private void _parse(String line) { _parse(line, -1);}
	private void _parse(String line, int eq)
	{
		if (eq == -1)
			eq = line.indexOf('=');
		current = line.substring(eq+1);		
	}
	public static LinkedList<IndividualSetting> getLinkedList()
	{
		LinkedList<IndividualSetting> list = new LinkedList<IndividualSetting>();
		list.addAll(_instances.values());
		return list;
	}	
	@Override
	public String toString() {
		return ""+prefix+"="+current;
	}
}
