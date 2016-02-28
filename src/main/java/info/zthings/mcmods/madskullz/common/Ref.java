package info.zthings.mcmods.madskullz.common;

import java.util.HashMap;

public abstract class Ref {
	public static final String MODID = "madskullz";
	public static final String VERSION = "1.0";
	
	public static final String DEBUG_SEPERATOR = "===============================================================";
	
	public static final HashMap<String, String> skullOwnerNames = new HashMap<String, String>();
	
	public static void init() {
		//buffer for shorter names in rest of code
		HashMap<String, String> son = new HashMap<String, String>();
		
		//TODO: fill regsiter
		
		//flush buffer
		skullOwnerNames.putAll(son);
	}
}
